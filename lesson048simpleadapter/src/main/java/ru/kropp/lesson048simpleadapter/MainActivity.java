package ru.kropp.lesson048simpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // имена атрибутов для Map
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CHECKED = "checked";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSimple = (ListView) findViewById(R.id.lvSimple);
        String[] texts = {"first","second","third","fourth","fith"};
        boolean[] checked = {true,false,false,true,false};
        int img = R.drawable.ic_launcher_foreground;

        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(checked.length);
        Map<String, Object> m;
        for(int i = 0;i<checked.length;i++){
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT,texts[i]);
            m.put(ATTRIBUTE_NAME_CHECKED, checked[i]);
            m.put(ATTRIBUTE_NAME_IMAGE, img);
            data.add(m);
        }

        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_CHECKED, ATTRIBUTE_NAME_IMAGE};
        int[] to = {R.id.tvText, R.id.cbChecked, R.id.ivImg};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

        lvSimple.setAdapter(simpleAdapter);

    }
}