package ru.makhmudov.spring_boot_poll_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    public String index(){
//        return "Welcome to our Poll service</br></br>\n" +
//                "<a href=\"http://localhost:8080/poll/api/polls\">Login</a>";
        return "Hello";
    }
}
