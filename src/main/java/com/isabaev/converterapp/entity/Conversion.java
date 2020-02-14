package com.isabaev.converterapp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Conversion {
    Valute fromValute;
    Valute toValute;
    double amount;

    public Conversion(Valute fromValute, Valute toValute, double amount) {
        this.fromValute = fromValute;
        this.toValute = toValute;
        this.amount = amount;
    }
}
