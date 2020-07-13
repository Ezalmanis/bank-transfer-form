package com.erikszalmanis.hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping({"/index", "/", "", "/home"})
    public String index() {
        return "index";
    }

    @GetMapping("/pending")
    public String pending() {
        return "pending";
    }

}
