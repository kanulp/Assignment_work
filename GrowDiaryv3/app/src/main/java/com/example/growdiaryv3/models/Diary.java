package com.example.growdiaryv3.models;

public class Diary implements Comparable {
    private int diaryId;
    private String diaryName;
    private String diaryDesc;
    private String dateDiaryAdded;
    private String plantName;

    public Diary() {
    }

    public Diary(String diaryName, String diaryDesc, String dateDiaryAdded, String plantName) {
        this.diaryName = diaryName;
        this.diaryDesc = diaryDesc;
        this.dateDiaryAdded = dateDiaryAdded;
        this.plantName = plantName;
    }

    public Diary(int diaryId, String diaryName, String diaryDesc, String dateDiaryAdded, String plantName) {
        this.diaryId = diaryId;
        this.diaryName = diaryName;
        this.diaryDesc = diaryDesc;
        this.dateDiaryAdded = dateDiaryAdded;
        this.plantName = plantName;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public int getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(int diaryId) {
        this.diaryId = diaryId;
    }

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public String getDiaryDesc() {
        return diaryDesc;
    }

    public void setDiaryDesc(String diaryDesc) {
        this.diaryDesc = diaryDesc;
    }

    public String getDateDiaryAdded() {
        return dateDiaryAdded;
    }

    public void setDateDiaryAdded(String dateDiaryAdded) {
        this.dateDiaryAdded = dateDiaryAdded;
    }

    @Override
    public int compareTo(Object diary) {
        int compareTo=((Diary )diary).getDiaryId();
        return this.diaryId-compareTo;
    }
}

