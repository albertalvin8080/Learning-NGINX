package org.albert.nginxbackend.security.config;

import org.albert.nginxbackend.security.filters.VaryHeaderFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(c -> c.disable())
                .formLogin(Customizer.withDefaults())
                // .cors(c -> c.disable())
                .authorizeHttpRequests(a -> a.anyRequest().authenticated())
                .addFilterAfter(new VaryHeaderFilter(), AuthorizationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        var u1 = User.withUsername("albert")
                .password("1234")
                .passwordEncoder(pwd -> passwordEncoder().encode(pwd))
                .build();

        return new InMemoryUserDetailsManager(u1);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
