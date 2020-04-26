package com.example.employeeproject.data;

public class Vehicle {

    private String make;
    private String plate;
    private String color;
    private String type;

    public Vehicle(String make, String plate, String color, String type) {
        this.make = make;
        this.plate = plate;
        this.color = color;
        this.type = type;
    }

    public String getMake() {
        return make;
    }



    public String getPlate() {
        return plate;
    }


    public String getColor() {
        return color;
    }


    public String getType() {
        return type;
    }


    public String toDisplay(){
        return  "\nEmployee has a "+getType()+
                "\n- Model : "+getMake()+
                "\n- Plate : "+getPlate()+
                "\n- Color :"+getColor();
    }
}
