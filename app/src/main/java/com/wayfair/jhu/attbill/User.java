package com.wayfair.jhu.attbill;

/**
 * Created by jhu on 3/29/17.
 */

public class User {
    public String phoneNumber;
    public String name;
    public int planFee = 25;
    public int extraFee;
    public int surchargeFee;
    public int taxes;

    public User(String phoneNumber, String name) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
