package com.example.growdiaryv3.constants;

public class Constants {
    //diary database
    public static final int DATA_BASE_VERSION = 1;
    public static final String DATABASE_NAME_DIARY = "diary_db";
    public static final String TABLE_NAME_DIARY = "diaries";

    //diary collumns

    public static final String KEY_ID_DIARY = "diary_id";
    public static final String KEY_NAME_DIARY = "diary_name";
    public static final String KEY_DESC_DIARY = "diary_description";
    public static final String KEY_DATE_ADDED_DIARY = "diary_date_added";

    /**********************************************************************/

    //plant database
    //public static final int DATA_BASE_VERSION_PLANT = 1;
    //public static final String DATABASE_NAME_PLANT = "plant_db";
    public static final String TABLE_NAME_PLANT = "plants";

    //plant collumns
    public static final String KEY_ID_PLANT = "id";
    public static final String KEY_ID_FOREIGN_DIARY = "f_diary_id";
    public static final String KEY_NAME_PLANT = "plant_name";
    public static final String KEY_PLANT_MEDIUM = "plant_medium";
    public static final String KEY_PLANT_WATTAGE = "plant_overhead_wattage";
    public static final String KEY_PLANT_POT_SIZE= "plant_pot_size";
    public static final String KEY_PLANT_SPECIES = "plant_species";
    public static final String KEY_PLANT_MISC_NOTES = "plant_description";
    public static final String KEY_PLANT_FOREIGN_ID = "foreign_id";
}
