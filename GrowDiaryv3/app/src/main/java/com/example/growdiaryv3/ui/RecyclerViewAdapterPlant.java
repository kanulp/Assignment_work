package com.example.growdiaryv3.ui;

import android.app.AlertDialog;
import android.content.Context;
import androidx.annotation.NonNull;

import com.example.growdiaryv3.R;
import com.example.growdiaryv3.data.DatabaseHandlerDiary;
import com.example.growdiaryv3.models.Plant;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.MessageFormat;
import java.util.List;

public class RecyclerViewAdapterPlant extends Adapter<RecyclerViewAdapterPlant.ViewHolder> {
    private Context context;
    private List<Plant> plantList;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private LayoutInflater inflater;

    public RecyclerViewAdapterPlant(Context context, List<Plant> plantList) {
        this.context = context;
        this.plantList = plantList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterPlant.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.plant_row, viewGroup, false);

        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Plant plant = plantList.get(position); // object plant

        viewHolder.plantName.setText(MessageFormat.format("Plant: {0}", plant.getPlantName()));
        viewHolder.plantMedium.setText(MessageFormat.format("Description: {0}", plant.getPlantMedium()));
        viewHolder.plantPotSize.setText(MessageFormat.format("Pot Size: {0}", plant.getPlantPotSize()));
        viewHolder.plantWattage.setText(MessageFormat.format("Overhead Wattage: {0}", plant.getPlantPotSize()));
        viewHolder.plantDesc.setText(MessageFormat.format("Plant Description: {0}", plant.getPlantDesc()));
        viewHolder.plantSpecies.setText(MessageFormat.format("Plant Species: {0}", plant.getPlantSpecies()));
    }

    @Override
    public int getItemCount() {
        return plantList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView plantName;
        public TextView plantMedium;
        public TextView plantPotSize;
        public TextView plantWattage;
        public TextView plantDesc;
        public TextView plantSpecies;
        public Button editButton;
        public Button deleteButton;
        public int id;

        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);

            context = ctx;

            plantName = itemView.findViewById(R.id.text_view_plant_name);
            plantMedium = itemView.findViewById(R.id.text_view_plant_medium);
            plantPotSize = itemView.findViewById(R.id.text_view_pot_size);
            plantWattage = itemView.findViewById(R.id.text_view_plant_wattage);
            plantDesc = itemView.findViewById(R.id.text_view_misc_notes);
            plantSpecies = itemView.findViewById(R.id.text_view_plant_species);

            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);

            editButton.setOnClickListener(this);
            deleteButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position;
            position = getAdapterPosition();
            Plant plant = plantList.get(position);

            switch (v.getId()) {
                case R.id.editButton:
                    //edit plant
                    editPlant(plant);
                    break;
                case R.id.deleteButton:
                    //delete plant
                    deleteItem(plant.getPlantId());
                    break;
            }
        }

        private void deleteItem(final int id) {
            builder = new AlertDialog.Builder(context);

            inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.confirmation_popup, null);

            Button noButton = view.findViewById(R.id.conf_no_button);
            Button yesButton = view.findViewById(R.id.conf_yes_button);

            builder.setView(view);
            dialog = builder.create();
            dialog.show();

            yesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DatabaseHandlerDiary db = new DatabaseHandlerDiary(context);
                    db.deletePlant(id);
                    plantList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    dialog.dismiss();

                }

            });
            noButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }

        private void editPlant(final Plant newPlant) {
            builder = new AlertDialog.Builder(context);

            inflater = LayoutInflater.from(context);
            final View view = inflater.inflate(R.layout.create_plant_popup, null);

            final Button saveButton;
            final EditText plantName,
                    plantMedium,
                    plantPotSize,
                    plantWattage,
                    plantDesc,
                    plantSpecies;

            plantName = view.findViewById(R.id.edit_text_plant_name);
            plantMedium = view.findViewById(R.id.edit_text_plant_medium);
            plantPotSize = view.findViewById(R.id.edit_text_pot_size);
            plantWattage = view.findViewById(R.id.edit_text_plant_wattage);
            plantDesc = view.findViewById(R.id.edit_text_misc_notes);
            plantSpecies = view.findViewById(R.id.edit_text_plant_species);
            saveButton = view.findViewById(R.id.saveButton);
            saveButton.setText(R.string.update_text);

            plantName.setText(newPlant.getPlantName());
            plantMedium.setText(newPlant.getPlantMedium());
            plantPotSize.setText(newPlant.getPlantPotSize());
            plantWattage.setText(newPlant.getPlantWattage());
            plantDesc.setText(newPlant.getPlantDesc());
            plantSpecies.setText(newPlant.getPlantSpecies());

            builder.setView(view);
            dialog = builder.create();
            dialog.show();

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseHandlerDiary databaseHandlerPlant = new DatabaseHandlerDiary(context);
                    //update items
                    newPlant.setPlantName(plantName.getText().toString());
                    newPlant.setPlantMedium(plantMedium.getText().toString());
                    newPlant.setPlantPotSize(plantPotSize.getText().toString());
                    newPlant.setPlantWattage(plantWattage.getText().toString());
                    newPlant.setPlantDesc(plantDesc.getText().toString());
                    newPlant.setPlantSpecies(plantSpecies.getText().toString());

                    databaseHandlerPlant.updatePlant(newPlant);
                    notifyItemChanged(getAdapterPosition(), newPlant); //important!

                    dialog.dismiss();
                }
            });
        }
    }
}