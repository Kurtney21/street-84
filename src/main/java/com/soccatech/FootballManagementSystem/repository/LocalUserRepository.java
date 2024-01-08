package com.soccatech.FootballManagementSystem.repository;

import com.soccatech.FootballManagementSystem.model.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalUserRepository extends JpaRepository<LocalUser, Long> {
    //implement custom queries if needed here
}
