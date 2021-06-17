package ru.inno.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.inno.entity.Card;
import ru.inno.service.UserService;

import java.util.Random;

@Data
@RestController
public class PrivateAccessController {
    private UserService userService;

    @RequestMapping(value = "/payment")
    public ResponseEntity<String> pay(){
        userService.doTransaction();
        Random random = new Random();
        boolean success = random.nextBoolean();
        if(success){
            System.out.println("Успешно");
            return new  ResponseEntity<>("Успешно", HttpStatus.ACCEPTED);
        } else {
            System.out.println("Ошибка!");
            return new  ResponseEntity<>("Ошибка!", HttpStatus.BAD_REQUEST);
        }
    }
}
