package com.patika.kredinbizdenservice.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class ApplicationFactory {
    private static ApplicationFactory factory;
    private ArrayList<Application> instances = new ArrayList<>();


    private ApplicationFactory() {
    }

    public static ApplicationFactory getInstance() {
        if (factory == null) {
            factory = new ApplicationFactory();
        }
        return factory;
    }

    public Application getApplication(Product product, User user, LocalDateTime localDateTime) {
        Application application = new Application(product, user, localDateTime);
        instances.add(application);
        return application;
    }

    public Application getApplication(Loan loan, User user, LocalDateTime localDateTime) {
        Application application = new Application(loan, user, localDateTime);
        instances.add(application);
        return application;
    }

    public ArrayList<Application> getInstances() {
        return instances;
    }
}
