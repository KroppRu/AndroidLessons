package ru.startandroid.lesson008viewbyid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView myTextView = (TextView) findViewById(R.id.myTextView);
        myTextView.setText("Hi, Roma!");

         Button myButton = (Button) findViewById(R.id.myButton);
         myButton.setText("push");
     }
}