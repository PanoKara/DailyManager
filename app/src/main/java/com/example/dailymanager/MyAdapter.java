package com.example.dailymanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    //reference to the data
    //TODO put other Objects to the list and rename it
    private ArrayList<Event> events;

    //TODO put other Objects to the list and rename it
    public MyAdapter(ArrayList<Event>events) {
        this.events = events;
    }

    //here the adapter creates a graphical element which looks like
    //described in R.layout.item
    //this element calls view holder, it holds a view / an item of the list
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //TODO please enter your xml-file name where R.layout.item is
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //here are the views from R.layout.item connected to the data
        //TODO please call the view methods of MyViewHolder
        //TODO fill the views with data from your arraylist
        holder.getTextItemEvent().setText(events.get(position).getEventName());
        holder.getTextItemDate().setText(events.get(position).getDate());
        holder.getTimeTextItem().setText(events.get(position).getTime());
        holder.getTextItemLocation().setText(events.get(position).getLocation());
        holder.getNoteTextItem().setText(events.get(position).getNote());
    }

    @Override
    public int getItemCount() {
        //TODO return the size of your arraylist
        return events.size();
    }
}
