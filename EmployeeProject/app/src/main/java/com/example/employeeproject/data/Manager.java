package com.example.employeeproject.data;

public class Manager extends Employee {
    private int nbClients;

    private static final int GAIN_FACTOR_CLIENT = 500;
    private static final int GAIN_FACTOR_TRAVEL = 100;
    private static final int DAYS = 365;

    public Manager(int id, String first_name, String last_name, int age, int birthYear, int monthlySalary, int rate, Vehicle vehicle,int nbClients) {
        super(id, first_name, last_name, age, birthYear, monthlySalary, rate, vehicle);
        this.nbClients=nbClients;
    }


    public String toDisplay(){
        return super.toDisplay()+"" +
                "a Manager"+
                "\nAge : "+getAge()+
                getVehicle().toDisplay()+
                "\nOccupation Rate : "+getRate()+"%"+
                "\nAnnual Income : "+annualIncome()+
                "\nHe/She has brought "+nbClients+" new clients";
    }

    private double annualIncome(){

        return (getMonthlySalary()*12*getRate()) + (nbClients*GAIN_FACTOR_CLIENT) + (GAIN_FACTOR_TRAVEL*DAYS);

    }


}
