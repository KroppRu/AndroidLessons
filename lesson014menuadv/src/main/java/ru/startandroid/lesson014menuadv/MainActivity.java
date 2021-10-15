package ru.startandroid.lesson014menuadv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    CheckBox chb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.mytextView);
        chb = (CheckBox) findViewById(R.id.chbExtMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.add(0, 1, 0, "add");
//        menu.add(0, 2, 0, "edit");
//        menu.add(0, 3, 0, "delete");
//        menu.add(1, 4, 0, "copy");
//        menu.add(1, 5, 0, "paste");
//        menu.add(1, 6, 0, "exit");
        getMenuInflater().inflate(R.menu.mymenu,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // пункты меню с ID группы = 1 видны, если в CheckBox стоит галка
        menu.setGroupVisible(R.id.group1,chb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Выведем в TextView информацию о нажатом пункте меню
        String sb = "Item Menu" +
                "\r\n groupId: " + String.valueOf(item.getGroupId()) +
                "\r\n itemId: " + String.valueOf(item.getItemId()) +
                "\r\n order: " + String.valueOf(item.getOrder()) +
                "\r\n title: " + item.getTitle();
        tv.setText(sb);

        return super.onOptionsItemSelected(item);
    }
}