package com.spring.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.List;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockListRequested {

    List<TradeData> acceptedList;
    List<TradeData> rejectedList;
}
