package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.search.SearchResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface SearchService {

    SearchResponseDto performSearch(String trim, int page, int limit);
}
