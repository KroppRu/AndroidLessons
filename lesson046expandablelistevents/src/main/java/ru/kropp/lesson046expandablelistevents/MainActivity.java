package ru.kropp.lesson046expandablelistevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    ExpandableListView elvMain;
    TextView tvInfo;

    AdapterHelper ah;
    SimpleExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.tvInfo);

        ah = new AdapterHelper(this);
        adapter = ah.getAdapter();

        elvMain = (ExpandableListView) findViewById(R.id.elvMain);
        elvMain.setAdapter(adapter);

        elvMain.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long id) {
                Log.d(LOG_TAG, "Group: " + groupPosition + " child: " + childPosition + " id: " + id);
                tvInfo.setText(ah.getGroupChildText(groupPosition, childPosition));
                return false;
            }
        });

        elvMain.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long id) {
                Log.d(LOG_TAG, "click on Group: " + groupPosition + " id: " + id);
                tvInfo.setText(ah.getGroupText(groupPosition));
                if (groupPosition==1){
                    return  true;
                }
                return false;
            }
        });

        elvMain.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Log.d(LOG_TAG, "expande Group: " + groupPosition);
            }
        });

        elvMain.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Log.d(LOG_TAG, "collapse Group: " + groupPosition);
            }
        });

    }
}