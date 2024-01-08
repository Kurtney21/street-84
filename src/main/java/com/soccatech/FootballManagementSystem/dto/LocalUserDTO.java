package com.soccatech.FootballManagementSystem.dto;

import com.soccatech.FootballManagementSystem.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalUserDTO {
    private Long id;
    private String username;
    private String password;
    private UserRole role;
}
