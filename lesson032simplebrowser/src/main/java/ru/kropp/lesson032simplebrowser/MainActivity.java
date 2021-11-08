package ru.kropp.lesson032simplebrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText tietUrl = (TextInputEditText) findViewById(R.id.tietUrl);

        findViewById(R.id.btnWeb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UrlString = "http://" + tietUrl.getText().toString();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(UrlString)));
            }
        });

    }
}