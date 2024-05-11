package org.albert.nginxbackend.security.config;

import org.albert.nginxbackend.security.filters.VaryHeaderFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .csrf(c -> c.disable())
            .authorizeHttpRequests(a -> a.anyRequest().permitAll())
            .addFilterAfter(new VaryHeaderFilter(), BasicAuthenticationFilter.class);
            
        return httpSecurity.build();
    }
}
