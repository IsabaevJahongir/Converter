package com.isabaev.converterapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "conversions")
public class Conversion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="from_valute_id")
    Valute fromValute;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="to_valute_id")
    Valute toValute;

    double amount;

    @Temporal(TemporalType.DATE)
    Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;


    public Conversion() {
    }

    public Conversion(Valute fromValute, Valute toValute, double amount, User user, Date date) {
        this.fromValute = fromValute;
        this.toValute = toValute;
        this.amount = amount;
        this.user = user;
        this.date = date;
    }

    public double resultOfConversion(){
        double amount = this.amount;
        double valueFrom = fromValute.getValue()/fromValute.getNominal();
        double valueTo = toValute.getValue()/toValute.getNominal();

        return valueFrom / valueTo * amount;
    }


}
