package com.example.dailymanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        CalendarView calendarView = findViewById(R.id.calendarViewMain);

        final String [] date = new String [1];

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date[0] = Integer.toString(year) + "." + Integer.toString(month) + "." + Integer.toString(dayOfMonth);
                Log.i("dateTag", date[0]);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Want to add a new entry", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, AddEntyActivity.class);
                startActivity(intent);
            }


        });
        Object obj = ReadService.readObject(MainActivity.this);

        if (obj==null){
            Log.i("Ausgabe","Objekt nicht gefunden");
        }else if( obj instanceof Event ){
            calendarView.setDate( ( (Event)obj ).getStartTime().getTimeInMillis() );
        }



    }
}
