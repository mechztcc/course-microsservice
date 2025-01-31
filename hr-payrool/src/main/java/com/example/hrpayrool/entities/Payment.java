package com.example.hrpayrool.entities;

import java.io.Serializable;

public class Payment implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String name;

    private Double dayliIncome;

    private Integer days;


    public Payment() {
    }
    

    public Payment(String name, Double dayliIncome, Integer days) {
        this.name = name;
        this.dayliIncome = dayliIncome;
        this.days = days;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDayliIncome() {
        return this.dayliIncome;
    }

    public void setDayliIncome(Double dayliIncome) {
        this.dayliIncome = dayliIncome;
    }

    public Integer getDays() {
        return this.days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }


    public double getTotal() {
        return days * dayliIncome;
    }
}
