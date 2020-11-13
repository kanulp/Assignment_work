package com.example.growdiaryv3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.growdiaryv3.data.DatabaseHandlerDiary;
import com.example.growdiaryv3.models.Plant;
import com.example.growdiaryv3.ui.RecyclerViewAdapterPlant;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class PlantActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private RecyclerViewAdapterPlant recyclerViewAdapterPlant;
    private List<Plant> plantList;
    private DatabaseHandlerDiary databaseHandlerDiary;
    private FloatingActionButton fab;
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    private Button saveButton;
    private EditText plantName,
            plantMedium,
            plantPotSize,
            plantWattage,
            plantDesc,
            plantSpecies;
    Intent intent;
    private int plantForeignId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);

        intent = getIntent();
        plantForeignId = Integer.parseInt(intent.getExtras().getString("DIARY_ID"));

        recyclerView = findViewById(R.id.recyclerview_plant);
        fab = findViewById(R.id.fab_plant);

        databaseHandlerDiary = new DatabaseHandlerDiary(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        plantList = new ArrayList<>();
        //Get items from db
        plantList = databaseHandlerDiary.getAllPlants(plantForeignId);




        recyclerViewAdapterPlant = new RecyclerViewAdapterPlant(this, plantList);
        recyclerView.setAdapter(recyclerViewAdapterPlant);
        recyclerViewAdapterPlant.notifyDataSetChanged();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopDialog();
            }
        });
    }

    private void createPopDialog() {
        builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.create_plant_popup, null);

        plantName = view.findViewById(R.id.edit_text_plant_name);
        plantMedium = view.findViewById(R.id.edit_text_plant_medium);
        plantPotSize = view.findViewById(R.id.edit_text_pot_size);
        plantWattage = view.findViewById(R.id.edit_text_plant_wattage);
        plantDesc = view.findViewById(R.id.edit_text_misc_notes);
        plantSpecies = view.findViewById(R.id.edit_text_plant_species);
        saveButton = view.findViewById(R.id.saveButton);

        builder.setView(view);
        alertDialog = builder.create();
        alertDialog.show();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePlant(v);
            }
        });
    }


    private void savePlant(View view) {
        intent = getIntent();
        plantForeignId = Integer.parseInt(intent.getExtras().getString("DIARY_ID"));

        final Plant plant = new Plant();

        String newPlantName = plantName.getText().toString().trim();
        String newPlantMedium = plantMedium.getText().toString().trim();
        String newPlantPotSize = plantPotSize.getText().toString().trim();
        String newPlantWattage = plantWattage.getText().toString().trim();
        String newPlantDesc = plantDesc.getText().toString().trim();
        String newPlantSpecies = plantSpecies.getText().toString().trim();

        plant.setPlantName(newPlantName);
        plant.setPlantMedium(newPlantMedium);
        plant.setPlantPotSize(newPlantPotSize);
        plant.setPlantWattage(newPlantWattage);
        plant.setPlantDesc(newPlantDesc);
        plant.setPlantSpecies(newPlantSpecies);
        plant.setPlantForeignId(plantForeignId);

        databaseHandlerDiary.addPlant(plant,plantForeignId);
        plantList.add(plant);
        recyclerViewAdapterPlant.notifyItemInserted(plantList.size() - 1);

        //Toast.makeText(this, "Plant Saved", Toast.LENGTH_SHORT).show();
        //Toast.makeText(context, "" + plantForeignId, Toast.LENGTH_SHORT).show();
        alertDialog.dismiss();
    }

    @Override
    public void onClick(View v) {

    }

}
