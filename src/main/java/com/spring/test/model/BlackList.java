package com.spring.test.model;


import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BlackList")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlackList {
    @Id
    @Column
    String stockName;
}
