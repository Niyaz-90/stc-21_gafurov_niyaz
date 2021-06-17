package ru.inno.service;

import org.springframework.stereotype.Service;
import ru.inno.entity.Card;

@Service
public class UserService {
    public void doTransaction() {
        System.out.println("Проведение платежа...");
    }

}
