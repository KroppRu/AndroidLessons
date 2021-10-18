package ru.startandroid.lesson016dinamiclayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        //setContentView(R.layout.activity_main);
        setContentView(layout,layoutParams);

        LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        TextView tv = new TextView(this);
        tv.setText(R.string.texttv);
        tv.setLayoutParams(lpView);
        layout.addView(tv);

        Button bt = new Button(this);
        bt.setText(R.string.textbt);
        layout.addView(bt,lpView);

        LinearLayout.LayoutParams lpViewRight = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lpViewRight.gravity = Gravity.END;
        Button bt2 = new Button(this);
        bt2.setText(R.string.textbt);
        layout.addView(bt2,lpViewRight);

        LinearLayout.LayoutParams lpViewMargin = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lpViewMargin.setMarginStart(120);
        Button bt3 = new Button(this);
        bt3.setText(R.string.textbt);
        layout.addView(bt3,lpViewMargin);

    }
}