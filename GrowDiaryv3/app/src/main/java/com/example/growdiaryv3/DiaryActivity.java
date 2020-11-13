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
import com.example.growdiaryv3.models.Diary;
import com.example.growdiaryv3.ui.RecyclerViewAdapterDiary;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiaryActivity extends AppCompatActivity {

    private static final String TAG = "ListActivity";
    private RecyclerView recyclerView;
    private RecyclerViewAdapterDiary recyclerViewAdapterDiary;
    private List<Diary> diaryList;
    private DatabaseHandlerDiary databaseHandlerDiary;
    private FloatingActionButton fab;
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    private Button saveButton;
    private EditText diaryName;
    private EditText diaryDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        recyclerView = findViewById(R.id.recyclerview);
        fab = findViewById(R.id.fab);

        databaseHandlerDiary = new DatabaseHandlerDiary(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        diaryList = new ArrayList<>();

        //Get items from db
        diaryList = databaseHandlerDiary.getAllDiaries();

        recyclerViewAdapterDiary = new RecyclerViewAdapterDiary(this, diaryList);
        recyclerView.setAdapter(recyclerViewAdapterDiary);
        recyclerViewAdapterDiary.notifyDataSetChanged();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopDialog();
            }
        });
    }



    private void createPopDialog() {
        builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.create_diary_popup, null);
        diaryName = view.findViewById(R.id.edit_text_name_diary);
        diaryDesc = view.findViewById(R.id.edit_text_desc_diary);
        saveButton = view.findViewById(R.id.saveButton);
        Context context;

        builder.setView(view);
        alertDialog = builder.create();
        alertDialog.show();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!diaryName.getText().toString().isEmpty()
                        && !diaryDesc.getText().toString().isEmpty()) {
                    saveItem(v);
                }else {
                    Snackbar.make(v, "Empty Fields not Allowed", Snackbar.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

    private void saveItem(View view) {
        //Todo: save each baby diary to db
        DateFormat dateFormat = DateFormat.getDateInstance();
        String formattedDate = dateFormat.format(java.lang.System.currentTimeMillis());


        Intent intent = new Intent(this, DiaryActivity.class);

        final Diary diary = new Diary();

        String newDiary = diaryName.getText().toString().trim();
        String newDesc = diaryDesc.getText().toString().trim();

        diary.setDiaryName(newDiary);
        diary.setDiaryDesc(newDesc);
        diary.setDateDiaryAdded(formattedDate);

        databaseHandlerDiary.addDiary(diary);
        diaryList.add(diary);
        Collections.sort(diaryList);
        recyclerViewAdapterDiary.notifyItemInserted(diaryList.size() - 1);

        Toast.makeText(this, "Diary Saved", Toast.LENGTH_SHORT).show();



        alertDialog.dismiss();

        startActivity(intent);
        finish();
    }
}
