//package com.example.app.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
///**
// * Use this approach instead of annotation applying on controller method level
// * Instead of annotations, you can define role requirements globally in SecurityFilterChain
// */
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class GlobalUrlBasedSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // // Often disabled for stateless REST APIs
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/public").permitAll()
//                        .requestMatchers("/h2-console/**").permitAll()
//                        .requestMatchers("/api/admin-only/**").hasRole("ADMIN")
//                        .requestMatchers("/api/delete/**").hasAnyRole("USER", "ADMIN")
//                        .anyRequest().authenticated() // All endpoints require authentication
//                )
//                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())) // Allows frames from same origin
//                .httpBasic(Customizer.withDefaults());  // Enable Basic Auth
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder().encode("user"))
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
