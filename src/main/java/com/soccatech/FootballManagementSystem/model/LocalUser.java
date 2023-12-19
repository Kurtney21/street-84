package com.soccatech.FootballManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LocalUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role; // Role can be "ROLE_USER", "ROLE_PLAYER", "ROLE_MANAGER", or "ROLE_ADMIN"

    // Constructors, getters, setters, etc.
}
