package ru.startandroid.lesson025twoactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    final private String TAG = "ActivityState";
    Button btnAway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnAway = (Button) findViewById(R.id.btnAway);
        btnAway.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Second start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"Second resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"Second pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Second stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Second destroy");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAway:
                finish();
                break;

        }
    }
}