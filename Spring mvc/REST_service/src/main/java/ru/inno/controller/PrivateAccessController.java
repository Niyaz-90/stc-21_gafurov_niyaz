package ru.inno.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.inno.entity.Card;
import ru.inno.service.UserService;

import java.util.Random;

@RestController
@RequestMapping(value = "/payment")
public class PrivateAccessController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/pay", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
    public ResponseEntity<String> pay(@RequestBody Card card){
        System.out.println("1");
        userService.doTransaction();
        System.out.println("1");
        Random random = new Random();
        System.out.println("1");
        boolean success = random.nextBoolean();
        System.out.println("1");
        if(success){
            System.out.println("Успешно");
            return new  ResponseEntity<>("Успешно!", HttpStatus.ACCEPTED);
        } else {
            System.out.println("Ошибка!");
            return new  ResponseEntity<>("Ошибка!", HttpStatus.BAD_REQUEST);
        }
    }
}
