package ru.startandroid.lesson010listener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView myText;
    Button btnUp;
    Button btnDn;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 0;
 //не важно какой говнокод будет написан дальше - проблемы вот уже в этих трех строчках:
        myText = (TextView) findViewById(R.id.counterText);
        btnUp = (Button)findViewById(R.id.btnUp);
        btnDn = (Button)findViewById(R.id.btnDn);
//Поставь отладку строкой выше. И ты увидишь, и myText, и btnUp, и btnDn - все они null
// Хотя в активити все эти ИД прописаны. и если ты начнешь набтрать R.id.... он сам их будет предлагать.

        btnUp.setText("+");
        btnUp.setOnClickListener(this);
        btnDn.setText("-");
        btnDn.setOnClickListener(this);
        myText.setText(Integer.toString(count));


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnUp:
                count += count;
                break;
            case R.id.btnDn:
                count -= count;
                break;
        }
       myText.setText(Integer.toString(count));
    }
}