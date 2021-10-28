package ru.startandroid.lesson027getintentaction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        tv = (TextView) findViewById(R.id.tv);

        String tvstring = "I don't know what do you want to see";
        SimpleDateFormat sdf;
        switch(getIntent().getAction()){
            case "ru.startandroid.intent.action.time":
               sdf = new SimpleDateFormat("HH:mm:ss");
                tvstring = "Time: " + sdf.format(new Date(System.currentTimeMillis()));
                break;
            case "ru.startandroid.intent.action.date":
                sdf = new SimpleDateFormat("dd.MMMM.yyyy");
                tvstring = "Date: " + sdf.format(new Date(System.currentTimeMillis()));
                break;
        }
        tv.setText(tvstring);
    }
}