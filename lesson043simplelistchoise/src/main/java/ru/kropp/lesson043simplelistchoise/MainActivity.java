package ru.kropp.lesson043simplelistchoise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String LOG_TAG = "myLogs";

    ListView lvMain;
    String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView)findViewById(R.id.lvMain);
        lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_list_item_multiple_choice);
        lvMain.setAdapter(adapter);

        Button btnChecked = (Button) findViewById(R.id.btnChecked);
        btnChecked.setOnClickListener(this);

        names = getResources().getStringArray(R.array.names);
    }

    @Override
    public void onClick(View view) {
        SparseBooleanArray sba = lvMain.getCheckedItemPositions(); //хранит истину для отмеченых позиций и ложь дя не отмеченных
        for (int i = 0; i < sba.size(); i++){
            int key = sba.keyAt(i); //кей тут это номер элемента списка
            if(sba.get(key)){ //узнаем, отмечен он или нет
                Log.d(LOG_TAG, "Checked: " + names[key]);
            }

        }

    }
}