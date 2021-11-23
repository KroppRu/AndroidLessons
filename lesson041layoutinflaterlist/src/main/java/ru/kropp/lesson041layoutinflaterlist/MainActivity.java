package ru.kropp.lesson041layoutinflaterlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] name = {"Ann", "Boris","Candy","Diana","Elon","Freddy","Giovanny","Henry","Iren","Jake","Kate"};
    String[] position = {"Boss", "Boss", "Manager", "Manager", "Manager", "Worker", "Worker", "Worker", "Worker", "Driver", "Designer"};
    int[] salary = {10000, 11000,9000,8000,9000,7000,8000,6000,7000,8000, 8000};
    int[] colors = new int[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linlayout = (LinearLayout) findViewById(R.id.linlayout);
        LayoutInflater ltInflater = getLayoutInflater();

        colors[0] = Color.GRAY;
        colors[1] = Color.YELLOW;

        for (int i = 0; i < name.length; i++){
            View item = ltInflater.inflate(R.layout.item, linlayout,false);

            if(i%2==0){item.setBackgroundColor(colors[1]);}else{item.setBackgroundColor(colors[0]);};

            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            tvName.setText(name[i]);

            TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition);
            tvPosition.setText("position: " + position[i]);

            TextView tvSalary = (TextView) item.findViewById(R.id.tvSalary);
            tvSalary.setText("salary: " + Integer.toString(salary[i]));

            linlayout.addView(item);

        }
    }
}