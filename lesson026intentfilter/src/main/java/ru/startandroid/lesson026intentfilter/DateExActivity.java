package ru.startandroid.lesson026intentfilter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExActivity extends AppCompatActivity{

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy");
        String time = sdf.format(new Date(System.currentTimeMillis()));

        tv = (TextView) findViewById(R.id.tv);
        tv.setText(time);
    }
}
