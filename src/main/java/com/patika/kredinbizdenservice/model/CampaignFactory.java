package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.SectorType;

import java.time.LocalDate;
import java.util.ArrayList;

public class CampaignFactory {
    private static CampaignFactory factory;
    private ArrayList<Campaign> instances = new ArrayList<>();


    private CampaignFactory() {
    }

    public static CampaignFactory getInstance() {
        if (factory == null) {
            factory = new CampaignFactory();
        }
        return factory;
    }

    public Campaign getCampaign(String title, String content, LocalDate dueDate, LocalDate createDate, LocalDate updateDate, SectorType sector) {
        Campaign campaign = new Campaign(title, content, dueDate, createDate, updateDate, sector);
        instances.add(campaign);
        return campaign;
    }


    public ArrayList<Campaign> getInstances() {
        return instances;
    }
}
