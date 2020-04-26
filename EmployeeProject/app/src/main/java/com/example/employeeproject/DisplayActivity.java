package com.example.employeeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String data = getIntent().getExtras().getString("data");
        displayText = findViewById(R.id.displayText);
        displayText.setText(data);


    }
}
