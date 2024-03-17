package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;

import com.patika.kredinbizdenservice.enums.LoanType;

public class LoanFactory {
    private static LoanFactory factory;

    private LoanFactory() {
    }

    public Loan getLoan(LoanType type, BigDecimal amount, Integer installment, Double interestRate) {
        if (type == LoanType.KONUT_KREDISI) {
            return new HouseLoan(amount, installment, interestRate);
        } else if (type == LoanType.ARAC_KREDISI) {
            return new VechileLoan(amount, installment, interestRate);
        } else if (type == LoanType.IHTIYAC_KREDISI) {
            return new ConsumerLoan(amount, installment, interestRate);
        }

        return null;
    }

    public static LoanFactory getInstance() {
        if (factory == null) {
            factory = new LoanFactory();
        }
        return factory;
    }

}
