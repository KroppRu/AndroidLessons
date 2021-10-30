package ru.startandroid.lesson029simpleactivityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class NameActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText tietName;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        tietName = (TextInputEditText) findViewById(R.id.tietName);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnOk){
            Intent intent = new Intent();
            intent.putExtra("name",tietName.getText().toString());
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}