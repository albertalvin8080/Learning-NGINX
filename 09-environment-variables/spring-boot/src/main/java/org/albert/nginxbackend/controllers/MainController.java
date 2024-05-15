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
        log.info("Remote Host: {}", httpServletRequest.getRemoteHost()); // It's probably to be the IP of the NGINX container

        return "main";
    }

    @ResponseBody
    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> test() {
        String json = """
            { "Message" : "Json of victory.", "Developer Message" : "What are you doing?" }
        """
            // .replaceAll("((?<=[\\}\\{\\:])\\s+)|(\\s+(?=[\\}\\{\\:]))", "")
            .replaceAll("((?<!\\b+)\\s+)|(\\s+(?!\\b+))", "");
        
        return ResponseEntity.ok(json);
    }
}
