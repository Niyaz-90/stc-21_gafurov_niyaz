package ru.inno.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card implements Serializable {
    private String cvv;
    private String cardNumber;
    private String validThru;
    private String owner;
}
