package ru.startandroid.lesson023activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    final private String TAG = "ActivityState";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"activity on create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"activity on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"activity on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"activity on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"activity on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"activity on destroy");
    }
}