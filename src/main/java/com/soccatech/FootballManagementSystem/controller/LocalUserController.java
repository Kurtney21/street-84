package com.soccatech.FootballManagementSystem.controller;

import com.soccatech.FootballManagementSystem.dto.LocalUserDTO;
import com.soccatech.FootballManagementSystem.model.LocalUser;
import com.soccatech.FootballManagementSystem.services.LocalUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/localUsers")
@RequiredArgsConstructor
public class LocalUserController {
    private final LocalUserService localUserService;
    private final ModelMapper modelMapper;

    @PostMapping("/create")
    public ResponseEntity<LocalUserDTO> createLocalUser(@RequestBody LocalUserDTO localUserDTO) {
            LocalUser localUser = modelMapper.map(localUserDTO, LocalUser.class);
        LocalUser createdUser = localUserService.create(localUser);
        LocalUserDTO createdUserDTO = modelMapper.map(createdUser, LocalUserDTO.class);
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<LocalUserDTO>> getAllLocalUsers() {
        List<LocalUser> localUsers = localUserService.findAll();
        List<LocalUserDTO> localUserDTOs = localUsers.stream()
                .map(user -> modelMapper.map(user, LocalUserDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(localUserDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalUserDTO> updateLocalUser(@PathVariable Long id, @RequestBody LocalUserDTO localUserDTO) {
        LocalUser localUser = modelMapper.map(localUserDTO, LocalUser.class);
        LocalUser updatedUser = localUserService.update(localUser, id);
        LocalUserDTO updatedUserDTO = modelMapper.map(updatedUser, LocalUserDTO.class);
        return new ResponseEntity<>(updatedUserDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocalUser(@PathVariable Long id) {
        boolean deleted = localUserService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
