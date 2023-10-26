//package com.loan.den.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests.requestMatchers("/api/forgot-password", "/").permitAll()
//                                .anyRequest().authenticated())
//                .formLogin(withDefaults())
//                .logout(withDefaults())
//                .build();
//    }
//}
