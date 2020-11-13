package com.example.growdiaryv3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.growdiaryv3.data.DatabaseHandlerDiary;
import com.example.growdiaryv3.models.Diary;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private Button saveButton;
    private EditText diaryName;
    private EditText diaryDesc;
    private DatabaseHandlerDiary databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        databaseHandler = new DatabaseHandlerDiary(this);

        byPassActivity();

        //check if item was saved
        List<Diary> diaries = databaseHandler.getAllDiaries();
        for (Diary diary : diaries) {
            Log.d("Main", "onCreate: " + diary.getDiaryDesc());
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopupDialog();
            }
        });
    }

    private void byPassActivity() {
        if (databaseHandler.getItemsCount() > 0) {
            startActivity(new Intent(MainActivity.this, DiaryActivity.class));
            finish();
        }
    }

    private void saveDiary(View view) {
        Diary diary = new Diary();

        String newDiary = diaryName.getText().toString().trim();
        String newDesc = diaryDesc.getText().toString().trim();

        diary.setDiaryName(newDiary);
        diary.setDiaryDesc(newDesc);

        databaseHandler.addDiary(diary);

        Snackbar.make(view, "Diary Saved",Snackbar.LENGTH_SHORT)
                .show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //code to be run
                dialog.dismiss();
                //Todo: move to next screen - details screen
                startActivity(new Intent(MainActivity.this, DiaryActivity.class));

            }
        }, 1200);// 1sec
    }

    private void createPopupDialog() {
        builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.create_diary_popup, null);

        diaryName = view.findViewById(R.id.edit_text_name_diary);
        diaryDesc = view.findViewById(R.id.edit_text_desc_diary);
        saveButton = view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!diaryName.getText().toString().isEmpty()
                        && !diaryDesc.getText().toString().isEmpty()) {
                    saveDiary(v);
                }else {
                    Snackbar.make(v, "Empty Fields not Allowed", Snackbar.LENGTH_SHORT)
                            .show();
                }
            }
        });

        builder.setView(view);
        dialog = builder.create();// creating our dialog object
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem diary) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = diary.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(diary);
    }
}