package com.soccatech.FootballManagementSystem.services;

import com.soccatech.FootballManagementSystem.model.LocalUser;
import com.soccatech.FootballManagementSystem.repository.LocalUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalUserService implements IServices<LocalUser, Long> {
    private final LocalUserRepository localUserRepository;

    @Override
    public LocalUser create(LocalUser user) {
        return localUserRepository.save(user);
    }

    @Override
    public List<LocalUser> findAll() {
        return localUserRepository.findAll();
    }

    @Override
    public LocalUser update(LocalUser localUser, Long id) {
        LocalUser existingUser = localUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Update existingUser properties with the values from the input localUser
        existingUser.setUsername(localUser.getUsername());
        existingUser.setPassword(localUser.getPassword());
        existingUser.setRole(localUser.getRole());

        // Save the updated user
        return localUserRepository.save(existingUser);
    }

    @Override
    public boolean delete(Long id) {
        if (localUserRepository.existsById(id)) {
            localUserRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
