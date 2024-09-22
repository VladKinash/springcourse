package com.main.udemyproj.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FunRestController {

    @GetMapping("/")
    public void sayHello() {
        System.out.print("Hello World");
    }
    

}
