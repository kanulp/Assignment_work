package com.example.employeeproject.data;

public class Car extends Vehicle {

    private String car_type;


    public Car(String make, String plate, String color, String type,String car_type) {
        super(make, plate, color, type);
        this.car_type=car_type;
    }


     public String toDisplay(){
        return super.toDisplay()+"\n- type : "+this.car_type;
    }

}
