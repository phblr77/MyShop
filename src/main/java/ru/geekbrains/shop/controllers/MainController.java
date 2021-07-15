package ru.geekbrains.shop.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/navigation")
    public String showNavigation() {
        return "navigation";
    }

}
