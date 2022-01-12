package ru.kropp.lesson055headerfooter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] data = {"one", "two", "three", "four", "five"};
    ListView lvMain;
    ArrayAdapter<String> adapter;
    View header1,header2;
    View footer1, footer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView) findViewById(R.id.lvMain);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,data);

        header1 = createHeader("Header 1");
        header2 = createHeader("Header 2");
        footer1 = createFooter("Footer 1");
        footer2 = createFooter("Footer 2");

        fillList();
        //lvMain.setAdapter();
    }

    public View createHeader(String _s){
        View v = getLayoutInflater().inflate(R.layout.header, null);
        ((TextView)v.findViewById(R.id.tvText)).setText(_s);
        return v;
    }

    public View createFooter(String _s){
        View v = getLayoutInflater().inflate(R.layout.footer,null);
        TextView tvText = (TextView)v.findViewById(R.id.tvText);
        tvText.setText(_s);
        return v;
    }

    public void fillList(){
        lvMain.addHeaderView(header1);
        lvMain.addHeaderView(header2,"Some text h2",false);
        lvMain.addFooterView(footer1);
        lvMain.addFooterView(footer2, "some text for h2",false);
        lvMain.setAdapter(adapter);
    }

    // нажатие кнопки
    public void onclick(View v) {
        lvMain.removeHeaderView(header2);
        lvMain.removeFooterView(footer2);
    }


}

