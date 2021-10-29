package ru.startandroid.lesson028intentextras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HelloBackActivity extends AppCompatActivity {

    TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_back);

        tvHello = (TextView) findViewById(R.id.tvHello);
        Intent intent = getIntent();
        String firstName = intent.getExtras().get("firstName").toString();
        String lasttName = intent.getExtras().get("lastName").toString();
        String hello = "Hello, " + firstName + " " + lasttName;
        tvHello.setText(hello);
    }
}