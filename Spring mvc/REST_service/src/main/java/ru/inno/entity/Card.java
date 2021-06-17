package ru.inno.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Card {
    private String cvv;
    private String cardNumber;
    private String validThru;
    private String owner;
}
