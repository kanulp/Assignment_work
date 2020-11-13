package com.example.growdiaryv3.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.growdiaryv3.DiaryActivity;
import com.example.growdiaryv3.PlantActivity;
import com.example.growdiaryv3.R;
import com.example.growdiaryv3.data.DatabaseHandlerDiary;
import com.example.growdiaryv3.models.Diary;
import com.google.android.material.snackbar.Snackbar;

import java.text.MessageFormat;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public class RecyclerViewAdapterDiary extends Adapter<RecyclerViewAdapterDiary.ViewHolder> {
    private Context context;
    private List<Diary> diaryList;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private LayoutInflater inflater;

    public RecyclerViewAdapterDiary(Context context, List<Diary> diaryList) {
        this.context = context;
        this.diaryList = diaryList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterDiary.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.diary_row, viewGroup, false);


        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterDiary.ViewHolder viewHolder, int position) {
        Diary diary = diaryList.get(position);

        viewHolder.diaryName.setText(MessageFormat.format("Diary: {0}", diary.getDiaryName()));
        viewHolder.diaryDesc.setText(MessageFormat.format("Description: {0}", diary.getDiaryDesc()));
        viewHolder.dateAdded.setText(MessageFormat.format("Added on: {0}", diary.getDateDiaryAdded()));
    }

    @Override
    public int getItemCount() {
        return diaryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView diaryName;
        public TextView diaryDesc;
        public TextView dateAdded;
        public Button editButton;
        public Button deleteButton;
        public CardView cardView;
        public int id;

        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;

            diaryName = itemView.findViewById(R.id.diary_name);
            diaryDesc = itemView.findViewById(R.id.diary_desc);
            dateAdded = itemView.findViewById(R.id.diary_date_added);

            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);

            cardView = itemView.findViewById(R.id.cardview);
            editButton.setOnClickListener(this);
            deleteButton.setOnClickListener(this);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position;
            position = getAdapterPosition();
            Diary diary = diaryList.get(position);

            String diaryId = String.valueOf(diary.getDiaryId());


            switch (v.getId()) {
                case R.id.editButton:
                    //edit diary
                    editItem(diary);
                    break;
                case R.id.deleteButton:
                    //delete diary
                    deleteDiary(diary.getDiaryId());
                    break;
                case R.id.cardview:
                    //go to plant activity
                    Intent intent;
                    intent = new Intent(context, PlantActivity.class);
                    //Toast.makeText(context, "" + diary.getDiaryId(), Toast.LENGTH_SHORT).show();
                    intent.putExtra("DIARY_ID", diaryId);
                    context.startActivity(intent);
                    break;
            }
        }

        private void deleteDiary(final int id) {
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
                    db.deleteDiary(id);
                    diaryList.remove(getAdapterPosition());
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

        private void editItem(final Diary newDiary) {
            builder = new AlertDialog.Builder(context);

            inflater = LayoutInflater.from(context);
            final View view = inflater.inflate(R.layout.create_diary_popup, null);

            Button saveButton;
            final EditText diaryName;
            final EditText diaryDesc;
            TextView title;

            diaryName = view.findViewById(R.id.edit_text_name_diary);
            diaryDesc = view.findViewById(R.id.edit_text_desc_diary);
            saveButton = view.findViewById(R.id.saveButton);
            saveButton.setText(R.string.update_text);
            title = view.findViewById(R.id.title);

            diaryName.setText(newDiary.getDiaryName());
            diaryDesc.setText(newDiary.getDiaryDesc());

            builder.setView(view);
            dialog = builder.create();
            dialog.show();

            saveButton.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseHandlerDiary databaseHandlerDiary = new DatabaseHandlerDiary(context);

                    //update items
                    newDiary.setDiaryName(diaryName.getText().toString());
                    newDiary.setDiaryDesc(diaryDesc.getText().toString());

                    if (!diaryName.getText().toString().isEmpty()
                            && !diaryDesc.getText().toString().isEmpty()) {

                        databaseHandlerDiary.updateDiary(newDiary);
                        notifyItemChanged(getAdapterPosition(), newDiary); //important!

                    }else {
                        Snackbar.make(view, "Fields Empty",
                                Snackbar.LENGTH_SHORT)
                                .show();
                    }

                    dialog.dismiss();
                }
            });
        }
    }
}
