package ru.inno.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.Data;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.inno.entity.User;
import ru.inno.service.UserService;

@Data
@RestController
public class PrivateAccessController {
    private UserService userService;

    //starting page
    @GetMapping(name = "/get")
    public String getAccessPage(Model model){
        //redirect to payment page
        return "hello";
    }

    @GetMapping(name = "/payment")
    public String pay(Model model){
        return "payment";
    }

    @PostMapping(name = "/payment")
    public ResponceEntity<?> pay(@RequestBody User user){
        userService.create(user);
        return "payment";
    }

    @GetMapping
    public String successPayment(Model model){
        return "success";
    }

    @GetMapping(name = "/allUsers")
    public String getAll(){

    }
}
