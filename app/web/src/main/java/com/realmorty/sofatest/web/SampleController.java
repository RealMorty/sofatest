package com.realmorty.sofatest.web;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
