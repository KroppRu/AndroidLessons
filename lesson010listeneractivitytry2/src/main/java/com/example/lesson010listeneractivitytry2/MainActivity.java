package com.example.lesson010listeneractivitytry2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    Button btnUp;
    Button btnDown;
    Counter counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int x = 0;
        counter = new Counter(x);
        textview = (TextView) findViewById(R.id.kroppView);
        textview.setText(Integer.toString(counter.getValue()));


        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.kroppBtnUp:
                        counter.increase();
                        break;
                    case R.id.kroppBtnDown:
                        counter.decrease();
                        break;
                }
                textview.setText(Integer.toString(counter.getValue()));
            }
        };

        btnUp = (Button) findViewById(R.id.kroppBtnUp);
        btnUp.setText("Inc");
        btnUp.setOnClickListener(ocl);
        btnDown = (Button) findViewById(R.id.kroppBtnDown);
        btnDown.setText("Dec");
        btnDown.setOnClickListener(ocl);





    }



}