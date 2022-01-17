package ru.kropp.lesson057gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    String[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i","j", "k", "l"};
    GridView gvMain;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvMain = (GridView) findViewById(R.id.gvMain);

        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.tvText ,data);

        gvMain.setAdapter(adapter);

        setGridView();

    }

    public void setGridView(){
        gvMain.setNumColumns(GridView.AUTO_FIT);
        gvMain.setColumnWidth(200);
        gvMain.setVerticalSpacing(5);
        gvMain.setHorizontalSpacing(5);
        gvMain.setStretchMode(GridView.STRETCH_SPACING_UNIFORM);
    }
}