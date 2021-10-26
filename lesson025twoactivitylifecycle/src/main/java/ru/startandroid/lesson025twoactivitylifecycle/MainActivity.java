package ru.startandroid.lesson025twoactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnGo;
    final private String TAG = "ActivityState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(this);

        Log.d(TAG,"Main create");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGo:
                Intent intent = new Intent(this,SecondActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"Main restart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Main start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"Main resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"Main pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Main stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Main destroy");
    }
}