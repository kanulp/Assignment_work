package com.example.ecommerce_sakkaravarthi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class FoodMenuGridActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FoodMenuListAdapter mAdapter;
    ArrayList<FoodMenu> foodMenuArrayList = new ArrayList<FoodMenu>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu_grid);

        mRecyclerView = findViewById(R.id.recyclerview_food);
        loadFoodMenu();
        loadRecyclerView();

    }

    public void loadRecyclerView(){
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(FoodMenuGridActivity.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mAdapter = new FoodMenuListAdapter(getApplicationContext(), foodMenuArrayList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void loadFoodMenu(){
        foodMenuArrayList.add(new FoodMenu("Pizza","18.0"));
        foodMenuArrayList.add(new FoodMenu("Burger","50.0"));
        foodMenuArrayList.add(new FoodMenu("Sabzi Roti","30.3"));
        foodMenuArrayList.add(new FoodMenu("Frankie","20.0"));
        foodMenuArrayList.add(new FoodMenu("Juice", "40.0"));
        foodMenuArrayList.add(new FoodMenu("Panipuri","10.0"));
        foodMenuArrayList.add(new FoodMenu("Vadapav","5.0"));
        foodMenuArrayList.add(new FoodMenu("Aloopuri","4.0"));
        foodMenuArrayList.add(new FoodMenu("Chicken Wings","15.5"));
        foodMenuArrayList.add(new FoodMenu("Apple Pie","4.0"));

    }


}
