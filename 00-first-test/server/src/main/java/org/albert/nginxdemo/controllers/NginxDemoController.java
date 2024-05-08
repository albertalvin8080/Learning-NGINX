package org.albert.nginxdemo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/demo")
public class NginxDemoController 
{
    @GetMapping
    public ResponseEntity<String> demo(HttpServletRequest httpRequest) {
        log.info("I was called from NGINX: {}", httpRequest.getRequestURL().toString());
        return ResponseEntity.ok("Hello!!!");
    }
}
