package org.albert.nginxbackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController 
{
    @GetMapping
    public String main(HttpServletRequest httpServletRequest) {
        log.info("Request URL: {}", httpServletRequest.getRequestURL());
        log.info("Remote Host: {}", httpServletRequest.getRemoteHost()); // It's probably to be the IP of the NGINX container
        return "main";
    }

    @GetMapping("/test1")
    public String test1() {
        return "test1";
    }
}
