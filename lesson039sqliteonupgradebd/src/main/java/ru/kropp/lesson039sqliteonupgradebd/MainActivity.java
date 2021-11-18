package ru.kropp.lesson039sqliteonupgradebd;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import javax.xml.namespace.QName;

public class MainActivity extends Activity {

    final String LOG_TAG = "myLogs";

    final String DB_NAME = "staff"; // имя БД
    final int DB_VERSION = 2; // версия БД

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbh = new DBHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();
        Log.d(LOG_TAG, " --- Staff db v." + db.getVersion() + " --- ");
        writeStaff(db);
        dbh.close();
    }

    // запрос данных и вывод в лог
    private void writeStaff(SQLiteDatabase db) {
        Cursor c = db.rawQuery("select PL.name as name, PS.name as position, salary as salary from people as PL inner join position as PS on PL.posid - PS.id", null);
        logCursor(c, "Table people inner join position");
        c.close();
    }

    // вывод в лог данных из курсора
    @SuppressLint("Range")
    void logCursor(Cursor c, String title) {
        if (c != null) {
            if (c.moveToFirst()) {
                Log.d(LOG_TAG, title + ". " + c.getCount() + " rows");
                StringBuilder sb = new StringBuilder();
                do {
                    sb.setLength(0);
                    for (String cn : c.getColumnNames()) {
                        sb.append(cn).append(" = ").append(c.getString(c.getColumnIndex(cn))).append("; ");
                    }
                    Log.d(LOG_TAG, sb.toString());
                } while (c.moveToNext());
            }
        } else
            Log.d(LOG_TAG, title + ". Cursor is null");
    }

    // класс для работы с БД
    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, " --- onCreate database --- ");

            String[] people_name = { "Иван", "Марья", "Петр", "Антон", "Даша",
                    "Борис", "Костя", "Игорь" };
            int[] people_posid = { 2, 3, 2, 2, 3, 1, 2, 4 };

            // данные для таблицы должностей
            int[] position_id = {1,2,3,4};
            String[] position_name = {"Директор","Программист","Бухгалтер", "Менеджер"};
            int[] position_salary = {100000,90000,80000,70000};

            ContentValues cv = new ContentValues();

            // создаем таблицу должностей
            db.execSQL("create table position (" + "id integer primary key,"
                    + "name text, salary integer" + ");");

            // заполняем ее
            for (int i = 0; i < position_id.length; i++) {
                cv.clear();
                cv.put("id", position_id[i]);
                cv.put("name", position_name[i]);
                cv.put("salary", position_salary[i]);
                db.insert("position", null, cv);
            }

            // создаем таблицу людей
            db.execSQL("create table people ("
                    + "id integer primary key autoincrement,"
                    + "name text, posid integer);");

            // заполняем ее
            for (int i = 0; i < people_name.length; i++) {
                cv.clear();
                cv.put("name", people_name[i]);
                cv.put("posid", people_posid[i]);
                db.insert("people", null, cv);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(LOG_TAG, " --- onUpgrade database from " + oldVersion + " to " + newVersion + " version --- ");
            if(oldVersion == 1 && newVersion ==2){

                db.beginTransaction();
                try {

                    //сроздаем новую таблицу
                    db.execSQL("create table position(id integer primary key, name text, salary integer);");
                    int[] position_id = {1,2,3,4};
                    String[] position_name = {"Директор","Программист","Бухгалтер", "Менеджер"};
                    int[] position_salary = {100000,90000,80000,70000};
                    ContentValues cv = new ContentValues();
                    for (int i = 0; i < position_id.length; i++){
                        cv.clear();
                        cv.put("id",position_id[i]);
                        cv.put("name",position_name[i]);
                        cv.put("salary",position_salary[i]);
                        db.insert("position",null,cv);
                    }

                    //Меняем старую
                    db.execSQL("alter table people add column posid integer;");
                    for (int i = 0; i < position_id.length; i++) {
                        cv.clear();
                        cv.put("posid", position_id[i]);
                        db.update("people", cv, "position = ?",
                                new String[] { position_name[i] });
                    }

                    db.execSQL("create temporary table tempPeople(id integer primary key autoincrement, name text, posid integer);");
                    db.execSQL("insert into tempPeople select id, name, posid from people;");
                    db.execSQL("drop table people");
                    db.execSQL("create table people(id integer primary key autoincrement, name text, posid integer);");
                    db.execSQL("insert into people select id, name, posid from tempPeople;");
                    db.execSQL("drop table tempPeople");

                    db.setTransactionSuccessful();
                }finally {
                    db.endTransaction();
                };
            }

        }
    }
}