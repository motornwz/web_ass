/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monash.fit5042.govtservice.entities;

/**
 *
 * @author naveedzanoon1
 */
public enum UserType {
    
    GovernmentWorker("Government Worker", 
            "An employee of the government of australia"),
    PublicUser("Public User","A user that belongs to the general public");

    private String title;
    private String description;

    UserType(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return title;
    }

    public static UserType getTypeForTitle(String title) {
        UserType[] values = UserType.values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].getTitle().equalsIgnoreCase(title)) {
                return values[i];
            }
        }
        return null;
    }

    public static String[] userTypes() {
        UserType[] values = UserType.values();
        String[] retVal = new String[values.length];

        for (int i = 0; i < values.length; i++) {
            String title = values[i].getTitle();
            retVal[i] = title;
        }
        return retVal;
    }

}
