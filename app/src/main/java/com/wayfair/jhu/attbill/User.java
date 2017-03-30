package com.wayfair.jhu.attbill;

/**
 * Created by jhu on 3/29/17.
 */

public class User {
    public String phoneNumber;
    public String name;
    public float planFee = 25;
    public float extraFee;
    public float surchargeFee = 3.01f;
    public float taxes = 2.56f;
    public float total;
    public boolean isMainOver;
    public boolean isSubOver;

    public User(String phoneNumber, String name) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public User(String phoneNumber, String name, float extra) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.extraFee = extra;
    }

    public User(String phoneNumber, String name, float extra, float surchageFee, float taxes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.extraFee = extra;
        this.surchargeFee =surchageFee;
        this.taxes = taxes;
    }

}
