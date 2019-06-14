package com.example.calendarandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.calendarandroid.Utils.Utility;

public class MainActivity extends LifecycleLoggingActivity {

    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    private boolean isFirstLaunch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if(checkIfFirstLaunch()){
            startFirstLaunchActivity();
        }

        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonBasic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BasicActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.buttonAddEventToCalendar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEventActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.buttonCalendar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });




//        findViewById(R.id.buttonAsynchronous).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, AsynchronousActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    private boolean checkIfFirstLaunch(){
        return Utility.getSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, isFirstLaunch);
    }

    private void startFirstLaunchActivity(){
        Intent firstLaunchIntent = new Intent(this, FirstLaunchActivity.class);
        startActivity(firstLaunchIntent);
    }
}