package com.cognizant.onlinefooddeliverysystem.service.implimentation;

import com.cognizant.onlinefooddeliverysystem.dto.search.PaginationDto;
import com.cognizant.onlinefooddeliverysystem.dto.search.SearchResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.search.SearchResultItemDto;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import com.cognizant.onlinefooddeliverysystem.model.MenuItems; // Corrected import
import com.cognizant.onlinefooddeliverysystem.repository.MenuItemRepository;
import com.cognizant.onlinefooddeliverysystem.repository.RestaurantRepository;
import com.cognizant.onlinefooddeliverysystem.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Added for clarity

// Removed java.awt.* import as it seemed unused
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor // Constructed service with required repositories via Lombok.
public class SearchServiceImpl implements SearchService {

    // Injected final repository fields.
    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;

    /**
     * Performs a search for restaurants and menu items based on a query string.
     * Combines results and provides basic pagination information.
     *
     * @param query The search term entered by the user.
     * @param page  The requested page number (1-based).
     * @param limit The maximum number of results per page.
     * @return A DTO containing the combined search results and pagination details.
     */
    @Override
    @Transactional(readOnly = true) // Initiated read-only transaction.
    public SearchResponseDto performSearch(String query, int page, int limit) {
        // Created Pageable object for repository queries (0-based index adjusted).
        Pageable pageable = PageRequest.of(page - 1, limit);

        // Initiated asynchronous search for restaurants.
        CompletableFuture<Page<Restaurant>> restaurantFuture = CompletableFuture.supplyAsync(() ->
                restaurantRepository.searchByName(query, pageable) // Assuming searchByName exists.
        );

        // Initiated asynchronous search for menu items.
        CompletableFuture<Page<MenuItems>> menuItemFuture = CompletableFuture.supplyAsync(() ->
                menuItemRepository.searchByNameOrDescription(query, pageable)
        );

        // Waited for both asynchronous searches to complete.
        CompletableFuture.allOf(restaurantFuture, menuItemFuture).join();

        // Retrieved results from completed futures.
        Page<Restaurant> restaurantPage = restaurantFuture.join();
        Page<MenuItems> menuItemPage = menuItemFuture.join();

        // Mapped Restaurant entities to SearchResultItemDto list.
        List<SearchResultItemDto> restaurantDtos = restaurantPage.getContent().stream()
                .map(r -> new SearchResultItemDto(
                        r.getRestId(),
                        r.getName(),
                        r.getRating(),
                        r.getAddress(),
                        r.getImgUrl()))
                .toList(); // Collected into an immutable list.

        // Mapped MenuItems entities to SearchResultItemDto list, utilizing JOIN FETCH for restaurant details.
        List<SearchResultItemDto> menuItemDtos = menuItemPage.getContent().stream()
                .map(mi -> new SearchResultItemDto(
                        mi.getItemId(),
                        mi.getName(),
                        mi.getDescription(),
                        mi.getPrice(),
                        mi.getRestaurant().getRestId(), // Accessed joined restaurant data.
                        mi.getRestaurant().getName(),   // Accessed joined restaurant data.
                        mi.getImgUrl()))
                .toList(); // Collected into an immutable list.

        // Initialized combined results list.
        List<SearchResultItemDto> combinedResults = new ArrayList<>();
        // Added restaurant DTOs to combined list.
        combinedResults.addAll(restaurantDtos);
        // Added menu item DTOs to combined list.
        combinedResults.addAll(menuItemDtos);

        // Calculated total results by summing elements from both pages.
        long totalResults = restaurantPage.getTotalElements() + menuItemPage.getTotalElements();
        // Calculated total pages based on combined total and limit.
        int totalPages = (int) Math.ceil((double) totalResults / limit);

        // Truncated the combined list to the requested page limit for the final response.
        List<SearchResultItemDto> finalResults = combinedResults.stream().limit(limit).toList();

        // Created pagination DTO with calculated values.
        PaginationDto pagination = new PaginationDto(page, totalPages, totalResults, limit);

        // Constructed and returned the final SearchResponseDto.
        return new SearchResponseDto(finalResults, pagination);
    }
}