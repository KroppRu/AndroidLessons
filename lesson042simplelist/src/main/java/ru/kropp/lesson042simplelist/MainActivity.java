package ru.kropp.lesson042simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] names = {"Катя","Наташа","Вера","Людмила","Лера","Даша"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView) findViewById(R.id.myListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.my_item,names);
        myListView.setAdapter(adapter);

    }
}