package com.example.employeeproject.data;

import java.util.Calendar;

public class Tester extends Employee {

    private int nbBugs;
    private int GAIN_FACTOR_CLIENT=10;

    public Tester(int id, String first_name, String last_name, int age, int birthYear, int monthlySalary, int rate, Vehicle vehicle,int nbBugs) {
        super(id, first_name, last_name, age, birthYear, monthlySalary, rate, vehicle);
        this.nbBugs=nbBugs;

    }


    private double annualIncome(){
        return (getMonthlySalary()*12*getRate()) + (nbBugs*GAIN_FACTOR_CLIENT);
    }

    public String toDisplay(){
        return super.toDisplay()+
                "a Tester "+
                "\nAge : "+getAge()+
                getVehicle().toDisplay()+
                "\nOccupation Rate : "+getRate()+"%"+
                "\nAnnual Income : "+annualIncome()+
                "\nHe/She has corrected "+nbBugs+" bugs.";
    }

}
