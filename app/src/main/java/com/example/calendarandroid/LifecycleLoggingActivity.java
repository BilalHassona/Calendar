package com.example.calendarandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public abstract class LifecycleLoggingActivity extends AppCompatActivity {

    protected final String TAG = getClass().getSimpleName();

    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            Log.e(TAG, "onCreate(): activity re-created"); }
            else {
            Log.e(TAG, "onCreate(): activity created anew");
            }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart() - the activity is about to become visible");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,
                "onResume() - the activity has become visible (it is now \"resumed\")");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,
                "onPause() - another activity is taking focus (this activity is about to be \"paused\")");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop() - the activity is no longer visible (it is now \"stopped\")");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart() - the activity is about to be restarted()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy() - the activity is about to be destroyed");
    }
}
