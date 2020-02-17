package com.isabaev.converterapp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Getter
@Setter
@Entity
@ToString
@Table(name = "valutes")
public class Valute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "actual_date")
    @Temporal(TemporalType.DATE)
    private Date actualDate;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private double value;

    @Column(name = "num_code")
    private String numCode;

    @Column(name = "char_code")
    private String charCode;

    @Column(name = "nominal")
    private int nominal;

    public Valute() {
    }

    public Valute(Date actualDate, String name, double value, String numCode, String charCode, int nominal) {
        this.actualDate = actualDate;
        this.name = name;
        this.value = value;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
    }

}
