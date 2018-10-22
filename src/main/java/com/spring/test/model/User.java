package com.spring.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.Negative;
import javax.validation.constraints.Past;
import java.util.Date;


@Entity
@Table(name = "User_Table")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @Generated
    @Column
    Integer Id;

    @Column
    String username;


   @Column
    String password;

}
