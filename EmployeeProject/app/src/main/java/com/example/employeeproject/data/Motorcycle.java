package com.example.employeeproject.data;

public class Motorcycle extends  Vehicle {

    private int hasSideCar;

    public Motorcycle(String make, String plate, String color, String type,int hasSideCar) {
        super(make, plate, color, type);
        this.hasSideCar=hasSideCar;
    }

    public String toDisplay(){
        return super.toDisplay()+
                (hasSideCar==1?"\n- with a side car":"\n- without a side car");
    }

}
