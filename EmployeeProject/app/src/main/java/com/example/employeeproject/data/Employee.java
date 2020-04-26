package com.example.employeeproject.data;

import java.util.Calendar;

public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private int birthYear;
    private int monthlySalary;
    private int rate=100;
    private Vehicle vehicle;

    public Employee(int id, String first_name, String last_name, int age, int birthYear, int monthlySalary, int rate, Vehicle vehicle) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.birthYear = birthYear;
        this.monthlySalary = monthlySalary;
        this.rate = rate;
        this.vehicle = vehicle;
    }

//    private static Employee INSTANCE = new Employee();
//    private Employee(){ };
//
//    public static Employee getInstance() {
//        return(INSTANCE);
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }


    public String getLast_name() {
        return last_name;
    }


    public int getAge() {
        return age;
    }




    public int getMonthlySalary() {
        return monthlySalary;
    }


    public int getRate() {
        return rate;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }


    public String toDisplay(){
        return "Name: "+getFirst_name()+" "+getLast_name().substring(0,1).toUpperCase().toString()+" , ";


    }

}
