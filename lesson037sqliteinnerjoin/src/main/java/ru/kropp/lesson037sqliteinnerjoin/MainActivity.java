package ru.kropp.lesson037sqliteinnerjoin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    final String TAGLOG = "myLogs";

    int[] position_id = {1,2,3,4};
    String[] position_name = {"Директор", "Программист","Бухгалтер","Менеджер"};
    int[] position_salary = {150000, 120000, 100000, 80000};

    String[] people_name = {"Аня","Борис","Вера","Геннадий","Дмитрий","Евгений","Жанна"};
    int[] people_position = {4,2,2,4,1,2,3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBbHelper dbh = new DBbHelper(this,"myBD1");
        SQLiteDatabase db = dbh.getWritableDatabase();

        Cursor c;

        Log.d(TAGLOG,"Посмотрим таблицу должностей");
        c = db.query("position", null, null, null, null, null, null);
        logCursor(c);
        c.close();
        Log.d(TAGLOG, "--- ---");

        Log.d(TAGLOG,"Посмотрим таблицу людей");
        c = db.query("people",null,null,null,null,null,"name");
        logCursor(c);
        c.close();
        Log.d(TAGLOG, "--- ---");


    }

    void logCursor(Cursor c){
        if (c != null) {
            if (c.moveToFirst()) {
                String str;
                do {
                    str = "";
                    for (String cn : c.getColumnNames()) {
                        str = str.concat(cn + " = " + c.getString(c.getColumnIndex(cn)) + "; ");
                    }
                    Log.d(TAGLOG, str);
                } while (c.moveToNext());
            }
        } else
            Log.d(TAGLOG, "Cursor is null");
    }

    class DBbHelper extends SQLiteOpenHelper{

        String nameDB;

        public DBbHelper(@Nullable Context context, String _nameDB) {
            super(context, _nameDB, null, 1);
            nameDB = nameDB;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Log.d(TAGLOG,"создаем таблицы базы данных");

            ContentValues cv = new ContentValues();

            sqLiteDatabase.execSQL("create table position (id integer primary key, name text, salary integer);");
            for (int i = 0; i<position_id.length; i++ ) {
                cv.put("id",position_id[i]);
                cv.put("name", position_name[i]);
                cv.put("salary", position_salary[i]);
                sqLiteDatabase.insert("positon",null,cv);
            };

            sqLiteDatabase.execSQL("create table people (id integer primary key autoincrement, name text, position integer);");
            for (int i = 0; i<position_id.length; i++ ) {
                cv.put("name", people_name[i]);
                cv.put("position", people_position[i]);
                sqLiteDatabase.insert("people",null,cv);
            };
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}