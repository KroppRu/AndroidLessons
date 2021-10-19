package ru.startandroid.lesson018dinamiclayout3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar seekBar;
    Button btnLeft;
    Button btnRight;

    LinearLayout.LayoutParams lpLeft;
    LinearLayout.LayoutParams lpRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);

        lpLeft = (LinearLayout.LayoutParams) btnLeft.getLayoutParams();
        lpRight = (LinearLayout.LayoutParams) btnRight.getLayoutParams();


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int rightProgress = seekBar.getMax() - i;
        lpLeft.weight = i;
        lpRight.weight = rightProgress;
        btnLeft.setText(Integer.toString(i));
        btnRight.setText(Integer.toString(rightProgress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}