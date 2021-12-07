package ru.kropp.lesson051simpleadapterdata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final int ID_DELETE = 1;

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    SimpleAdapter adapter;
    ListView lvSimple;
    ArrayList<Map<String,Object>> data;
    Map<String,Object> m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<Map<String,Object>>(5);
        for (int i = 0; i<5; i++){
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, "Some text " + i);
            m.put(ATTRIBUTE_NAME_IMAGE, R.drawable.ic_launcher_foreground);
            data.add(m);
        }

        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_IMAGE};
        int[] to = {R.id.tvText, R.id.ivImg};

        adapter = new SimpleAdapter(this, data, R.layout.item, from, to);
        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(adapter);

        registerForContextMenu(lvSimple);

    }

    public void onButtonClick(View view) {
        m = new HashMap<String, Object>();
        m.put(ATTRIBUTE_NAME_TEXT, "Some new text " + (data.size() + 1));
        m.put(ATTRIBUTE_NAME_IMAGE, R.drawable.ic_launcher_foreground);
        data.add(m);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,ID_DELETE,0,"Удалить запись");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == ID_DELETE){
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            data.remove(acmi.position);
            adapter.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);

    }
}