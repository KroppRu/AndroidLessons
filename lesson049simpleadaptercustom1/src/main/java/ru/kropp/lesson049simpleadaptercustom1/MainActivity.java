package ru.kropp.lesson049simpleadaptercustom1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_VALUE = "value";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    final int positive = android.R.drawable.arrow_up_float;
    final int negative = android.R.drawable.arrow_down_float;

    TextView tvText, tvValue;
    ImageView ivImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] values = {3,5,-2,1,-4,-5,8};
        String[] texts = {"Monday", "Tuesday","Wednesday","Fourthday","Friday","Saturday","Sunday"};
        int img = 0;

        ArrayList<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        for(int i=0;i<values.length; i++){
            Map<String, Object> m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, texts[i]);
            m.put(ATTRIBUTE_NAME_VALUE, values[i]);
            if (values[i] == 0) img = 0; else
                img = (values[i] > 0) ? positive : negative;
            m.put(ATTRIBUTE_NAME_IMAGE,img);
            data.add(m);
        }
        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_VALUE, ATTRIBUTE_NAME_IMAGE};
        int[] to = {R.id.tvText, R.id.tvValue, R.id.ivImg};

        MySimpleAdapter mySimpleAdapter = new MySimpleAdapter(this,data,R.layout.item,from,to);

        ListView lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(mySimpleAdapter);

    }
}