package com.soccatech.FootballManagementSystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "local_user")
public class LocalUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role; // Role can be "ROLE_USER", "ROLE_PLAYER", "ROLE_MANAGER", or "ROLE_ADMIN"

}
