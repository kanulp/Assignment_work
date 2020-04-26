package com.example.employeeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employeeproject.R;
import com.example.employeeproject.data.Car;
import com.example.employeeproject.data.Employee;
import com.example.employeeproject.data.Manager;
import com.example.employeeproject.data.Motorcycle;
import com.example.employeeproject.data.Programmer;
import com.example.employeeproject.data.Tester;
import com.example.employeeproject.data.Vehicle;

import java.util.Calendar;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {


    EditText ed_first_name,ed_last_name,ed_birth_year,ed_monthly_salary,ed_occupation_rate,ed_emp_id,
            ed_emp_type_number,ed_car_type,ed_vehicle_model,ed_vehicle_plat_number;
     Spinner sp_emp_type,sp_vehicle_color;
     RadioGroup radio_group_vehicle,radio_group_sidecar;
     RadioButton radio_car,radio_motorbike,radio_yes,radio_no;

     LinearLayout layout_emp_type_number,layout_sidecar,layout_car_type;
     TextView txt_emp_type_number,mydata;
     Button btn_register;

     String emp_type;
     String car_color;
     boolean isCarorMotor,isSideCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bindViews();
        printData();

    }

    private void bindViews() {
        ed_first_name = findViewById(R.id.ed_first_name);
        ed_last_name = findViewById(R.id.ed_last_name);
        ed_birth_year = findViewById(R.id.ed_birth_year);
        ed_monthly_salary = findViewById(R.id.ed_monthly_salary);
        ed_occupation_rate = findViewById(R.id.ed_occupation_rate);
        ed_emp_id = findViewById(R.id.ed_emp_id);
        ed_emp_type_number = findViewById(R.id.ed_emp_type_number);
        ed_car_type = findViewById(R.id.ed_car_type);
        ed_vehicle_model = findViewById(R.id.ed_vehicle_model);
        ed_vehicle_plat_number = findViewById(R.id.ed_vehicle_plat_number);
        sp_emp_type = findViewById(R.id.sp_emp_type);
        sp_vehicle_color = findViewById(R.id.sp_vehicle_color);
        radio_group_vehicle = findViewById(R.id.radio_group_vehicle);
        radio_group_sidecar = findViewById(R.id.radio_group_sidecar);
        radio_car = findViewById(R.id.radio_car);
        radio_motorbike = findViewById(R.id.radio_motorbike);
        radio_yes = findViewById(R.id.radio_yes);
        radio_no = findViewById(R.id.radio_no);
        layout_emp_type_number = findViewById(R.id.layout_emp_type_number);
        layout_sidecar = findViewById(R.id.layout_sidecar);
        layout_car_type = findViewById(R.id.layout_car_type);
        txt_emp_type_number = findViewById(R.id.txt_emp_type_number);
        btn_register = findViewById(R.id.btn_register);

        mydata = findViewById(R.id.mydata);

        layout_emp_type_number.setVisibility(View.GONE);
        layout_sidecar.setVisibility(View.GONE);
        layout_car_type.setVisibility(View.GONE);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.emp_type_arrays) );
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_emp_type.setAdapter(dataAdapter);

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.vehicle_color_arrays) );
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_vehicle_color.setAdapter(dataAdapter2);

        sp_emp_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                emp_type = adapterView.getItemAtPosition(i).toString();

                if(i==0){
                    layout_emp_type_number.setVisibility(View.GONE);
                }
                else if(i==1){
                    layout_emp_type_number.setVisibility(View.VISIBLE);
                    txt_emp_type_number.setText("# clients");

                }else if(i==2){
                    layout_emp_type_number.setVisibility(View.VISIBLE);
                    txt_emp_type_number.setText("# bugs");

                }else if(i==3){
                    layout_emp_type_number.setVisibility(View.VISIBLE);
                    txt_emp_type_number.setText("# projects");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp_vehicle_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 car_color = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        radio_group_vehicle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.radio_car) {
                    layout_car_type.setVisibility(View.VISIBLE);
                    layout_sidecar.setVisibility(View.GONE);
                    isCarorMotor=true;

                } else if(checkedId == R.id.radio_motorbike) {
                    layout_car_type.setVisibility(View.GONE);
                    isCarorMotor=false;
                    layout_sidecar.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getApplicationContext(), "choice: error in vehicle type ",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        radio_group_sidecar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.radio_yes) {
                     isSideCar=true;
                } else if(checkedId == R.id.radio_no) {

                    isSideCar=false;
                } else {
                    Toast.makeText(getApplicationContext(), "choice: error in choice side",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public void printData(){

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    final String first_name = ed_first_name.getText().toString();
                    if (first_name.equals("")) {
                        showErrorDialog(RegisterActivity.this, "Please Enter First Name");
                        return;
                    }
                    final String last_name = ed_last_name.getText().toString();
                    if (last_name.equals("")) {
                        showErrorDialog(RegisterActivity.this, "Please Enter Last Name");
                        return;
                    }

                     String birth_yearString = ed_birth_year.getText().toString();
                     if(birth_yearString.length()!=4){
                         showErrorDialog(RegisterActivity.this, "Birth year must be valid 4 digit");
                         return;
                     }
                    final int birth_year = Integer.parseInt(birth_yearString);
                    if (birth_year <= 1940 || birth_year > 2020) {
                        showErrorDialog(RegisterActivity.this, "Please Enter valid birth year between 1940 to 2020");
                        return;
                    }

                    final String monthly_salaryString = ed_monthly_salary.getText().toString();
                    if(monthly_salaryString.length()>=7){
                        showErrorDialog(RegisterActivity.this, "Monthly Salary can not be like more");
                        return;
                    }
                    final int monthly_salary = Integer.parseInt(monthly_salaryString);
                    if (monthly_salary < 0 || monthly_salary >= 100000000) {
                        showErrorDialog(RegisterActivity.this, "Monthly Salary must be valid");
                        return;
                    }

                    final String occupation_rateString = ed_occupation_rate.getText().toString();
                    if(occupation_rateString.length()>3){
                        showErrorDialog(RegisterActivity.this, "Occupation rate must be 0 to 100");
                        return;
                    }
                    final int occupation_rate = Integer.parseInt(occupation_rateString);
                    if (occupation_rate < 0 || occupation_rate >= 100) {
                        showErrorDialog(RegisterActivity.this, "Occupation Rate must be greater than 0");
                        return;
                    }

                    final String emp_idString = ed_emp_id.getText().toString();
                    if(emp_idString.length()>=7) {
                        showErrorDialog(RegisterActivity.this, "Emp ID must not be too big");
                        return;
                    }
                    final int emp_id = Integer.parseInt(ed_emp_id.getText().toString());
                    if (emp_id <= 0 || emp_id >= 9999) {
                        showErrorDialog(RegisterActivity.this, "Id  must be greater than 0");
                        return;
                    }
                    if (emp_type.equals("")) {
                        showErrorDialog(RegisterActivity.this, "Please select emp type ");
                        return;
                    }

                    final String emp_type_numberString = ed_emp_type_number.getText().toString();
                    if(emp_type_numberString.length()>6) {
                        showErrorDialog(RegisterActivity.this, "Number can not be too big");
                        return;
                    }
                    final int emp_type_number = Integer.parseInt(emp_type_numberString);
                    if (emp_type_number <= 0 || emp_type_number >= 2000) {
                        showErrorDialog(RegisterActivity.this, "Number must be greater than 0");
                        return;
                    }
                    if (radio_group_vehicle.getCheckedRadioButtonId() == -1)
                    {
                        showErrorDialog(RegisterActivity.this, "Select Vehicle Type");
                    }



                    final String car_type = ed_car_type.getText().toString();
                    if ( radio_car.isSelected() && car_type.equals("")) {
                        showErrorDialog(RegisterActivity.this, "Car type must not be empty");
                        return;
                    }

                    final String vehicle_model = ed_vehicle_model.getText().toString();
                    if (vehicle_model.equals("")) {
                        showErrorDialog(RegisterActivity.this, "Vehicle model must not be empty");
                        return;
                    }

                    final String vehicle_plat_number = ed_vehicle_plat_number.getText().toString();
                    if (vehicle_plat_number.equals("")) {
                        showErrorDialog(RegisterActivity.this, "Vehicle plate number must not be empty");
                        return;
                    }

                    Car car = null;
                    Motorcycle motorcycle = null;
                    if (isCarorMotor)
                        car = new Car(vehicle_model, vehicle_plat_number, car_color, "Car", car_type);
                    else {
                        motorcycle = new Motorcycle(vehicle_model, vehicle_plat_number, car_color, "Motorcycle", isSideCar ? 1 : 0);
                    }

                    Log.d("MYDATA", "ee");

                    //DBHelper dbHelper = new DBHelper(RegisterActivity.this);
                    DBHelper dbHelper = DBHelper.getInstance(RegisterActivity.this);

                    int age = Calendar.getInstance().get(Calendar.YEAR) - birth_year;
                    Log.d("MYDATA : emp type :", emp_type);

//                if(emp_type.equalsIgnoreCase("Manager")){
//                    Manager manager = new Manager(emp_id,first_name,last_name,age,birth_year,monthly_salary,occupation_rate,isCarorMotor?car:motorcycle,emp_type_number);
//                    mydata.setText(manager.toDisplay());
//                }else if(emp_type.equalsIgnoreCase("Tester")){
//                    Tester tester = new Tester(emp_id,first_name,last_name,age,birth_year,monthly_salary,occupation_rate,isCarorMotor?car:motorcycle,emp_type_number);
//                    mydata.setText(tester.toDisplay());
//                }else if(emp_type.equalsIgnoreCase("Programmer")){
//                    Programmer programmer = new Programmer(emp_id,first_name,last_name,age,birth_year,monthly_salary,occupation_rate,isCarorMotor?car:motorcycle,emp_type_number);
//                    mydata.setText(programmer.toDisplay());
//                }else{
//                    Toast.makeText(RegisterActivity.this, "Error!", Toast.LENGTH_SHORT).show();
//                }

                    if (dbHelper.insertEmployee(emp_id, first_name, last_name, age, birth_year, monthly_salary, occupation_rate, emp_type, emp_type_number, vehicle_model, vehicle_plat_number, car_color, isCarorMotor ? "Car" : "Motorcycle", car_type, isSideCar ? 1 : 0))
                        Toast.makeText(RegisterActivity.this, "Inserted SuccessFully.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(RegisterActivity.this, "Error in Inserted.", Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void showErrorDialog(Context context,String error){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setTitle("Error");
        builder1.setMessage(error);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Okay",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }





}
