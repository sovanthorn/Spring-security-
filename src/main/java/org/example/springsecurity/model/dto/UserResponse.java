package org.example.springsecurity.model.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record UserResponse(
        String id,
        String email,
        Set<String> roles

) {
}
