package com.uep.wap.controller;

import com.uep.wap.model.AppUser;
import com.uep.wap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.uep.wap.dto.RegistrationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<AppUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public AppUser getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public AppUser saveUser(@RequestBody AppUser appUser) {
        return userService.saveUser(appUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Validated @RequestBody RegistrationDTO registrationDTO) {
        AppUser appUser = new AppUser();
        appUser.setName(registrationDTO.getName());
        appUser.setEmail(registrationDTO.getEmail());
        appUser.setPassword(registrationDTO.getPassword()); // Ensure you hash the password in a real application
        appUser.setPhone(registrationDTO.getPhoneNumber());
        appUser.setRole(registrationDTO.getRole());

        userService.saveUser(appUser);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}
