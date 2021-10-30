package ru.startandroid.lesson029simpleactivityresult;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvName;
    Button btnGo;
    ActivityResultContract mySecondActivityContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (TextView) findViewById(R.id.tvName);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(this);
//        mySecondActivityContract = new ActivityResultContract() {
//            @NonNull
//            @Override
//            public Intent createIntent(@NonNull Context context, Object input) {
//                Intent intent = new Intent(context, NameActivity.class);
//                intent.putExtra("name", String.valueOf(input));
//                return intent;
//            }
//
//            @Override
//            public Object parseResult(int resultCode, @Nullable Intent intent) {
//                return intent;
//            }
//        };
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnGo){
            Intent intent = new Intent(this,NameActivity.class);
//            registerForActivityResult(mySecondActivityContract );
            startActivityForResult(intent,1);
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        tvName.setText("Your name is " + data.getExtras().get("name").toString());
    }
}