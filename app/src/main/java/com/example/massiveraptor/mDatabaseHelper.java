package com.example.massiveraptor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class mDatabaseHelper extends SQLiteOpenHelper {
    private final static String TAG = "mDatabaseHelper";
    private final static String TABLE_NAME = "treeTracker";
    private final static String COL1 = "day";
    private final static String COL2 = "points";

    public mDatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
               COL1 + " STRING, " + COL2 + " INT);";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TaskContract.TaskEntry.TABLE);
        onCreate(db);
    }

    public boolean increaseOne(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv;
        return false;
    }

    public List<HistoryEntry> historyEntryList(){
        List<HistoryEntry> theList = new ArrayList<>();
        String queryString = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            do{
                String date = cursor.getString(1);
                int score = cursor.getInt(2);
                HistoryEntry newEntry = new HistoryEntry(date, score);
                theList.add(newEntry);
            }while (cursor.moveToNext());
        }
        else{
            // nothing happens
        }
    cursor.close();
        db.close();
        return theList;
    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
    public boolean addData(HistoryEntry historyEntry) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, historyEntry.getDate());
        contentValues.put(COL2, 0);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

}