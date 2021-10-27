package ru.startandroid.lesson026intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTime;
    Button btnDate;

    final String ACTION_FILTER_TIME = "ru.startandroid.intent.action.showtime";
    final String ACTION_FILTER_DATE = "ru.startandroid.intent.action.showdate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTime = (Button) findViewById(R.id.btnTime);
        btnDate = (Button) findViewById(R.id.btnDate);

        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnTime:
                intent = new Intent(ACTION_FILTER_TIME);
                startActivity(intent);
                break;
            case R.id.btnDate:
                intent = new Intent(ACTION_FILTER_DATE);
                startActivity(intent);
                break;

        }
    }
}