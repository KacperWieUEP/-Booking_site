package com.uep.wap.service;

import com.uep.wap.model.AppUser;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AppUser saveUser(AppUser user) {
        logger.info("Registering user: {}", user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash the password before saving
        AppUser savedUser = userRepository.save(user);
        logger.info("User registered successfully: {}", savedUser.getEmail());
        return savedUser;
    }

    public boolean validateUser(String email, String password) {
        logger.info("Validating user: {}", email);
        Optional<AppUser> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            AppUser appUser = userOpt.get();
            boolean isValid = passwordEncoder.matches(password, appUser.getPassword());
            if (isValid) {
                logger.info("User validated successfully: {}", email);
            } else {
                logger.warn("Password mismatch for user: {}", email);
            }
            return isValid;
        }
        logger.warn("User not found: {}", email);
        return false;
    }

    public List<AppUser> getAllUsers() {
        logger.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("Loading user by email: {}", email);
        AppUser appUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
        logger.info("User loaded: {}", email);
        return new User(appUser.getEmail(), appUser.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }

    public Optional<AppUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        logger.info("Deleting user by id: {}", id);
        userRepository.deleteById(id);
        logger.info("User deleted successfully: {}", id);
    }
}
