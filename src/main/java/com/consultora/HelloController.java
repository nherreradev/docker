package com.consultora;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Hola desde la versión 1.0.1";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}