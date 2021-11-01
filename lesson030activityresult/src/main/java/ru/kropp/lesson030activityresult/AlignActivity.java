package ru.kropp.lesson030activityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class AlignActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLeft;
    Button btnCenter;
    Button btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align);

        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnCenter = (Button) findViewById(R.id.btnCenter);
        btnRight = (Button) findViewById(R.id.btnRight);

        btnLeft.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnRight.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.btnLeft:
               intent.putExtra("align", Gravity.START);
                setResult(RESULT_OK,intent);
                finish();
                break;
            case R.id.btnCenter:
                intent.putExtra("align", Gravity.CENTER);
                setResult(RESULT_OK,intent);
                finish();
                break;
            case R.id.btnRight:
                intent.putExtra("align", Gravity.END);
                setResult(RESULT_OK,intent);
                finish();
                break;
        }
    }
}