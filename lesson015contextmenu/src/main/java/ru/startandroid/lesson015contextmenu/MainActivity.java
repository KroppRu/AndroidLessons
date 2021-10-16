package ru.startandroid.lesson015contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvColor;
    TextView tvSize;

//    final int MENU_COLOR_RED = 1;
//    final int MENU_COLOR_GREEN = 2;
//    final int MENU_COLOR_BLUE = 3;
//
//    final int MENU_SIZE_22 = 4;
//    final int MENU_SIZE_26 = 5;
//    final int MENU_SIZE_28 = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvColor = (TextView) findViewById(R.id.tvColor);
        tvSize = (TextView) findViewById(R.id.tvSize);

        registerForContextMenu(tvColor);
        registerForContextMenu(tvSize);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.MENU_COLOR_RED:
                tvColor.setTextColor(Color.RED);
                tvColor.setText("RED");
                break;
            case R.id.MENU_COLOR_GREEN:
                tvColor.setTextColor(Color.GREEN);
                tvColor.setText("GREEN");
                break;
            case R.id.MENU_COLOR_BLUE:
                tvColor.setTextColor(Color.BLUE);
                tvColor.setText("BLUE");
                break;
            case R.id.MENU_SIZE_22:
                tvSize.setTextSize(22);
                tvSize.setText("SIZE 22");
                break;
            case R.id.MENU_SIZE_26:
                tvSize.setTextSize(26);
                tvSize.setText("SIZE 26");
                break;
            case R.id.MENU_SIZE_30:
                tvSize.setTextSize(30);
                tvSize.setText("SIZE 30");
                break;

        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch(v.getId()){
            case R.id.tvColor:
//                menu.add(0,MENU_COLOR_RED,1,"Red");
//                menu.add(0,MENU_COLOR_GREEN,2,"Green");
//                menu.add(0,MENU_COLOR_BLUE,3,"Blue");
                getMenuInflater().inflate(R.menu.contextmenu_color,menu);
                break;
            case R.id.tvSize:
//                menu.add(0,MENU_SIZE_22,1,"22");
//                menu.add(0,MENU_SIZE_26,1,"26");
//                menu.add(0,MENU_SIZE_28,1,"28");
                getMenuInflater().inflate(R.menu.contextmenu_size,menu);
                break;
        }
    }


}