package org.example.springsecurity.restcontrollers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ap/v1/admin")
public class AdminRestController {
    @GetMapping
    public String getAllUsers() {
        return "These are all the users!";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){

        return "Delete user with id"+id+"successfully";
    }
}
