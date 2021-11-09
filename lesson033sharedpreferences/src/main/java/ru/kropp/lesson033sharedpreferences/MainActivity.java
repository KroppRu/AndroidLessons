package ru.kropp.lesson033sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText tiet;
    Button btnLoad, btnSave;

    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiet = (TextInputEditText) findViewById(R.id.tiet);

        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        loadText();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
        }
    }

    void saveText(){
        sPref = getSharedPreferences("kroppPref",MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, tiet.getText().toString());
        ed.commit();
        Toast.makeText(this,"text was saved",Toast.LENGTH_SHORT);
    }

    void loadText(){
        sPref = getSharedPreferences("kroppPref",MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT,"");
        tiet.setText(savedText);
        Toast.makeText(this,"text was load",Toast.LENGTH_SHORT);
    }
}