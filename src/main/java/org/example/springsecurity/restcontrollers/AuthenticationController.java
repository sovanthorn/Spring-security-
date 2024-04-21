package org.example.springsecurity.restcontrollers;

import lombok.RequiredArgsConstructor;
import org.example.springsecurity.model.dto.UserRequest;
import org.example.springsecurity.model.dto.UserResponse;
import org.example.springsecurity.service.UserService;
import org.example.springsecurity.utils.BaseResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;
    @PostMapping("/register")
   public BaseResponse<UserResponse> createNewUser(@RequestBody UserRequest userRequest){
        return BaseResponse.<UserResponse>createSuccess()
                .setPayload(userService.createUser(userRequest));
    }
}
