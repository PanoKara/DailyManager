package com.example.dailymanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

public class AddEntyActivity extends AppCompatActivity {

    int getYear;
    int getMonth;
    int getDay;
    int remindOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_enty);

        final EditText editTime = findViewById(R.id.editTime);
        final EditText editName = findViewById(R.id.editName);
        final EditText editLocate = findViewById(R.id.editLocate);
        final EditText editNote = findViewById(R.id.editNote);
        final Spinner spinner = findViewById(R.id.spinner);
        Button buttonSave = findViewById(R.id.buttonSave);
        CalendarView calendarViewEvent = findViewById(R.id.calendarViewEvent);


        // Spinner mit werten befüllen
        String[] arraySpinner = new String[] {
                "keine", "15 min vorher", "30 min vorher", "1 Stunde vorher", "morgens um 08:00", "1 Tag vorher"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Calender SetOnDateChangeListener
        calendarViewEvent.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                getYear = year;
                getMonth = month;
                getDay = dayOfMonth;
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                remindOption=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Save Button onClick
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String getTime = editTime.getText().toString();

                String [] splitTime = getTime.split(":");
                int hour = Integer.parseInt(splitTime[0]);
                int min = Integer.parseInt(splitTime[1]);

                String eventName = editName.getText().toString();
                String location = editLocate.getText().toString();
                String note = editNote.getText().toString();

                Event event = new Event( getYear, getMonth, getDay, hour, min, eventName, location, note, remindOption);


                WriteService.writeObject(AddEntyActivity.this, event);
                Log.i("checkEvent",event.toString());

                Intent intent = new Intent(AddEntyActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
