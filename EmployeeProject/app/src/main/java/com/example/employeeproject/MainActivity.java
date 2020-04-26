package com.example.employeeproject;

import android.content.Intent;
import android.os.Bundle;
import com.example.employeeproject.data.Employee;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView list_emp;
    EditText ed_search;

    DBHelper dbHelper ;

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list_emp = findViewById(R.id.list_emp);
        ed_search = findViewById(R.id.ed_search);
        ed_search.setSingleLine(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        //dbHelper = new DBHelper(MainActivity.this);
        dbHelper = DBHelper.getInstance(MainActivity.this);

        displayList();

        ed_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("Text ["+s+"]");
                customAdapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

    }



    public void displayList(){
        Log.d("MYDATA","Execute here");
        ArrayList<Employee> employees = dbHelper.getAllEmployees();

         customAdapter = new CustomAdapter(MainActivity.this,employees);
        list_emp.setAdapter(customAdapter);

        Log.d("MYDATA : LEN",dbHelper.numberOfRows()+" ok.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayList();
    }

}
