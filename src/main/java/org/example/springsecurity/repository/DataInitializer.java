package org.example.springsecurity.repository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.springsecurity.model.Authority;
import org.example.springsecurity.model.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;

    @PostConstruct
    void initData(){
        initAuthorities();
        initRoles();

    }
    private void initAuthorities(){
        List<String> authories = List.of("READ","WRITE","DELETE");
        if(authorityRepository.count()==0)
        for(String auth: authories){
            Authority authority = new Authority();
            authority.setName(auth);
            authorityRepository.save(authority);
        }

    }
    private void initRoles(){
        if(roleRepository.count()==0){
            Role userRole = new Role();
            userRole.setName(" USER");
            userRole.setAuthorities(Set.of(authorityRepository.findByName("READ").get()));
             roleRepository.save(userRole);
             
             Role adminRole = new Role();
             adminRole.setName("ADMIN");
             adminRole.setAuthorities(new HashSet<>(authorityRepository.findAll()));
             roleRepository.save(adminRole);
        }
    }
}

