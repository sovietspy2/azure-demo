package com.example.azuredemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Value("${custom}")
    private String value;

    @GetMapping("/")
    public String welcome() {
        return "my enviorment propery:"+value;
    }

}
