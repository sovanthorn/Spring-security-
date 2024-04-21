package org.example.springsecurity.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true)
    private String email;
    private String password;

    private boolean isDisabled;
    private boolean isAccountLocked;
    private boolean isAccountExpired;
    private boolean isCredentialsExpired;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<Role> roles;
}
