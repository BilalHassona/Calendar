package com.example.calendarandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.example.calendarvariations.WeekViewEvent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

//A basic example of how to use week view library.

public class BasicActivity extends BaseActivity {
//    String fileName = "eventsdata.json";
//    @Override
//    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
//        List<WeekViewEvent> data = new ArrayList<>();
//        String jsonString= readEventsFromInputStorage();
//        final Type REVIEW_TYPE = new TypeToken<List<WeekViewEvent>>() {
//        }.getType();
//        Gson gson = new Gson();
//        if(jsonString!= null && !jsonString.equals(""))
//        {
//            data = gson.fromJson(jsonString, REVIEW_TYPE);
//        }
//
//        List<WeekViewEvent> events = new ArrayList<>();
//        for (WeekViewEvent event : data){
//            if(event.getStartTime().get(Calendar.YEAR) == newYear &&
//                    event.getStartTime().get(Calendar.MONTH) == newMonth){
//                event.setColor(ContextCompat.getColor(this, R.color.event_color_03));
//                events.add(event);
//            }
//        }
//        return events;
//    }
//
//    public String readEventsFromInputStorage(){
//        String lines = null;
//        try{
//            FileInputStream fileInputStream = openFileInput(fileName);
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//            lines = bufferedReader.lines().collect(Collectors.joining());
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return lines;
//    }

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        // Populate the week view with some events.
        List<WeekViewEvent> events = new ArrayList<>();

        Calendar startOfEvent = Calendar.getInstance();
        startOfEvent.set(Calendar.HOUR_OF_DAY, 3);
        startOfEvent.set(Calendar.MINUTE, 0);
        startOfEvent.set(Calendar.MONTH, newMonth - 1);
        startOfEvent.set(Calendar.YEAR, newYear);
        Calendar endOfEvent = (Calendar) startOfEvent.clone();
        endOfEvent.add(Calendar.HOUR, 1);
        endOfEvent.set(Calendar.MONTH, newMonth - 1);
        WeekViewEvent event = new WeekViewEvent(1, getEventTitle(startOfEvent), startOfEvent, endOfEvent);
//        event.setColor(getResources().getColor(R.color.event_color_01));
        event.setColor(ContextCompat.getColor(this, R.color.event_color_01));

