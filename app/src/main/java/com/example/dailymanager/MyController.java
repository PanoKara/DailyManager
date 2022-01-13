package com.example.dailymanager;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class MyController {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ArrayList<Event> events = new ArrayList<>();
    private MyAdapter adapter;

    public MyController(Activity activity) {
        // Dummy
        // Event(int year, int month, int day, int hour, int min,String eventName, String location, String note, int remindOption)
        events.add(new Event(2022,0,13,14,45,"P2","MS-TEAMS","...",2));

        //TODO set layout manager to reycler
        layoutManager = new LinearLayoutManager(activity);

        //TODO the recyclerView has to be declared in
        //TODO activity main.xml for this example
        recyclerView = (RecyclerView) activity.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        //TODO give the adapter the reference of the data
        adapter = new MyAdapter(events);

        // Set CustomAdapter as the adapter for RecyclerView.
        //TODO Connect recyclerView and adapter
        recyclerView.setAdapter(adapter);
    }

    public void setEventList (ArrayList <Event> events) {
        // this.events.clear();
        this.events.addAll(events);

        adapter.notifyDataSetChanged();
    }
}