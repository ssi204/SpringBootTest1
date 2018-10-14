package com.spring.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.test.Validator.MatchDates;
import com.spring.test.Validator.UpperCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "TradeData")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@MatchDates(message ="settlement date should be ahead of tarde data")
public class TradeData {
    @Id
    @Column
    long tradeId;

    @Column
    String stockName;

    @Column
    @UpperCase(message ="should be in upper case")
    String brokerCode;

    @Column
    String brokerName;

    @Positive(message = "Quantity should be positive")
    @Column
    int quantity;

    @Column
    Date tradeDate;

    @Column
    Date settlementDate;

    @Column(name = "buySellIndicator", nullable = false)
    @Enumerated(EnumType.STRING)
    BuySellIndicator buySellIndicator;

    public TradeData(long tradeId, String stockName, String brokerCode) {
        this.tradeId = tradeId;
        this.stockName = stockName;
        this.brokerCode = brokerCode;
    }
}
