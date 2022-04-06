package com.isabaev.converter.app.entity;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "conversions")
public class Conversion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "from_valute_id")
    Valute fromValute;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_valute_id")
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

    public double resultOfConversion() {
        double amount = this.amount;
        double valueFrom = fromValute.getValue() / fromValute.getNominal();
        double valueTo = toValute.getValue() / toValute.getNominal();

        return valueFrom / valueTo * amount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Valute getFromValute() {
        return fromValute;
    }

    public void setFromValute(Valute fromValute) {
        this.fromValute = fromValute;
    }

    public Valute getToValute() {
        return toValute;
    }

    public void setToValute(Valute toValute) {
        this.toValute = toValute;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "id=" + id +
                ", fromValute=" + fromValute +
                ", toValute=" + toValute +
                ", amount=" + amount +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
