package com.example.massiveraptor;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final int num = 0;
    private int number;
    ImageView imageView;
    TextView textView;
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        number++;
        editor.putInt("textView", number );
        editor.commit();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        number = sharedPreferences.getInt("textView", 0);
    }

    public void updateViews(){
       /* String uri = "@drawable/step" + String.valueOf(number % 8);  // where myresource (without the extension) is the file

        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        imageView.setImageDrawable(res);*/
        //textView.setText(String.valueOf(number % 7) + " / 7");
        //imageView.setImageResource(R.drawable.step2);
        //imageView.setImageDrawable(res)
        imageView.setImageResource(R.drawable.step2);
    }
    //mDatabaseHelper mDatabaseHelper = new mDatabaseHelper(MainActivity.this);
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(String.valueOf(number % 8) + " / 7");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        if (number % 8 == 0) {
            imageView.setImageResource(R.drawable.step0);
        }
        else if (number % 8 == 1) {
            imageView.setImageResource(R.drawable.step1);
        }
        else if (number % 8 == 2) {
            imageView.setImageResource(R.drawable.step2);
        }
        else if (number % 8 == 3) {
            imageView.setImageResource(R.drawable.step3);
        }
        else if (number % 8 == 4) {
            imageView.setImageResource(R.drawable.step4);
        }
        else if (number % 8 == 5) {
            imageView.setImageResource(R.drawable.step5);
        }
        else if (number % 8 == 6) {
            imageView.setImageResource(R.drawable.step6);
        }
        else if (number % 8 == 7) {
            imageView.setImageResource(R.drawable.step7);
        }
        bar = findViewById(R.id.progressBar);
        bar.setProgress(number % 8);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String todayString = year + " " + month + " " + day;
        SharedPreferences preferences = getSharedPreferences("PREFS",0);
        boolean currentDay = preferences.getBoolean(todayString, false);

        if(!currentDay){
            //set to 0
        }

        else{
           //do nothing
        }
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, ToDoActivity.class);
        startActivity(intent);
    }


}