package com.example.dailymanager;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    //TODO please declare your views from R.layout.item here
    private final TextView textItemEvent;
    private final TextView textItemDate;
    private final TextView textItemTime;
    private final TextView textItemLocation;
    private final TextView textItemNote;

    public MyViewHolder(View itemView) {
        super(itemView);

        //TODO please initialize your views from R.layout.item here
        textItemEvent = (TextView) itemView.findViewById(R.id.eventTextItem);
        textItemDate = (TextView) itemView.findViewById(R.id.dateTextItem);
        textItemTime = (TextView) itemView.findViewById(R.id.timeTextItem);
        textItemLocation = (TextView) itemView.findViewById(R.id.locationTextItem);
        textItemNote = (TextView) itemView.findViewById(R.id.noteTextItem);

        //TODO set listener for views
    }

    //TODO please insert here getter from your views above
    public TextView getTextItemEvent() { return textItemEvent; }

    public TextView getTextItemDate() { return textItemDate; }

    public TextView getTimeTextItem() { return textItemTime; }

    public TextView getTextItemLocation() { return textItemLocation; }

    public TextView getNoteTextItem() { return textItemNote; }
}