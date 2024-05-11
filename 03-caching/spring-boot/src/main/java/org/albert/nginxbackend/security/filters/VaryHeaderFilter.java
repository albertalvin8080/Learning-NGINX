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

        // You could also set these inside each method mapping of your controllers.
        {
            // Remember, you may add Vary headers to the response, but you can't seem to be able to remove the default ones added by Spring and sent to Nginx.
            /**
             * The value of the header `H-Test:<value>` will be used by Nginx to create a key_caching 
             * for storing the response from this backend. So if you make a request using `H-Test:12345`,
             * and intend to use the cached response, the next request must have `H-Test:12345` as a header as well.
             */
            // response.setHeader("Vary", "H-Test"); 

            response.setHeader("Cache-Control", "public, max-age=3600");
            // response.setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate"); // Default

            response.setHeader("Pragma", "public");
            // response.setHeader("Pragma", "no-cache"); // Default
        }

        filterChain.doFilter(request, response);
    }

}
