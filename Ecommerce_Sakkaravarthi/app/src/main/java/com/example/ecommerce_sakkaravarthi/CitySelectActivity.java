package com.example.ecommerce_sakkaravarthi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CitySelectActivity extends AppCompatActivity {

    ArrayList<String> cityList = new ArrayList<String>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_select);
        loadCategories();
        getSupportActionBar().setTitle("Select City");
        listView = findViewById(R.id.listview);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (CitySelectActivity.this, android.R.layout.simple_list_item_1, cityList);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=adapter.getItem(position);
                Intent intent = new Intent(CitySelectActivity.this,RestaurantListActivity.class);
                startActivity(intent);
            }
        });
    }

    public void loadCategories(){
        cityList.add("Toronto");
        cityList.add("Calgary");
        cityList.add("Hamilton");
        cityList.add("London");
        cityList.add("Peterborough");
        cityList.add("Windsor");
        cityList.add("Winnipeg");
        cityList.add("Ottawa");
        cityList.add("Halifax");
    }
}
