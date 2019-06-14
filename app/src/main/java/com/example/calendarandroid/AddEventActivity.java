package com.example.calendarandroid;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.calendarvariations.WeekViewEvent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AddEventActivity extends LifecycleLoggingActivity {

    private TextView pickStartingDateAndTimeText;
    private TextView pickEndingDateAndTimeText;
    Calendar startingDateAndTime = Calendar.getInstance();
    Calendar endingDateAndTime = Calendar.getInstance();
    int currentHour;
    int currentMinute;
    TimePickerDialog timePickerDialog;
    EditText eventName;
    EditText description;
    EditText localization;
    EditText guests;
    FloatingActionButton addEventFab;
    String eventNameStr;
    String localizationStr;
    String descriptionStr;
    String guestsStr;
    String DateAndTimeOfStart;
    String DateAndTimeOfEnd;
    final String fileName = "eventsdata.json";
    String formattedDateAndTimeOfStart;
    String formattedDateAndTimeOfEnd;
    public static final String IS_FILE_EXISTING = "is_file_created";
    ArrayList<String> previousContents = new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        eventName = findViewById(R.id.event_name);
        localization = findViewById(R.id.description);
        description = findViewById(R.id.localization);
        guests = findViewById(R.id.guests);
        pickStartingDateAndTimeText = findViewById(R.id.pick_starting_date_and_time_text);
        pickEndingDateAndTimeText = findViewById(R.id.pick_ending_date_and_time_text);
        addEventFab = findViewById(R.id.add_event_fab);
//        dataFromFile = findViewById(R.id.data_from_file);

        findViewById(R.id.btn_lasts_from).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartingDateAndTimePickerDialog();
            }
        });

        findViewById(R.id.btn_lasts_to).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEndingDateAndTimePickerDialog();
            }
        });

        addEventFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                saveDataToInternalStorage();
                clearContents();
                Intent intent = new Intent(AddEventActivity.this, CalendarActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void showStartingDateAndTimePickerDialog() {

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                AddEventActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                final String date = dayOfMonth + "/" + month + "/" + year;
                showStartingTimePickerDialog(date);
            }
        }, startingDateAndTime.get(Calendar.YEAR), startingDateAndTime.get(Calendar.MONTH), startingDateAndTime.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();

    }

    private void showStartingTimePickerDialog(final String date) {

        timePickerDialog = new TimePickerDialog(AddEventActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                String dateAndTime = date + " " + hourOfDay + ":" + minutes;
                formattedDateAndTimeOfStart = date + "/" + hourOfDay + "/" + minutes;
                pickStartingDateAndTimeText.setText(dateAndTime);
            }
        }, currentHour, currentMinute, true);

        timePickerDialog.show();

    }

    private void showEndingDateAndTimePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                AddEventActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                final String date = dayOfMonth + "/" + month + "/" + year;
                showEndingDateAndTimePickerDialog(date);
            }
        }, endingDateAndTime.get(Calendar.YEAR), endingDateAndTime.get(Calendar.MONTH), endingDateAndTime.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private void showEndingDateAndTimePickerDialog(final String date) {
        timePickerDialog = new TimePickerDialog(AddEventActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                String dateAndTime = date + " " + hourOfDay + ":" + minutes;
                formattedDateAndTimeOfEnd = date + "/" + hourOfDay + "/" + minutes;
                pickEndingDateAndTimeText.setText(dateAndTime);
            }
        }, currentHour, currentMinute, true);

        timePickerDialog.show();
    }

    private void getData() {
        if(formattedDateAndTimeOfStart.equals("") || formattedDateAndTimeOfEnd.equals("") )
        {
            Toast.makeText(this, "There are empty date fields!", Toast.LENGTH_LONG).show();
            finish();
        }
        eventNameStr = eventName.getText().toString();
        localizationStr = localization.getText().toString();
        descriptionStr = description.getText().toString();
        guestsStr = guests.getText().toString();
        DateAndTimeOfStart = formattedDateAndTimeOfStart;
        DateAndTimeOfEnd = formattedDateAndTimeOfEnd;
    }


    private void saveDataToInternalStorage() {
        List<WeekViewEvent> events = new ArrayList<>();

        String jsonString = readEventsFromInputStorage();
        final Type REVIEW_TYPE = new TypeToken<List<WeekViewEvent>>() {
        }.getType();
        Gson gson = new Gson();
        if(jsonString!= null && !jsonString.equals(""))
        {
            events = gson.fromJson(jsonString, REVIEW_TYPE);
        }

        Calendar startOfEvent = getCalendar(DateAndTimeOfStart);
        Calendar endOfEvent = getCalendar(DateAndTimeOfEnd);
        long id = (new Date()).getTime();
        WeekViewEvent newEvent = new WeekViewEvent(id ,eventNameStr,localizationStr,startOfEvent, endOfEvent);
        newEvent.setColor(getEventColor());
        events.add(newEvent);
        gson = new Gson();
        String json = gson.toJson(events);
        try {
//            File cos = getFilesDir();
            FileOutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
            osw.write(json);
            osw.flush();
            osw.close();
        } catch (Exception e) {
            Toast.makeText(this, "Error while saving event", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

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

    private Calendar getCalendar(String date){
        String[] dateArray = date.split("/");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(dateArray[3]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(dateArray[4]));
        calendar.set(Calendar.MONTH, Integer.parseInt(dateArray[1])-1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateArray[0]));
        calendar.set(Calendar.YEAR, Integer.parseInt(dateArray[2]));
        return calendar;
    }

    private void clearContents(){
        eventName.setText("");
        localization.setText("");
        description.setText("");
        guests.setText("");
        pickStartingDateAndTimeText.setText("");
        pickEndingDateAndTimeText.setText("");
    }

    public int getEventColor(){
        int[] androidColors = getResources().getIntArray(R.array.androidcolors);
        return androidColors[new Random().nextInt(androidColors.length)];
    }


//    private void createFileIfNeeded(){
//
//        if(Utility.getSharedSetting(AddEventActivity.this, IS_FILE_EXISTING, false)) {
//
////            ContextWrapper cw = new ContextWrapper(context);
////            File directory = cw.getDir("media", Context.MODE_PRIVATE);
//
//            File file = new File(AddEventActivity.this.getFilesDir(), fileName);
//
////            try {
////                File file = new File(fileName);
////                if (file.createNewFile()) {
////                    Utility.setSharedSetting(AddEventActivity.this, IS_FILE_EXISTING, true);
////                }
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//        }
//
//    }
//
//    private void getPreviousFileContents(){
//        try{
//            FileInputStream fileInputStream = openFileInput(fileName);
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
////            StringBuffer stringBuffer = new StringBuffer();
//
//            String lines;
//            while ((lines = bufferedReader.readLine()) != null) {
//
//                previousContents.add(lines);
//
////                stringBuffer.append(lines + "\n");
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void readDataFromInternalStorage(){
//        try {
//            FileInputStream fileInputStream = openFileInput(fileName);
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            StringBuffer stringBuffer = new StringBuffer();
//
//            String lines;
//            while ((lines = bufferedReader.readLine()) != null) {
//                stringBuffer.append(lines + "\n");
//            }
//
//            dataFromFile.setText(stringBuffer.toString());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}

//do zesplitowania po enterze chyba
//String[] lines = input.split( "\n" );
//        String newFileData = fileData + previousFileData;
//        try {
//            Writer out = new BufferedWriter(new FileWriter(fileName, true), 1024);
//            out.write(fileData);
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        ContextWrapper cw = new ContextWrapper(AddEventActivity.this);
//        File directory = cw.getDir("Events Data.txt", Context.MODE_APPEND);
//
//        if(!directory.exists()){
//            File file = new File(AddEventActivity.this.getFilesDir(), fileName);
//        }
//
//        BufferedWriter bw = null;
//
//        try {
//            // APPEND MODE SET HERE
//            bw = new BufferedWriter(new FileWriter(fileName, true));
//            bw.write(fileData);
//            bw.newLine();
//            bw.flush();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        } finally {                       // always close the file
//            if (bw != null) try {
//                bw.close();
//            } catch (IOException ioe2) {
//                // just ignore it
//            }
//        } // end try/catch/finally