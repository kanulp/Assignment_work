package com.example.growdiaryv3.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.growdiaryv3.R;
import com.example.growdiaryv3.constants.Constants;
import com.example.growdiaryv3.models.Diary;
import com.example.growdiaryv3.models.Plant;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHandlerDiary extends SQLiteOpenHelper {

    public DatabaseHandlerDiary(Context context) {
        super(context, Constants.DATABASE_NAME_DIARY, null, Constants.DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DIARY_TABLE = "CREATE TABLE " + Constants.TABLE_NAME_DIARY + " ("
                + Constants.KEY_ID_DIARY + " INTEGER PRIMARY KEY," + Constants.KEY_NAME_DIARY + " TEXT,"
                + Constants.KEY_DESC_DIARY + " TEXT," + Constants.KEY_DATE_ADDED_DIARY + " LONG);";
        db.execSQL(CREATE_DIARY_TABLE);

        String CREATE_PLANT_TABLE = "CREATE TABLE " + Constants.TABLE_NAME_PLANT + " ("
                + Constants.KEY_ID_PLANT + " INTEGER PRIMARY KEY,"
                + Constants.KEY_ID_FOREIGN_DIARY + " INTEGER,"
                + Constants.KEY_NAME_PLANT + " TEXT,"
                + Constants.KEY_PLANT_MEDIUM + " TEXT," + Constants.KEY_PLANT_POT_SIZE + " TEXT,"
                + Constants.KEY_PLANT_WATTAGE + " TEXT," + Constants.KEY_PLANT_MISC_NOTES + " TEXT,"
                + Constants.KEY_PLANT_SPECIES + " TEXT," + Constants.KEY_PLANT_FOREIGN_ID + " INTEGER,"
                + "FOREIGN KEY(" + Constants.KEY_ID_FOREIGN_DIARY + ") REFERENCES " +Constants.TABLE_NAME_DIARY
                +"("+Constants.KEY_ID_DIARY+
                ")"+

                ")";
        db.execSQL(CREATE_PLANT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = String.valueOf(R.string.db_drop);
        db.execSQL(DROP_TABLE, new String[]{Constants.DATABASE_NAME_DIARY});

        //db.execSQL(DROP_TABLE, new String[]{Constants.DATABASE_NAME_PLANT});

        //create new table
        onCreate(db);
    }

    //CRUD: create read update delete
    //add diary
    public void addDiary(Diary diary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.KEY_NAME_DIARY, diary.getDiaryName());
        values.put(Constants.KEY_DESC_DIARY, diary.getDiaryDesc());
        values.put(Constants.KEY_DATE_ADDED_DIARY, System.currentTimeMillis());

        //^ insert to row
        db.insert(Constants.TABLE_NAME_DIARY, null, values);
        db.close();
    }

    public void addPlant(Plant plant,int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.KEY_ID_FOREIGN_DIARY,id);
        values.put(Constants.KEY_NAME_PLANT, plant.getPlantName());
        values.put(Constants.KEY_PLANT_MEDIUM, plant.getPlantMedium());
        values.put(Constants.KEY_PLANT_POT_SIZE, plant.getPlantPotSize());
        values.put(Constants.KEY_PLANT_WATTAGE, plant.getPlantWattage());
        values.put(Constants.KEY_PLANT_MISC_NOTES, plant.getPlantDesc());
        values.put(Constants.KEY_PLANT_SPECIES, plant.getPlantSpecies());
        values.put(Constants.KEY_PLANT_FOREIGN_ID, plant.getPlantForeignId());

        //^ insert to row
        db.insert(Constants.TABLE_NAME_PLANT, null, values);
        db.close();
    }

    //get diary
    public Diary getDiary(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME_DIARY, new String[]{
                        Constants.KEY_NAME_DIARY, Constants.KEY_DESC_DIARY, Constants.KEY_DATE_ADDED_DIARY},
                Constants.KEY_ID_DIARY +"=?", new String[]{String.valueOf(id)},
                null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Diary diary = new Diary();
        diary.setDiaryId(Integer.parseInt(cursor.getString(0)));
        diary.setDiaryName(cursor.getString(1));
        diary.setDiaryDesc(cursor.getString(2));

        return diary;
    }

    //get all diaries
    public List<Diary> getAllDiaries() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Diary> diaryList = new ArrayList<>();

        Cursor cursor = db.query(Constants.TABLE_NAME_DIARY,
                new String[]{Constants.KEY_ID_DIARY,
                        Constants.KEY_NAME_DIARY,
                        Constants.KEY_DESC_DIARY,
                        Constants.KEY_DATE_ADDED_DIARY},
                null, null, null, null,
                Constants.KEY_DATE_ADDED_DIARY + " DESC");

        if (cursor.moveToFirst()) { //if item exists
            do {
                Diary diary = new Diary();
                diary.setDiaryId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID_DIARY))));
                diary.setDiaryName(cursor.getString(cursor.getColumnIndex(Constants.KEY_NAME_DIARY)));
                diary.setDiaryDesc(cursor.getString(cursor.getColumnIndex(Constants.KEY_DESC_DIARY)));

                //convert Timestamp to something readable
                DateFormat dateFormat = DateFormat.getDateInstance();
                String formattedDate = dateFormat.format(new Date(cursor.getLong(cursor.getColumnIndex(Constants.KEY_DATE_ADDED_DIARY)))
                        .getTime()); // Feb 23, 2020
                diary.setDateDiaryAdded(formattedDate);

                //Add to arraylist
                diaryList.add(diary);
            } while (cursor.moveToNext());
        }

        return diaryList;
    }

    public int updateDiary(Diary diary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.KEY_NAME_DIARY, diary.getDiaryName());
        values.put(Constants.KEY_DESC_DIARY, diary.getDiaryDesc());
        values.put(Constants.KEY_DATE_ADDED_DIARY, System.currentTimeMillis());//timestamp of the system

        db.close();
        //update row
        return db.update(Constants.TABLE_NAME_DIARY, values,
                Constants.KEY_ID_DIARY + "=?",
                new String[]{String.valueOf(diary.getDiaryId())});

    }

    //Todo: Add Delete Item
    public void deleteDiary(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Constants.TABLE_NAME_DIARY,
                Constants.KEY_ID_DIARY + "=?",
                new String[]{String.valueOf(id)});

        db.delete(Constants.TABLE_NAME_PLANT,Constants.KEY_ID_FOREIGN_DIARY
        +"=?",new String[]{String.valueOf(id)});

        //close
        db.close();

    }

    //Todo: getItemCount
    public int getItemsCount() {
        String countQuery = "SELECT * FROM " + Constants.TABLE_NAME_DIARY;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }
    public List<Plant> getAllPlants(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Plant> plantList = new ArrayList<>();

        Cursor cursor = db.query(Constants.TABLE_NAME_PLANT,
                new String[]{Constants.KEY_ID_PLANT,
                        Constants.KEY_NAME_PLANT,
                        Constants.KEY_PLANT_MEDIUM,
                        Constants.KEY_PLANT_POT_SIZE,
                        Constants.KEY_PLANT_WATTAGE,
                        Constants.KEY_PLANT_MISC_NOTES,
                        Constants.KEY_PLANT_FOREIGN_ID,
                        Constants.KEY_PLANT_SPECIES},
                Constants.KEY_PLANT_FOREIGN_ID + "=?",  new String[]{String.valueOf(id)}, null,
                null, null);

        if (cursor.moveToFirst()) { //if item exists
            do {
                Plant plant = new Plant();
                plant.setPlantId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID_PLANT))));
                plant.setPlantForeignId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_PLANT_FOREIGN_ID))));
                plant.setPlantName(cursor.getString(cursor.getColumnIndex(Constants.KEY_NAME_PLANT)));
                plant.setPlantMedium(cursor.getString(cursor.getColumnIndex(Constants.KEY_PLANT_MEDIUM)));
                plant.setPlantPotSize(cursor.getString(cursor.getColumnIndex(Constants.KEY_PLANT_POT_SIZE)));
                plant.setPlantWattage(cursor.getString(cursor.getColumnIndex(Constants.KEY_PLANT_WATTAGE)));
                plant.setPlantDesc(cursor.getString(cursor.getColumnIndex(Constants.KEY_PLANT_MISC_NOTES)));
                plant.setPlantSpecies(cursor.getString(cursor.getColumnIndex(Constants.KEY_PLANT_SPECIES)));

                //Add to arraylist
                plantList.add(plant);
            } while (cursor.moveToNext());
        }
        return plantList;
    }

    public int updatePlant(Plant plant) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.KEY_NAME_PLANT, plant.getPlantName());
        values.put(Constants.KEY_PLANT_MEDIUM, plant.getPlantMedium());
        values.put(Constants.KEY_PLANT_POT_SIZE, plant.getPlantPotSize());
        values.put(Constants.KEY_PLANT_WATTAGE, plant.getPlantWattage());
        values.put(Constants.KEY_PLANT_MISC_NOTES, plant.getPlantDesc());
        values.put(Constants.KEY_PLANT_SPECIES, plant.getPlantSpecies());

        db.close();

        //update row
        return db.update(Constants.TABLE_NAME_PLANT, values,
                Constants.KEY_ID_PLANT + "=?",
                new String[]{String.valueOf(plant.getPlantId())});
    }
    //Todo: Add Delete Item
    public void deletePlant(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Constants.TABLE_NAME_PLANT,
                Constants.KEY_ID_PLANT + "=?",
                new String[]{String.valueOf(id)});

        //close
        db.close();
    }


}

