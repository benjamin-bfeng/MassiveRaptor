package com.example.massiveraptor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Calendar;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    ProgressBar bar;

    private static final String TAG = "MainActivity";
    boolean showedToday = false;

    mDatabaseHelper mDatabaseHelper = new mDatabaseHelper(MainActivity.this);
    private EditText editText;
    public void AddData(HistoryEntry historyEntry){
        boolean insertData = mDatabaseHelper.addData(historyEntry);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = findViewById(R.id.progressBar);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String todayString = year + " " + month + " " + day;
        SharedPreferences preferences = getSharedPreferences("PREFS",0);
        boolean currentDay = preferences.getBoolean(todayString, false);

        if(!currentDay){
           HistoryEntry h = new HistoryEntry(todayString,0);
           AddData(h);
        }

        else{
           //do nothing
        }
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, InteractActivity.class);
        startActivity(intent);
    }


}