package com.cognizant.onlinefooddeliverysystem.service.implimentation;

import com.cognizant.onlinefooddeliverysystem.dto.user.GetUserRoleResponseDTO;
import com.cognizant.onlinefooddeliverysystem.exception.ResourceNotFoundException;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import com.cognizant.onlinefooddeliverysystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public GetUserRoleResponseDTO getUserRole(Integer id) {
        User user = repository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("User not found with ID : " + id);
        });

        return new GetUserRoleResponseDTO(
                user.getRole()
        );
    }
}
