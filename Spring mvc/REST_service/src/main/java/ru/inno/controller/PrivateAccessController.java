package ru.inno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> pay(@RequestBody Card card){
        userService.doTransaction();
        Random random = new Random();
        boolean success = random.nextBoolean();
        if(success){
            System.out.println("Успешно");
            return new  ResponseEntity<>("Успешно!", HttpStatus.ACCEPTED);
        } else {
            System.out.println("Ошибка!");
            return new  ResponseEntity<>("Ошибка!", HttpStatus.BAD_REQUEST);
        }
    }
}
