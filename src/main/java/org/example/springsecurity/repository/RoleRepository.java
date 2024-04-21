package org.example.springsecurity.repository;

import org.example.springsecurity.model.Role;
import org.example.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,String> {
    Optional<Role> findByName(String name);
}

