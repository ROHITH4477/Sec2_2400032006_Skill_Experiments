package com.klu.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf->csrf.disable())
            .authorizeHttpRequests(auth->auth
                    .requestMatchers("/","/save").permitAll()
                    .requestMatchers("/admin").hasRole("ADMIN")
                    .anyRequest().authenticated()
            )
            .formLogin(form->form.defaultSuccessUrl("/dashboard"))
            .logout(logout->logout.logoutSuccessUrl("/"));

        return http.build();
    }
}

