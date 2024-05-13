package org.albert.nginxbackend.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController 
{
    @GetMapping
    public String main(HttpServletRequest httpServletRequest) {
        log.info("Request URL: {}", httpServletRequest.getRequestURL());
        log.info("Remote Host: {}", httpServletRequest.getRemoteHost()); // it's probably to be the IP of the NGINX container
        return "main";
    }

    @GetMapping(path = "/test")
    public String test() {
        return "test";
    }

    @ResponseBody
    @GetMapping(path = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> json() {
        return ResponseEntity.ok("{\"message\":\"if you're seeing this, you've logged in successfully.\"}");
    }
}
