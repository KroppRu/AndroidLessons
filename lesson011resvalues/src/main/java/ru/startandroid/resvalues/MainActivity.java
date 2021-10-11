package ru.startandroid.resvalues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button3 = (Button) findViewById(R.id.button3);
        button3.setBackgroundColor(getResources().getColor(R.color.green));


        button4 = (Button) findViewById(R.id.button4);
        button4.setBackgroundColor(getResources().getColor(R.color.red));
    }
}