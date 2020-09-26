package com.avinash.learning.springwebservices.controller;

import com.avinash.learning.springwebservices.bean.WelcomeBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    //@RequestMapping(method = RequestMethod.GET, path="/Hello")
    @GetMapping(path="/Hello")
    public String welcomeNote(){
        return "Hello and Welcome to learning";
    }

    @GetMapping(path="/HelloBean")
    public WelcomeBean welcomeBean() {
        return new WelcomeBean("Hello and Welcome to learning");
    }

    @GetMapping(path="/HelloBean/{name}")
    public WelcomeBean welcomeBeanPathVariable(@PathVariable String name) {
        return new WelcomeBean(String.format("Hello and Welcome to learning,%s",name));
    }
}
