package com.example.dailymanager.view;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dailymanager.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    //TODO please declare your views from R.layout.item here
    private final TextView textEventView;
    private final TextView textDateView;
    private final TextView textTimeView;
    private final TextView textLocateView;
    private final TextView textNoteView;

    public MyViewHolder(View itemView) {
        super(itemView);

        //TODO please initialize your views from R.layout.item here
        textEventView = (TextView) itemView.findViewById(R.id.textEventView);
        textDateView = (TextView) itemView.findViewById(R.id.textDateView);
        textTimeView = (TextView) itemView.findViewById(R.id.textTimeView);
        textLocateView = (TextView) itemView.findViewById(R.id.textLocateView);
        textNoteView = (TextView) itemView.findViewById(R.id.textNoteView);

        //TODO set listener for views
    }

    //TODO please insert here getter from your views above


    public TextView getTextEventView() {
        return textEventView;
    }

    public TextView getTextDateView() {
        return textDateView;
    }

    public TextView getTextTimeView() {
        return textTimeView;
    }

    public TextView getTextLocateView() {
        return textLocateView;
    }

    public TextView getTextNoteView() {
        return textNoteView;
    }

}