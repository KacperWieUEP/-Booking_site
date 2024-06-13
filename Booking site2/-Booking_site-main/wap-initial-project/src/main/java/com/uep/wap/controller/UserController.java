package com.uep.wap.controller;

import com.uep.wap.model.AppUser;
import com.uep.wap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.uep.wap.dto.RegistrationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public List<AppUser> getAllUsers() {
        logger.info("Request to fetch all users");
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<AppUser> getUserById(@PathVariable Long id) {
        logger.info("Request to fetch user by id: {}", id);
        return userService.getUserById(id);
    }

    @PostMapping
    public AppUser saveUser(@RequestBody AppUser appUser) {
        logger.info("Request to save user: {}", appUser.getEmail());
        return userService.saveUser(appUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        logger.info("Request to delete user by id: {}", id);
        userService.deleteUser(id);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Validated @RequestBody RegistrationDTO registrationDTO) {
        logger.info("Request to register user: {}", registrationDTO.getEmail());
        AppUser appUser = new AppUser();
        appUser.setName(registrationDTO.getName());
        appUser.setEmail(registrationDTO.getEmail());
        appUser.setPassword(registrationDTO.getPassword());
        appUser.setPhone(registrationDTO.getPhoneNumber());
        appUser.setRole(registrationDTO.getRole());

        userService.saveUser(appUser);
        logger.info("User registered successfully: {}", registrationDTO.getEmail());
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
        logger.info("Request to login user: {}", username);
        boolean isValidUser = userService.validateUser(username, password);
        if (isValidUser) {
            logger.info("User logged in successfully: {}", username);
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            logger.warn("Login failed for user: {}", username);
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }
}
