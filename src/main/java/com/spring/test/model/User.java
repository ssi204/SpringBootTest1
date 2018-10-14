package com.spring.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.Negative;
import javax.validation.constraints.Past;
import java.util.Date;


@Entity
@Table(name = "trade")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @Column(name = "TradeID", unique = true, nullable = false)
    Long Id;


    @Column(name = "Price")
    Long price;

    @Column(name = "StockName")
    String name;

    @Column(name ="date")
    Date date;

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
@JsonIgnore(value=false)
    public void setPrice(Long price) {
        this.price = price;
    }

    @JsonIgnore
    public Long getPrice() {
        return price;
    }
}
