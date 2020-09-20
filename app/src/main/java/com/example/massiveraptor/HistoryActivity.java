/*package com.example.massiveraptor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter historyArrayAdapter;
    mDatabaseHelper mHelper;
    ArrayList<HistoryEntry> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        listView = findViewById(R.id.history);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mHelper = new mDatabaseHelper(HistoryActivity.this);
        arrayList = new ArrayList<>();

        //List<HistoryEntry> all = mDatabaseHelper.historyEntryList();
        //historyArrayAdapter = new ArrayAdapter<HistoryEntry>(HistoryActivity.this,android.R.layout.simple_list_item_1, all);
        //listView.setAdapter(historyArrayAdapter);
        viewData();

    }

    private void viewData(){
        List<HistoryEntry> theList = mHelper.historyEntryList();
        String h = theList.toString();
       historyArrayAdapter = new ArrayAdapter<HistoryEntry>(HistoryActivity.this, android.R.layout.simple_list_item_1, theList);
        listView.setAdapter(historyArrayAdapter);

    }
}*/