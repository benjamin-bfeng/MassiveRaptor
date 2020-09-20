package com.example.massiveraptor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InteractActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interact);
    }

    public void sleepActivity(View view) {
        Intent intent = new Intent(this, SleepActivity.class);
        startActivity(intent);
    }
    public void toDoActivity(View view) {
        Intent intent = new Intent(this, ToDoActivity.class);
        startActivity(intent);
    }

    public void historyActivity(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
}