        events.add(event);

//        startOfEvent = Calendar.getInstance();
//        startOfEvent.set(Calendar.HOUR_OF_DAY, 3);
//        startOfEvent.set(Calendar.MINUTE, 30);
//        startOfEvent.set(Calendar.MONTH, newMonth-1);
//        startOfEvent.set(Calendar.YEAR, newYear);
//        endOfEvent = (Calendar) startOfEvent.clone();
//        endOfEvent.set(Calendar.HOUR_OF_DAY, 4);
//        endOfEvent.set(Calendar.MINUTE, 30);
//        endOfEvent.set(Calendar.MONTH, newMonth-1);
//        event = new WeekViewEvent(10, getEventTitle(startOfEvent), startOfEvent, endOfEvent);
////        event.setColor(getResources().getColor(R.color.event_color_02));
//        event.setColor(ContextCompat.getColor(this, R.color.event_color_02));
//        events.add(event);
//
//        startOfEvent = Calendar.getInstance();
//        startOfEvent.set(Calendar.HOUR_OF_DAY, 4);
//        startOfEvent.set(Calendar.MINUTE, 20);
//        startOfEvent.set(Calendar.MONTH, newMonth-1);
//        startOfEvent.set(Calendar.YEAR, newYear);
//        endOfEvent = (Calendar) startOfEvent.clone();
//        endOfEvent.set(Calendar.HOUR_OF_DAY, 5);
//        endOfEvent.set(Calendar.MINUTE, 0);
//        event = new WeekViewEvent(10, getEventTitle(startOfEvent), startOfEvent, endOfEvent);
////        event.setColor(getResources().getColor(R.color.event_color_03));
//        event.setColor(ContextCompat.getColor(this, R.color.event_color_03));
//
//        events.add(event);
//
//        startOfEvent = Calendar.getInstance();
//        startOfEvent.set(Calendar.HOUR_OF_DAY, 5);
//        startOfEvent.set(Calendar.MINUTE, 30);
//        startOfEvent.set(Calendar.MONTH, newMonth-1);
//        startOfEvent.set(Calendar.YEAR, newYear);
//        endOfEvent = (Calendar) startOfEvent.clone();
//        endOfEvent.add(Calendar.HOUR_OF_DAY, 2);
//        endOfEvent.set(Calendar.MONTH, newMonth-1);
//        event = new WeekViewEvent(2, getEventTitle(startOfEvent), startOfEvent, endOfEvent);
////        event.setColor(getResources().getColor(R.color.event_color_02));
//        event.setColor(ContextCompat.getColor(this, R.color.event_color_02));
//
//        events.add(event);
//
//
//        startOfEvent = Calendar.getInstance();
//        startOfEvent.set(Calendar.HOUR_OF_DAY, 5);
//        startOfEvent.set(Calendar.MINUTE, 0);
//        startOfEvent.set(Calendar.MONTH, newMonth - 1);
//        startOfEvent.set(Calendar.YEAR, newYear);
//        startOfEvent.add(Calendar.DATE, 1);
//        endOfEvent = (Calendar) startOfEvent.clone();
//        endOfEvent.add(Calendar.HOUR_OF_DAY, 3);
//        endOfEvent.set(Calendar.MONTH, newMonth - 1);
//        event = new WeekViewEvent(3, getEventTitle(startOfEvent), startOfEvent, endOfEvent);
////        event.setColor(getResources().getColor(R.color.event_color_03));
//        event.setColor(ContextCompat.getColor(this, R.color.event_color_03));
//
//        events.add(event);
//
//        startOfEvent = Calendar.getInstance();
//        startOfEvent.set(Calendar.DAY_OF_MONTH, 15);
//        startOfEvent.set(Calendar.HOUR_OF_DAY, 3);
//        startOfEvent.set(Calendar.MINUTE, 0);
//        startOfEvent.set(Calendar.MONTH, newMonth-1);
//        startOfEvent.set(Calendar.YEAR, newYear);
//        endOfEvent = (Calendar) startOfEvent.clone();
//        endOfEvent.add(Calendar.HOUR_OF_DAY, 3);
//        event = new WeekViewEvent(4, getEventTitle(startOfEvent), startOfEvent, endOfEvent);
////        event.setColor(getResources().getColor(R.color.event_color_04));
//        event.setColor(ContextCompat.getColor(this, R.color.event_color_04));
//
//        events.add(event);
//
//        startOfEvent = Calendar.getInstance();
//        startOfEvent.set(Calendar.DAY_OF_MONTH, 1);
//        startOfEvent.set(Calendar.HOUR_OF_DAY, 3);
//        startOfEvent.set(Calendar.MINUTE, 0);
//        startOfEvent.set(Calendar.MONTH, newMonth-1);
//        startOfEvent.set(Calendar.YEAR, newYear);
//        endOfEvent = (Calendar) startOfEvent.clone();
//        endOfEvent.add(Calendar.HOUR_OF_DAY, 3);
//        event = new WeekViewEvent(5, getEventTitle(startOfEvent), startOfEvent, endOfEvent);
////        event.setColor(getResources().getColor(R.color.event_color_01));
//        event.setColor(ContextCompat.getColor(this, R.color.event_color_01));
//
//        events.add(event);
//
//        startOfEvent = Calendar.getInstance();
//        startOfEvent.set(Calendar.DAY_OF_MONTH, startOfEvent.getActualMaximum(Calendar.DAY_OF_MONTH));
//        startOfEvent.set(Calendar.HOUR_OF_DAY, 15);
//        startOfEvent.set(Calendar.MINUTE, 0);
//        startOfEvent.set(Calendar.MONTH, newMonth-1);
//        startOfEvent.set(Calendar.YEAR, newYear);
//        endOfEvent = (Calendar) startOfEvent.clone();
//        endOfEvent.add(Calendar.HOUR_OF_DAY, 3);
//        event = new WeekViewEvent(5, getEventTitle(startOfEvent), startOfEvent, endOfEvent);
////        event.setColor(getResources().getColor(R.color.event_color_02));
//        event.setColor(ContextCompat.getColor(this, R.color.event_color_02));
//        events.add(event);
//
//        //AllDay event
//        startOfEvent = Calendar.getInstance();
//        startOfEvent.set(Calendar.HOUR_OF_DAY, 0);
//        startOfEvent.set(Calendar.MINUTE, 0);
//        startOfEvent.set(Calendar.MONTH, newMonth-1);
//        startOfEvent.set(Calendar.YEAR, newYear);
//        endOfEvent = (Calendar) startOfEvent.clone();
//        endOfEvent.add(Calendar.HOUR_OF_DAY, 23);
//        event = new WeekViewEvent(7, getEventTitle(startOfEvent), null, startOfEvent, endOfEvent, true);
////        event.setColor(getResources().getColor(R.color.event_color_04));
//        event.setColor(ContextCompat.getColor(this, R.color.event_color_04));
//        events.add(event);
//        events.add(event);
//
//        startOfEvent = Calendar.getInstance();
//        startOfEvent.set(Calendar.DAY_OF_MONTH, 8);
//        startOfEvent.set(Calendar.HOUR_OF_DAY, 2);
//        startOfEvent.set(Calendar.MINUTE, 0);
//        startOfEvent.set(Calendar.MONTH, newMonth-1);
//        startOfEvent.set(Calendar.YEAR, newYear);
//        endOfEvent = (Calendar) startOfEvent.clone();
//        endOfEvent.set(Calendar.DAY_OF_MONTH, 10);
//        endOfEvent.set(Calendar.HOUR_OF_DAY, 23);
//        event = new WeekViewEvent(8, getEventTitle(startOfEvent), null, startOfEvent, endOfEvent, true);
////        event.setColor(getResources().getColor(R.color.event_color_03));
//        event.setColor(ContextCompat.getColor(this, R.color.event_color_03));
//        events.add(event);
//
//        // All day event until 00:00 next day
//        startOfEvent = Calendar.getInstance();
//        startOfEvent.set(Calendar.DAY_OF_MONTH, 10);
//        startOfEvent.set(Calendar.HOUR_OF_DAY, 0);
//        startOfEvent.set(Calendar.MINUTE, 0);
//        startOfEvent.set(Calendar.SECOND, 0);
//        startOfEvent.set(Calendar.MILLISECOND, 0);
//        startOfEvent.set(Calendar.MONTH, newMonth-1);
//        startOfEvent.set(Calendar.YEAR, newYear);
//        endOfEvent = (Calendar) startOfEvent.clone();
//        endOfEvent.set(Calendar.DAY_OF_MONTH, 11);
//        event = new WeekViewEvent(8, getEventTitle(startOfEvent), null, startOfEvent, endOfEvent, true);
////        event.setColor(getResources().getColor(R.color.event_color_01));
//        event.setColor(ContextCompat.getColor(this, R.color.event_color_01));
//        events.add(event);

        return events;
    }

}
