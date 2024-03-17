package com.patika.kredinbizdenservice.model;

public class BankFactory {
    private static BankFactory factory;

    private BankFactory() {
    }

    public static BankFactory getInstance() {
        if (factory == null) {
            factory = new BankFactory();
        }
        return factory;
    }

    public Bank getBank(String name) {
        return new Bank(name);
    }

}
