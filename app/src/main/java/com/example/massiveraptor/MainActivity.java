package com.example.massiveraptor;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    ProgressBar bar;
    private static final String TAG = "MainActivity";

    mDatabaseHelper mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = findViewById(R.id.progressBar);
        /*CountDownTimer life = new CountDownTimer(10000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                int current = bar.getProgress() - 5;
                bar.setProgress(current);
            }

            @Override
            public void onFinish() {
                bar.setProgress(55);
            }
        }.start();*/
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, InteractActivity.class);
        startActivity(intent);
    }


}