package com.isabaev.converter.app.entity;


import javax.persistence.*;
import java.util.Date;


@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    @Override
    public String toString() {
        return "Valute{" +
                "id=" + id +
                ", actualDate=" + actualDate +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", numCode='" + numCode + '\'' +
                ", charCode='" + charCode + '\'' +
                ", nominal=" + nominal +
                '}';
    }
}
