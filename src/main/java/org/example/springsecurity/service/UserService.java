package org.example.springsecurity.service;

import org.example.springsecurity.model.dto.UserRequest;
import org.example.springsecurity.model.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
