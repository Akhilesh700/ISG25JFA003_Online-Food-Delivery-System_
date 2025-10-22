package com.cognizant.onlinefooddeliverysystem.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponseDto {
    private List<SearchResultItemDto> results;
    private PaginationDto pagination;
}
