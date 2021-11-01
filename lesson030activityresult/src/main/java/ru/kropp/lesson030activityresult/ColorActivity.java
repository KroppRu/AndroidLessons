package ru.kropp.lesson030activityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener {

   Button btnRed;
   Button btnGreen;
   Button btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        btnRed = (Button) findViewById(R.id.btnRed);
        btnGreen = (Button) findViewById(R.id.btnGreen);
        btnBlue = (Button) findViewById(R.id.btnBlue);

        btnRed.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();

        switch (view.getId()){
            case R.id.btnRed:
                intent.putExtra("color", Color.RED);
                setResult(RESULT_OK,intent);
                break;
            case R.id.btnGreen:
               intent.putExtra("color", Color.GREEN);
                setResult(RESULT_OK,intent);
                break;
            case R.id.btnBlue:
                intent.putExtra("color", Color.BLUE);
                setResult(RESULT_OK,intent);
                break;
            default:
                setResult(RESULT_CANCELED);

        }
        finish();
    }
}