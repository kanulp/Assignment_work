package com.example.employeeproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.employeeproject.data.Car;
import com.example.employeeproject.data.Employee;
import com.example.employeeproject.data.Manager;
import com.example.employeeproject.data.Motorcycle;
import com.example.employeeproject.data.Programmer;
import com.example.employeeproject.data.Tester;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";

    public static final String EMPLOYEE_TABLE_NAME = "employee";
    public static final String EMPLOYEE_COLUMN_ID = "id";
    public static final String EMPLOYEE_COLUMN_FNAME = "first_name";
    public static final String EMPLOYEE_COLUMN_LNAME = "last_name";
    public static final String EMPLOYEE_COLUMN_AGE = "age";
    public static final String EMPLOYEE_COLUMN_BIRTHYEAR = "birthyear";
    public static final String EMPLOYEE_COLUMN_SALARY = "monthly_salary";
    public static final String EMPLOYEE_COLUMN_OCCUPATION_RATE = "rate";
    public static final String EMPLOYEE_COLUMN_EMP_TYPE= "emp_type";
    public static final String EMPLOYEE_COLUMN_EMP_NUMBER_COUNT = "emp_number_count";
    public static final String EMPLOYEE_COLUMN_VEHICLE_TYPE = "vehicle_type";
    public static final String EMPLOYEE_COLUMN_VEHICLE_MODEL = "vehicle_model";
    public static final String EMPLOYEE_COLUMN_VEHICLE_PLATE = "vehicle_plate";
    public static final String EMPLOYEE_COLUMN_VEHICLE_COLOR = "vehicle_color";
    public static final String EMPLOYEE_COLUMN_VEHICLE_CAR_TYPE = "vehicle_car_type";
    public static final String EMPLOYEE_COLUMN_VEHICLE_SIDE_CAR = "vehicle_side_car";

    private Context context;


       private DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
        this.context=context;
       }

    private static DBHelper INSTANCE =null;

    public static DBHelper getInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = new DBHelper(context.getApplicationContext());
        }
        return(INSTANCE);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table  " +EMPLOYEE_TABLE_NAME+
                        "(id integer primary key, first_name text,last_name text,age integer, birthyear integer ,monthly_salary integer,rate integer, emp_type text, emp_number_count integer, vehicle_type text,vehicle_model text, vehicle_plate text, vehicle_color text, vehicle_car_type text, vehicle_side_car integer)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+EMPLOYEE_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertEmployee (int id, String first_name, String last_name, int age, int birthYear, int monthlySalary, int rate, String emp_type, int emp_number_count, String make, String plate, String color, String type, String car_type, int hasSideCar ) {
            SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMPLOYEE_COLUMN_FNAME, first_name);
        contentValues.put(EMPLOYEE_COLUMN_LNAME, last_name);
        contentValues.put(EMPLOYEE_COLUMN_ID, id);
        contentValues.put(EMPLOYEE_COLUMN_AGE, age);
        contentValues.put(EMPLOYEE_COLUMN_BIRTHYEAR, birthYear);
        contentValues.put(EMPLOYEE_COLUMN_SALARY, monthlySalary);
        contentValues.put(EMPLOYEE_COLUMN_OCCUPATION_RATE, rate);
        contentValues.put(EMPLOYEE_COLUMN_EMP_TYPE, emp_type);
        contentValues.put(EMPLOYEE_COLUMN_EMP_NUMBER_COUNT, emp_number_count);
        contentValues.put(EMPLOYEE_COLUMN_VEHICLE_MODEL, make);
        contentValues.put(EMPLOYEE_COLUMN_VEHICLE_PLATE, plate);
        contentValues.put(EMPLOYEE_COLUMN_VEHICLE_COLOR, color);
        contentValues.put(EMPLOYEE_COLUMN_VEHICLE_TYPE, type);
        contentValues.put(EMPLOYEE_COLUMN_VEHICLE_CAR_TYPE, car_type);
        contentValues.put(EMPLOYEE_COLUMN_VEHICLE_SIDE_CAR, hasSideCar);
        db.insert(EMPLOYEE_TABLE_NAME, null, contentValues);
        return true;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, EMPLOYEE_TABLE_NAME);
        return numRows;
    }

    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> array_list = new ArrayList<Employee>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+EMPLOYEE_TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){

            int id = res.getInt(res.getColumnIndex(EMPLOYEE_COLUMN_ID));
            String first_name = res.getString(res.getColumnIndex(EMPLOYEE_COLUMN_FNAME));
            String last_name = res.getString(res.getColumnIndex(EMPLOYEE_COLUMN_LNAME));
            int age = res.getInt(res.getColumnIndex(EMPLOYEE_COLUMN_AGE));
            int birth_year = res.getInt(res.getColumnIndex(EMPLOYEE_COLUMN_BIRTHYEAR));

            int monthly_salary = res.getInt(res.getColumnIndex(EMPLOYEE_COLUMN_SALARY));
            int occupation_rate = res.getInt(res.getColumnIndex(EMPLOYEE_COLUMN_OCCUPATION_RATE));

            String emp_type = res.getString(res.getColumnIndex(EMPLOYEE_COLUMN_EMP_TYPE));

            int emp_type_number_count = res.getInt(res.getColumnIndex(EMPLOYEE_COLUMN_EMP_NUMBER_COUNT));

            String car_type = res.getString(res.getColumnIndex(EMPLOYEE_COLUMN_VEHICLE_CAR_TYPE));

            String vehicle_model = res.getString(res.getColumnIndex(EMPLOYEE_COLUMN_VEHICLE_MODEL));
            String vehicle_plat_number = res.getString(res.getColumnIndex(EMPLOYEE_COLUMN_VEHICLE_PLATE));
            String vehicle_type = res.getString(res.getColumnIndex(EMPLOYEE_COLUMN_VEHICLE_TYPE));
            int vehicle_side_car = res.getInt(res.getColumnIndex(EMPLOYEE_COLUMN_VEHICLE_SIDE_CAR));
            String car_color = res.getString(res.getColumnIndex(EMPLOYEE_COLUMN_VEHICLE_COLOR));

            boolean emp_vehicle_type;
            Car car = null;
            Motorcycle motorcycle=null;
            if(vehicle_type=="Car") {
                emp_vehicle_type = true;
                car = new Car(vehicle_model, vehicle_plat_number, car_color, "Car", car_type);
            }else {
                emp_vehicle_type = false;
                motorcycle = new Motorcycle(vehicle_model,vehicle_plat_number,car_color,"Motorcycle",vehicle_side_car);

            }

            if(emp_type.equals("Manager")){
                Manager manager = new Manager(id,first_name,last_name,age,birth_year,monthly_salary,occupation_rate,emp_vehicle_type?car:motorcycle,emp_type_number_count);
                array_list.add((manager));
            }else if(emp_type.equals("Programmer")){
                Tester tester = new Tester(id,first_name,last_name,age,birth_year,monthly_salary,occupation_rate,emp_vehicle_type?car:motorcycle,emp_type_number_count);
                array_list.add(tester);
            }else if(emp_type.equals("Tester")){
                Programmer programmer = new Programmer(id,first_name,last_name,age,birth_year,monthly_salary,occupation_rate,emp_vehicle_type?car:motorcycle,emp_type_number_count);
                array_list.add(programmer);
            }
            res.moveToNext();
        }
        return array_list;
    }
}