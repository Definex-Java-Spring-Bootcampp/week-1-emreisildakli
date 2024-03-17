package com.patika.kredinbizdenservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class UserFactory {
    private static UserFactory factory;
    private HashMap<String, User> instances = new HashMap<>();

    private UserFactory() {
    }

    public static UserFactory getInstance() {
        if (factory == null) {
            factory = new UserFactory();
        }
        return factory;
    }

    public User getUser(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) {
        // Aynı e-mail adresi ile bir kullanıcı kayıt olabilir.
        if (this.isEmailUsed(email)) {
            return null;
        }

        User user = new User(name, surname, birthDate, email, password, phoneNumber, isActive);
        this.instances.put(email, user);
        return user;
    }

    public boolean isEmailUsed(String email) {
        return this.instances.containsKey(email);
    }

    public HashMap<String, User> getInstances() {
        return this.instances;
    }

    public void setInstances(HashMap<String, User> instances) {
        this.instances = instances;
    }
}
