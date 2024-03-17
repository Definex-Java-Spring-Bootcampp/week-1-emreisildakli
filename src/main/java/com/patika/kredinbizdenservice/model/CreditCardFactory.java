package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreditCardFactory {
    private static CreditCardFactory factory;
    private ArrayList<CreditCard> instances = new ArrayList<>();


    private CreditCardFactory() {
    }

    public static CreditCardFactory getInstance() {
        if (factory == null) {
            factory = new CreditCardFactory();
        }
        return factory;
    }

    public CreditCard getCreditCard(BigDecimal fee, List<Campaign> campaignList) {
        CreditCard card = new CreditCard(fee, campaignList);
        instances.add(card);
        return card;
    }


    public ArrayList<CreditCard> getInstances() {
        return instances;
    }
}
