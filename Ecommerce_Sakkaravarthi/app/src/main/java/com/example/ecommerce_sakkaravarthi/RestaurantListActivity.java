package com.example.ecommerce_sakkaravarthi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class RestaurantListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RestaurantListAdapter mAdapter;
    ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        getSupportActionBar().setTitle("Select Restaurant");
        mRecyclerView = findViewById(R.id.recyclerView);
        loadRestaurant();
        loadRecyclerView();

    }

    public void loadRecyclerView(){
        mAdapter = new RestaurantListAdapter(getApplicationContext(), restaurants);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(RestaurantListActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

    }

    public void loadRestaurant(){
        restaurants.add(new Restaurant("King Taps","Bar","3.0"));
        restaurants.add(new Restaurant("Golden Star","Hot Dogs","4.0"));
        restaurants.add(new Restaurant("Chinese Sea","Sea Food","5.0"));
        restaurants.add(new Restaurant("China Palace","Manchurian","2.5"));
        restaurants.add(new Restaurant("Mandarin Rexdale","Noodle","3.5"));
        restaurants.add(new Restaurant("Honest","Sabzi,Roti","4.5"));
        restaurants.add(new Restaurant("Dhaba","Indian","1.0"));
        restaurants.add(new Restaurant("Den Star","Pizza","2.5"));
        restaurants.add(new Restaurant("Pizza Hub","Pizza","4.0"));
        restaurants.add(new Restaurant("Freshii","Juice","3.0"));

    }
}
