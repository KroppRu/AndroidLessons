package ru.kropp.lesson044simplelistevents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    String[] names;
    ListView lvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.names, android.R.layout.simple_list_item_multiple_choice);
        lvMain.setAdapter(adapter);

        names = getResources().getStringArray(R.array.names);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d(LOG_TAG,"clicked position: "+ Integer.toString(position) + " id: " + Long.toString(id));
            }
        });

        lvMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d(LOG_TAG,"checked position: "+ Integer.toString(position) + " id: " + Long.toString(id));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d(LOG_TAG, "nothing selected");
            }
        });

        lvMain.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                Log.d(LOG_TAG, "scroll state: " + i);
            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int countVisibleItem, int countItem) {
                Log.d(LOG_TAG,"first: " + firstVisibleItem + ", countVisible: " + countVisibleItem + ", countAll: " + countItem);
            }
        });

    }


}