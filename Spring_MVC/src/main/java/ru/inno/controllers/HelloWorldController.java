package ru.inno.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HelloWorldController {

    @RequestMapping(value = "/hello",  method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("name", "Нияз");
        model.addAttribute("list", "hello");
        return "hello";
    }
}
