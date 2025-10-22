package com.cognizant.onlinefooddeliverysystem.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationDto {
    private int currentPage;
    private int totalPages;
    private long totalResults;
    private int limit;
}
