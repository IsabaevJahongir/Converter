package com.isabaev.converterapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "valutes")
public class Valute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "actual_date")
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


    public void setId(Long id) {
        this.id = id;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public Long getId() {
        return id;
    }

    public Date getActualDate() {
        return actualDate;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public String getNumCode() {
        return numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public int getNominal() {
        return nominal;
    }
}
