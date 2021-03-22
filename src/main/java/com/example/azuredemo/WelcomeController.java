package com.example.azuredemo;

import com.example.azuredemo.model.Test;
import com.example.azuredemo.repository.TestRepository;
import com.example.azuredemo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Date;

@Slf4j
@RestController
public class WelcomeController {

    @Value("${custom}")
    private String value;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestService testService;

    @GetMapping("/")
    public String welcome() {
        log.info(" root endpoint accessed");
        return "my enviorment propery:"+value;
    }

    @GetMapping("/load")
    public Test test(@RequestParam Integer id) {
        Test test = testRepository.findById(id).get();
        return test;

    }

    @GetMapping("/save")
    public String save(@RequestParam String name) {

        Test test = new Test();
        test.setCreateDate(new Date());
        test.setName(name);
        testService.testSave(test);
        return name;
    }

}
