package ru.startandroid.lesson017dinamiclayout2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout llmain;
    TextView etName;
    RadioGroup rgGravity;
    Button btnCreate;
    Button btnClear;

    int wrapcontent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llmain = (LinearLayout) findViewById(R.id.llMain);
        etName = (TextView) findViewById(R.id.etName);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCreate:
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(wrapcontent,wrapcontent);
                int checkedGravity = Gravity.LEFT;
                switch (rgGravity.getCheckedRadioButtonId()){
                    case R.id.rbLeft:
                        checkedGravity = Gravity.START;
                        break;
                    case R.id.rbCenter:
                        checkedGravity = Gravity.CENTER;
                        break;
                    case R.id.rbRight:
                        checkedGravity = Gravity.END;
                        break;
                }
                lp.gravity = checkedGravity;
                Button newbutton = new Button(this);
                newbutton.setText(etName.getText().toString());
                llmain.addView(newbutton,lp);
                break;
            case R.id.btnClear:
                Toast.makeText(this, "layout clear", Toast.LENGTH_SHORT).show();
                llmain.removeAllViews();
                break;
        }
    }
}