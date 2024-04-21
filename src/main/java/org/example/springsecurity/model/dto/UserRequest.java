package org.example.springsecurity.model.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record UserRequest(
        String email,
        String password,
        Set<String> roles

) {

}
