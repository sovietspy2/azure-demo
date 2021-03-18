package com.example.azuredemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WelcomeController {

    @Value("${custom}")
    private String value;

    @GetMapping("/")
    public String welcome() {
        log.info(" root endpoint accessed");
        return "my enviorment propery:"+value;
    }

}
