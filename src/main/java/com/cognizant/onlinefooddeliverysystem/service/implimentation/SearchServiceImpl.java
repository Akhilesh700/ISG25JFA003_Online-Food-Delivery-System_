package com.cognizant.onlinefooddeliverysystem.service.implimentation;

import com.cognizant.onlinefooddeliverysystem.dto.search.PaginationDto;
import com.cognizant.onlinefooddeliverysystem.dto.search.SearchResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.search.SearchResultItemDto;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import com.cognizant.onlinefooddeliverysystem.repository.MenuItemRepository;
import com.cognizant.onlinefooddeliverysystem.repository.RestaurantRepository;
import com.cognizant.onlinefooddeliverysystem.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;

    @Override
    public SearchResponseDto performSearch(String query, int page, int limit) {
        Pageable pageable = PageRequest.of(page - 1, limit); // Spring Data JPA pages are 0-indexed

        // Using CompletableFuture for potentially parallel execution (DB might still bottleneck)
        CompletableFuture<Page<Restaurant>> restaurantFuture = CompletableFuture.supplyAsync(() ->
                restaurantRepository.searchByName(query, pageable)
        );

        CompletableFuture<Page<MenuItems>> menuItemFuture = CompletableFuture.supplyAsync(() ->
                menuItemRepository.searchByNameOrDescription(query, pageable)
        );

        // Wait for both searches to complete
        CompletableFuture.allOf(restaurantFuture, menuItemFuture).join();

        Page<Restaurant> restaurantPage = restaurantFuture.join();
        Page<MenuItems> menuItemPage = menuItemFuture.join();

        // --- Map Entities to DTOs ---
        List<SearchResultItemDto> restaurantDtos = restaurantPage.getContent().stream()
                .map(r -> new SearchResultItemDto(
                        r.getRestId(),
                        r.getName(),
                        r.getRating(),
                        r.getAddress(),
                        r.getImgUrl()))
                .toList();

        List<SearchResultItemDto> menuItemDtos = menuItemPage.getContent().stream()
                .map(mi -> new SearchResultItemDto(
                        mi.getItemId(),
                        mi.getName(),
                        mi.getDescription(),
                        mi.getPrice(),
                        mi.getRestaurant().getRestId(),      // Access joined restaurant
                        mi.getRestaurant().getName(),    // Access joined restaurant
                        mi.getImgUrl()))
                .toList();

        // --- Combine Results ---
        // Simple combination: Restaurants first, then MenuItems. Could add ranking later.
        List<SearchResultItemDto> combinedResults = new ArrayList<>();
        combinedResults.addAll(restaurantDtos);
        combinedResults.addAll(menuItemDtos);

        // --- Pagination Logic (Simplified) ---
        // For accurate total results and pages, you might need separate count queries
        // or sum the totals from both page objects. This is a basic example.
        long totalResults = restaurantPage.getTotalElements() + menuItemPage.getTotalElements();
        int totalPages = (int) Math.ceil((double) totalResults / limit);
        // Note: The combined list might exceed 'limit' here. We truncate for simplicity.
        // A more robust pagination would fetch appropriate slices from each source.
        List<SearchResultItemDto> finalResults = combinedResults.stream().limit(limit).collect(Collectors.toList());


        PaginationDto pagination = new PaginationDto(page, totalPages, totalResults, limit);

        return new SearchResponseDto(finalResults, pagination);
    }
}
