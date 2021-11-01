package ru.kropp.lesson030activityresult;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnColor;
    Button btnAlign;
    TextView tvText;

    ActivityResultLauncher<Intent> myColorActivityLauncer = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode()==RESULT_OK){
                int color = (int)result.getData().getExtras().get("color");
                tvText.setTextColor(color);
            }
        }
    });

    ActivityResultLauncher<Intent> myAlignActivityLauncer = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode()==RESULT_OK){
                int align = (int)result.getData().getExtras().get("align");
                tvText.setGravity(align);
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = (TextView) findViewById(R.id.tvText);
        btnAlign = (Button) findViewById(R.id.btnAlign);
        btnAlign.setOnClickListener(this);
        btnColor = (Button) findViewById(R.id.btnColor);
        btnColor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent;
        switch (view.getId()){
            case R.id.btnColor:
                intent= new Intent(this, ColorActivity.class);
                myColorActivityLauncer.launch(intent);
                break;
            case R.id.btnAlign:
                intent = new Intent(this, AlignActivity.class);
                myAlignActivityLauncer.launch(intent);
                break;
        }

    }
}