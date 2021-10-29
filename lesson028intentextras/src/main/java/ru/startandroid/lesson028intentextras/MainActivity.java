package ru.startandroid.lesson028intentextras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText etFirstName;
    TextInputEditText etLastName;
    Button btnHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = (TextInputEditText) findViewById(R.id.etFirstName);
        etLastName = (TextInputEditText) findViewById(R.id.etLastName);
        btnHello = (Button) findViewById(R.id.btnHello);
        btnHello.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnHello){
            Intent intent = new Intent(this, HelloBackActivity.class);
            intent.putExtra("firstName",etFirstName.getText().toString());
            intent.putExtra("lastName",etLastName.getText().toString());
            startActivity(intent);
        }
    }
}