package ru.kropp.lesson050simpleadaptercustom2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final String ATTRIBUTE_NAME_PB = "pb";
    final String ATTRIBUTE_NAME_LL = "ll";
    final String ATTRIBUTE_NAME_TEXT = "text";

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] loads = {20,30,70,50,90,10,40,100};

        ArrayList <Map<String,Object>> data = new ArrayList<Map<String,Object>>(loads.length);
        Map<String,Object> m;
        for (int i = 0; i<loads.length;i++){
            m = new HashMap<String,Object>();
            m.put(ATTRIBUTE_NAME_TEXT,"Day " + (i+1) + ". Load: " + loads[i] + "%");
            m.put(ATTRIBUTE_NAME_PB,loads[i]);
            m.put(ATTRIBUTE_NAME_LL,loads[i]);
            data.add(m);
        }

        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_PB, ATTRIBUTE_NAME_LL};
        int[] to = {R.id.tvLoad, R.id.pbLoad, R.id.llLoad};

        SimpleAdapter myAdapter = new SimpleAdapter(this,data, R.layout.item,from,to);
        myAdapter.setViewBinder(new MyViewBinder());
        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(myAdapter);

    }

    public class MyViewBinder implements SimpleAdapter.ViewBinder{

        int red = getResources().getColor(R.color.Red);
        int orange = getResources().getColor(R.color.Orange);
        int green = getResources().getColor(R.color.Green);


        @Override
        public boolean setViewValue(View view, Object o, String s) {
            int i = 0;
            switch (view.getId()){
                case R.id.llLoad:
                    i = ((Integer) o).intValue();
                    if (i < 40) view.setBackgroundColor(green); else
                    if (i < 70) view.setBackgroundColor(orange); else
                        view.setBackgroundColor(red);
                    return true;
                case R.id.pbLoad:
                    i = ((Integer) o).intValue();
                    ((ProgressBar)view).setProgress(i);
                    return true;
            }
            return false;
        }
    }

}

