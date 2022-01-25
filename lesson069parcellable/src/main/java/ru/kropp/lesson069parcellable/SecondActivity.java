package ru.kropp.lesson069parcellable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(LOG_TAG, "getParcelableExtra");
        MyParcelableObject myObj = (MyParcelableObject) getIntent().getParcelableExtra("myObj");
        Log.d(LOG_TAG, "myObj: " + myObj.getS() + ", " + myObj.getI());
    }
}