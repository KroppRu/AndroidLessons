package ru.kropp.lesson070onsaveinstancestate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "create");
    }

    @Override
    protected void onDestroy() {
       super.onDestroy();
       Log.d(LOG_TAG, "destroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "pause");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
        Log.d(LOG_TAG, "saveState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
        Log.d(LOG_TAG, "restoreState");
    }

    public void onclick(View view) {

        Toast.makeText(this, "Count = " + ++count, Toast.LENGTH_SHORT).show();

    }
}