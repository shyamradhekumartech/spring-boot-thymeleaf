package com.example.app.runner;

import com.example.app.entity.User;
import com.example.app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        
        // 1. Alice - Standard User
        createUserIfNotFound("alice_springs", "password123", "ROLE_USER");

        // 2. Bob - Administrator
        createUserIfNotFound("admin_bob", "secure_admin_pass", "ROLE_ADMIN");

        // 3. Charlie - Multi-role
        createUserIfNotFound("charlie_dev", "dev_pass_2026", "ROLE_USER,ROLE_ADMIN");

        // 4. Guest - Viewer
        createUserIfNotFound("guest_viewer", "guest_only", "ROLE_GUEST");
        
        System.out.println("✅ Security Data Initialization Complete.");
    }

    private void createUserIfNotFound(String username, String rawPassword, String roles) {
        if (userRepository.findByUsername(username).isEmpty()) {
            User user = new User();
            user.setUsername(username);
            // This is the magic part that fixes your "not working" issue:
            user.setPassword(passwordEncoder.encode(rawPassword));
            user.setRoles(roles);
            userRepository.save(user);
            System.out.println("Created user: " + username + " with roles: " + roles);
        }
    }
}