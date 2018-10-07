package com.spring.test.model;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;


@Entity
@Table(name = "Trade")
public class User{
    @Id
    @Column(name = "TradeID", unique = true, nullable = false)
    Long Id;
    @Column(name = "Price")
    Long price;
    @Column(name = "StockName")
    String name;

    public User() {
    }

    public User(Long id, Long price, String name) {
        Id = id;
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public Long getprice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setprice(Long price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
