package com.qing.provider.entity;

import lombok.ToString;

@ToString
public class Student {

    private String firstName;

    private String lastName;

    public Double grade;

    public Double feeDiscount = 0.0;

    private Double baseFee = 20000.0;

    public Student(String firstName, String lastName, Double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public void printFee(){
        Double newFee = baseFee - ((baseFee * feeDiscount) / 100);
        System.out.println("The fee after discount: " + newFee);
    }

}

