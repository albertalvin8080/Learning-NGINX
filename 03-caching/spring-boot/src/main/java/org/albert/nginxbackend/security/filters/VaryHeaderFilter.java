package org.albert.nginxbackend.security.filters;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VaryHeaderFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        response.setHeader("Vary", "Origin");
        response.setHeader("Cache-Control", "public, max-age=3600");
        response.setHeader("Pragma", "public");
        filterChain.doFilter(request, response);
    }

}
