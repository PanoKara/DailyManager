 package com.example.dailymanager;

/*
    DailyManagerApp.pdf - 2.
    Erstellt eine Klasse Event, mit allen Daten als Variablen, die der Nutzer
    in in der AddEntryActivity eingeben soll. Überschreibt auch die toString-Methode.
 */
import java.io.Serializable;
import java.util.Calendar;

public class Event implements Serializable{

    // options to set on reminderOption
    public static final int NO_REMIND = 0;
    public static final int REMIND_5_MIN_BEFORE = 1;
    public static final int REMIND_15_MIN_BEFORE = 2;
    public static final int REMIND_1_HOUR_BEFORE = 3;
    public static final int REMIND_1_DAY_BEFORE = 4;

    // init variables for AddEntryActivity
    private Calendar startTime;
    private String eventName;
    private String location;
    private String note;
    private int remindOption;

    //Constructs
    public Event(Calendar startTime, String eventName) {
        this.startTime = startTime;
        this.eventName = eventName;
    }

    public Event(int year, int month, int day, int hour, int min, String eventName) {
        startTime = Calendar.getInstance();
        startTime.set(year, month, day, hour, min);
        this.eventName = eventName;
    }

    public Event(int year, int month, int day, int hour, int min,String eventName, String location, String note, int remindOption) {
        startTime = Calendar.getInstance();
        startTime.set(year, month, day, hour, min);
        this.eventName = eventName;
        this.location = location;
        this.note = note;
        this.remindOption = remindOption;
    }

    //getter - setter
    public String getTime(){
        return String.format("%d:%d", startTime.get(Calendar.HOUR),startTime.get(Calendar.MINUTE));
    }
    public void setTime(int hour, int min){
        startTime.set(Calendar.HOUR, hour);
        startTime.set(Calendar.MINUTE, min);
    }
    public String getDate () {
        return String.format("%d:%d:%d", startTime.get(Calendar.DAY_OF_MONTH),startTime.get(Calendar.MONTH) + 1, startTime.get(Calendar.YEAR));
    }
    public void setDate (int year, int month, int day){
        startTime.set(Calendar.YEAR, year);
        startTime.set(Calendar.MONTH, month);
        startTime.set(Calendar.DAY_OF_MONTH, day);
    }

    public void setStartTime(int year, int month, int day, int hour, int min) {
        startTime = Calendar.getInstance();
        startTime.set(year, month, day, hour, min);
    }

    public int getYear() {
        return startTime.get(Calendar.YEAR);
    }

    public int getMonth() {
        return startTime.get(Calendar.MONTH);
    }

    public int getDay() {
        return startTime.get(Calendar.DAY_OF_MONTH);
    }

    public int getHour() {
        return startTime.get(Calendar.HOUR);
    }

    public int getMin() {
        return startTime.get(Calendar.MINUTE);
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getRemindOption() {
        return remindOption;
    }

    public void setRemindOption(int remindOption) {
        this.remindOption = remindOption;
    }

    @Override
    public String toString() {
        return ("Event{" +
                "startTime=" + startTime +
                "\neventName='" + eventName + '\'' +
                "\nlocation='" + location + '\'' +
                "\nnote='" + note + '\'' +
                "\nremindOption=" + remindOption +
                '}');
    }
}
