package com.example.growdiaryv3.models;

public class Plant {
    private int plantId;
    private int plantForeignId;
    private String plantName;
    private String plantMedium;
    private String plantWattage;
    private String plantPotSize;
    private String plantSpecies;
    private String plantDesc;

    public Plant() {

    }

    public Plant(int plantId, String plantName, String plantMedium, String plantWattage,
                 String plantPotSize, String plantSpecies, String plantDesc, int plantForeignId) {
        this.plantId = plantId;
        this.plantForeignId = plantForeignId;
        this.plantName = plantName;
        this.plantMedium = plantMedium;
        this.plantWattage = plantWattage;
        this.plantPotSize = plantPotSize;
        this.plantSpecies = plantSpecies;
        this.plantDesc = plantDesc;
    }

    public Plant(String plantName, String plantMedium, String plantWattage,
                 String plantPotSize, String plantSpecies, String plantDesc) {
        this.plantName = plantName;
        this.plantMedium = plantMedium;
        this.plantWattage = plantWattage;
        this.plantPotSize = plantPotSize;
        this.plantSpecies = plantSpecies;
        this.plantDesc = plantDesc;
    }

    public int getPlantForeignId() {
        return plantForeignId;
    }

    public void setPlantForeignId(int plantForeignId) {
        this.plantForeignId = plantForeignId;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantMedium() {
        return plantMedium;
    }

    public void setPlantMedium(String plantMedium) {
        this.plantMedium = plantMedium;
    }

    public String getPlantWattage() {
        return plantWattage;
    }

    public void setPlantWattage(String plantWattage) {
        this.plantWattage = plantWattage;
    }

    public String getPlantPotSize() {
        return plantPotSize;
    }

    public void setPlantPotSize(String plantPotSize) {
        this.plantPotSize = plantPotSize;
    }

    public String getPlantSpecies() {
        return plantSpecies;
    }

    public void setPlantSpecies(String plantSpecies) {
        this.plantSpecies = plantSpecies;
    }

    public String getPlantDesc() {
        return plantDesc;
    }

    public void setPlantDesc(String plantDesc) {
        this.plantDesc = plantDesc;
    }
}
