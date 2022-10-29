package com.example.demo.entities;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CreditCard extends Payment{
    private String cardnumber;
    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }





}
