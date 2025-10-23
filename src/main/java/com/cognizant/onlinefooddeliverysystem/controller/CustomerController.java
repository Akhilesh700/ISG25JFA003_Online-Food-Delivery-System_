package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.UpdateEntityResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.customer.UpdateProfileCustomerRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.search.SearchResponseDto;
import com.cognizant.onlinefooddeliverysystem.service.CustomerService;
import com.cognizant.onlinefooddeliverysystem.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.version.path}/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "q") String query, @RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "limit", defaultValue = "10") int limit) {
        if (query == null || query.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Search query parameter 'q' is required.");
        }
        if (page < 1) {
            return ResponseEntity.badRequest().body("Page number must be greater than 0.");
        }
        if (limit < 1 || limit > 100) {
            return ResponseEntity.badRequest().body("Limit must be between 1 and 100.");
        }
        SearchResponseDto response = searchService.performSearch(query.trim(), page, limit);
        return ResponseEntity.ok(response);
    }
    @PutMapping("update-profile")
    public ResponseEntity<UpdateEntityResponseDto> updateCustomerProfile(@RequestBody UpdateProfileCustomerRequestDto requestDto){
        return new ResponseEntity<>(customerService.updateCustomerProfile(requestDto), HttpStatus.ACCEPTED);
    }
}
