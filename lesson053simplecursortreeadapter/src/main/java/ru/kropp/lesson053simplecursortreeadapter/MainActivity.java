package ru.kropp.lesson053simplecursortreeadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleCursorTreeAdapter;
import android.widget.SimpleExpandableListAdapter;

public class MainActivity extends AppCompatActivity {

    ExpandableListView elvMain;
    DB myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DB(this);
        myDB.openDB();

        Cursor cursorGroup = myDB.getCompanyData();
        String[] groupFrom = {DB.COMPANY_COLUMN_NAME};
        int[] groupTo = {android.R.id.text1};

        String[] childFrom = {DB.CARS_COLUMN_NAME};
        int[] childTo = {android.R.id.text1};



        elvMain = (ExpandableListView) findViewById(R.id.elvMain);
        MyTreeAdapter madapter = new MyTreeAdapter(this, cursorGroup, android.R.layout.simple_expandable_list_item_1,groupFrom,groupTo,
                android.R.layout.simple_expandable_list_item_2, childFrom,childTo);
        elvMain.setAdapter(madapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDB.closeDB();
    }

    private class MyTreeAdapter extends SimpleCursorTreeAdapter{

        public MyTreeAdapter(Context context, Cursor cursor, int groupLayout, String[] groupFrom, int[] groupTo, int childLayout, String[] childFrom, int[] childTo) {
            super(context, cursor, groupLayout, groupFrom, groupTo, childLayout, childFrom, childTo);
        }

        @Override
        protected Cursor getChildrenCursor(Cursor cursor) {
            int idColumn = cursor.getColumnIndex(DB.COMPANY_COLUMN_ID);
            return myDB.getCarsData(cursor.getInt(idColumn));
        }
    }
}