package com.example.employeeproject.data;

import java.util.Calendar;

public class Programmer extends  Employee{

    private int nbProjects;
    private static final int GAINED_FACTOR_PROJECTS = 200;

    public Programmer(int id, String first_name, String last_name, int age, int birthYear, int monthlySalary, int rate, Vehicle vehicle,int nbProjects) {
        super(id, first_name, last_name, age, birthYear, monthlySalary, rate, vehicle);
        this.nbProjects=nbProjects;
    }


    private double annualIncome(){

        return (getMonthlySalary()*12*getRate()) + (this.nbProjects*GAINED_FACTOR_PROJECTS);

    }

    public String toDisplay(){
        return super.toDisplay()+
                "a Programmer"+
                "\nAge : "+getAge()+
                getVehicle().toDisplay()+
                "\nOccupation Rate : "+getRate()+"%"+
                "\nAnnual Income : "+annualIncome()+
                "\nHe/She has completed "+nbProjects+" projects";
    }
}
