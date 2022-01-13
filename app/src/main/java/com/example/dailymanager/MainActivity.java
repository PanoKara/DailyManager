package com.example.dailymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DailyMGMT";
    private ArrayList<Event> events;
    private MyController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MyController(this);

        Object object = ReadService.readObject(MainActivity.this);
        if(object instanceof ArrayList){
            events = (ArrayList<Event>) object;
        }else{
            events = new ArrayList<>();
        }


         /* DailyManagerApp.pdf - 3.
            Fügt eurer CalenderView in der MainActivity der onDateChangeListener hinzu
            Speichert die Änderungen zunächst in einer lokalen Variable.
          */
        CalendarView calendarView = findViewById(R.id.calendarViewMain);
        calendarView.setOnDateChangeListener((CalendarView view, int year, int month, int dayOfMonth) -> {

            ArrayList<Event> eventOfDay = new ArrayList<>();
            for (Event event : events) {
                if(event.getStartTime().equals(String.format(Locale.GERMANY,"%d.%d.%d.",dayOfMonth,month ,year))){
                    Log.i(TAG, event.toString());
                    eventOfDay.add(event);
                }
            }
            controller.setEventList(eventOfDay);
        });

        //FloatingActionButton-Snipped from DailyManagerApp.pdf
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Want to add a new entry", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, AddEntryActivity.class);
            startActivity(intent);
            finish();
        });

        /*  DailyManagerApp.pdf - 10. - 11
            Lest nun in der onCreate-Methode mit Hilfe von der ReadService-Klasse das geschriebene Objekt wieder ein.
            Überprüft, ob das gelesene Objekt null ist. Falls nicht, überprüft, ob dieses eine Instanz vor Klasse Event ist und casted es gegebenenfalls.
         */
        Object obj = ReadService.readObject(MainActivity.this);
        if (obj==null){
            Log.i("Ausgabe","Objekt nicht gefunden");
        }else if( obj instanceof Event ){
            calendarView.setDate( ( (Event)obj ).getStartTime().getTimeInMillis() );
            Log.i("Ausgabe","Calender wurde gesetzt");
        }
    }
}
