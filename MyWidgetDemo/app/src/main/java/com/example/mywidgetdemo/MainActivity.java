package com.example.mywidgetdemo;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREF="SHARED_PREFS";
    public static final String KEY="KEY_TEXT";

    private EditText editText;

    private Button button;
    private TextView final_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = (EditText)findViewById(R.id.edit_height);
        button = (Button)findViewById(R.id.button_save);
        final_text = (TextView)findViewById(R.id.text_final);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = editText.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(KEY, Integer.parseInt(val));

                editor.apply();
                String finalText = "You cal is "+(Integer.parseInt(val)*30);
                final_text.setText(finalText);
                callUpdateWidget(MainActivity.this,finalText);
            }
        });

    }

    void callUpdateWidget(Context context,String final_text){
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.example_app_widget_provider);
        ComponentName thisWidget = new ComponentName(context, ExampleAppWidgetProvider.class);
        remoteViews.setTextViewText(R.id.appwidget_text,final_text);
        appWidgetManager.updateAppWidget(thisWidget, remoteViews);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
