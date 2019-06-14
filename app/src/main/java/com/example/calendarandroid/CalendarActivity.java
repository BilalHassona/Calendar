package com.example.calendarandroid;

import android.content.Intent;

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

public class CalendarActivity extends BaseActivity {

    String fileName = "eventsdata.json";

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        List<WeekViewEvent> data = new ArrayList<>();
        String jsonString = readEventsFromInputStorage();
        final Type REVIEW_TYPE = new TypeToken<List<WeekViewEvent>>() {
        }.getType();
        Gson gson = new Gson();
        if(jsonString!= null && !jsonString.equals(""))
        {
            data = gson.fromJson(jsonString, REVIEW_TYPE);
        }

        List<WeekViewEvent> events = new ArrayList<>();
        for (WeekViewEvent event : data){
            if(event.getStartTime().get(Calendar.YEAR) == newYear &&
                    event.getStartTime().get(Calendar.MONTH)+1 == newMonth){
                events.add(event);
            }
        }
        return events;
    }

    public String readEventsFromInputStorage(){
        String lines = null;
        try{
            FileInputStream fileInputStream = openFileInput(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            lines = bufferedReader.lines().collect(Collectors.joining());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
//            StringBuffer stringBuffer = new StringBuffer();

//            String lines = bufferedReader;
//            while ((lines = bufferedReader.readLine()) != null) {
//
//                fileLines.add(lines);
//
////                stringBuffer.append(lines + "\n");
//
//            }
//            bufferedReader.close();
//            this.deleteFile(fileName);

//    public void readEventsFromInputStorage() {
//        try {
//            File file = new File(fileName);
//            Scanner myReader = new Scanner(file);
//            while (myReader.hasNextLine()) {
//                fileLines.add(myReader.nextLine());
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//        for (int i = 0; i <= fileLines.size()-1; i++) {
//            if (fileLines.get(i).equals("")) {
//                continue;
//            }
//            switch (i % 6) {
//                case 0: {
//                    utility.setName(fileLines.get(i));
//                }
//                break;
//                case 1: {
//                    utility.setDescription(fileLines.get(i));
//                }
//                break;
//                case 2: {
//                    utility.setLocation(fileLines.get(i));
//                }
//                break;
//                case 3: {
//                    utility.setGuests(fileLines.get(i));
//                }
//                break;
//                case 4: {
//                    String[] date = fileLines.get(i).split("/");
//                    startOfEvent.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date[0]));
//                    startOfEvent.set(Calendar.MONTH, Integer.parseInt(date[1]) -1);
//                    startOfEvent.set(Calendar.YEAR, Integer.parseInt(date[2]));
//                    startOfEvent.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date[3]));
//                    startOfEvent.set(Calendar.MINUTE, Integer.parseInt(date[4]));
//                }
//                break;
//                case 5: {
//                    String[] date = fileLines.get(i).split("/");
//                    endOfEvent.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date[0]));
//                    endOfEvent.set(Calendar.MONTH, Integer.parseInt(date[1])-1);
//                    endOfEvent.set(Calendar.YEAR, Integer.parseInt(date[2]));
//                    endOfEvent.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date[3]));
//                    endOfEvent.set(Calendar.MINUTE, Integer.parseInt(date[4]));
////                    event = new WeekViewEvent(i, getEventTitle(startOfEvent), utility.getDescription(), utility.getLocation(), utility.getGuests(), startOfEvent, endOfEvent);
//                    event = new WeekViewEvent(i, getEventTitle(startOfEvent), utility.getLocation(), startOfEvent, endOfEvent);
//                    events.add(event);
//                }
//                break;
//            }
//        }

//        count++;

//        return events;