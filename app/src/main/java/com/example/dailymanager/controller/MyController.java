package com.example.dailymanager.controller;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailymanager.model.Event;
import com.example.dailymanager.R;
import com.example.dailymanager.view.AddEntryActivity;
import com.example.dailymanager.view.MainActivity;
import com.example.dailymanager.view.MyAdapter;

import java.util.ArrayList;
import java.util.Locale;

public class MyController {

    private RecyclerView recyclerView;
    private ArrayList<Event> eventOfDay = new ArrayList<>();
    private ArrayList<Event> events = new ArrayList<>();
    private MyAdapter adapter;
    private Activity activity;
    private static final String TAG = "MyController";

    public MyController(Activity activity) {
        this.activity = activity;
        readData(activity);
        initRecyclerView(activity);
    }

    private void initRecyclerView(Activity activity) {
        //TODO set layout manager to reycler
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);

        //TODO the recyclerView has to be declared in
        //TODO activity main.xml for this example
        recyclerView = (RecyclerView) activity.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        //TODO give the adapter the reference of the data
        adapter = new MyAdapter(this, eventOfDay);

        // Set CustomAdapter as the adapter for RecyclerView.
        //TODO Connect recyclerView and adapter
        recyclerView.setAdapter(adapter);
    }

    private void readData(Activity activity) {
        Object object = ReadService.readObject(activity);
        if(object instanceof ArrayList){
            events = (ArrayList<Event>) object;
        }else{
            events = new ArrayList<>();
        }
    }

    public void setSelectedDate (int year, int month, int dayOfMonth) {
        eventOfDay.clear();
        for (Event event : events) {
            if(event.getStartTime().equals(String.format(Locale.GERMANY,"%d.%d.%d.",dayOfMonth,month + 1,year))){
                Log.i(TAG, event.toString());
                eventOfDay.add(event);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void addNewEvent() {
        WriteService.writeObject(activity, events);
        Toast.makeText(activity, "Want to add a new entry", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(activity, AddEntryActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public void setEventList(ArrayList<Event> events) {
        this.events.clear();
        this.events.addAll(events);

        adapter.notifyDataSetChanged();
    }
}