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

public class AddEntryActivity extends AppCompatActivity {

    int getYear;
    int getMonth;
    int getDay;
    int remindOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_enty);

        //refereces of all view of AddEntry
        final EditText editTime = findViewById(R.id.editTime);
        final EditText editName = findViewById(R.id.editName);
        final EditText editLocate = findViewById(R.id.editLocate);
        final EditText editNote = findViewById(R.id.editNote);
        CalendarView calendarViewEvent = findViewById(R.id.calendarViewEvent);


        /*  DailyManagerApp.pdf - 4.
            Wenn ihr einen Spinner für die Erinnerung habt, dann soll die SpinnerView Einträge wie „15 Minuten vorher“ etc. beinhalten.
            Dafür müsst ihr in der onCreate-Methode der AddEntryActivity diese Einträge hinzufügen
        */
        final Spinner spinner = findViewById(R.id.spinner);
        String[] arraySpinner = new String[] {
                "keine", "15 min vorher", "30 min vorher", "1 Stunde vorher", "morgens um 08:00", "1 Tag vorher"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


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

        /* DailyManagerApp.pdf - 5.
           Setzt bei dem Save-Button in der AddEntryActivity einen OnClickListener. Wenn der Benutzer auf den Button klickt,
           sollen die Daten aus allen Views ausgelesen werden. Speichert die Daten in einem Event-Objekt.
           Gebt anschließend die Daten des Event-Objekts mit Log.i() aus.
         */

        Button buttonSave = findViewById(R.id.buttonSave);
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

                Event myEvent = new Event(getYear, getMonth, getDay, hour, min, eventName, location, note, remindOption);

                /*  DailyManagerApp.pdf - 8.
                    Wenn der Benutzer in der AddEntryActivity auf den Save-Button klickt, soll nun das EventObjekt mit Hilfe der WriteService-Klasse in eine Datei geschrieben werden.
                    Dabei wird mit AddEntryActivity.this der Kontext der Activity übergeben und myEvent ist euer Event-Objekt.
                 */
                WriteService.writeObject(AddEntryActivity.this, myEvent);
                Log.i("Ausgabe",myEvent.toString());

                /*  DailyManagerApp.pdf -
                    Nach dem Wegschreiben des Objektes in eine Datei, soll die App wieder in die MainActivity wechseln.
                 */
                Intent intent = new Intent(AddEntryActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}