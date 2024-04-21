package org.example.springsecurity.mapper;

import org.example.springsecurity.model.Role;
import org.example.springsecurity.model.User;
import org.example.springsecurity.model.dto.UserRequest;
import org.example.springsecurity.model.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "email", source = "userRequest.email"),
            @Mapping(target = "password", source = "userRequest.password"),
            @Mapping(target = "roles", source = "roles")
    })
    User toUser(UserRequest userRequest, Set<Role> roles);

    @Mapping(target = "roles", source = "user.roles",qualifiedByName = "mapRoles")
    UserResponse toUserResponse(User user);

    @Named("mapRoles")
    default Set<String> mapRoles(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }

}
