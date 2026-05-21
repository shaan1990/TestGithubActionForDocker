package com.example.testdocker.testdocker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class TestController {

    @RequestMapping("/hi")
    public String sayHello()
    {
        return "hello";
    }
}
