package com.spring.test.Validator;

import com.spring.test.model.TradeData;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatchDatesValidator implements ConstraintValidator<MatchDates, TradeData> {
    @Override
    public boolean isValid(TradeData tradeData, ConstraintValidatorContext constraintValidatorContext) {
        return (tradeData.getTradeDate().compareTo(tradeData.getSettlementDate()) >0);
    }
}
