package ru.kropp.lesson038sqlitetransaction;

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

    DBhelper dbh;
    SQLiteDatabase db;

    final String LOG_TAG = "myLogs";
    final String DB_TABLE = "myTable";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG,"on create activity");
        dbh = new DBhelper(this);
        db = dbh.getWritableDatabase();

        myActions();
    }

    void myActions(){
        Log.d(LOG_TAG,"delete " + DB_TABLE);
        delete(db,DB_TABLE);
        String value;

        db.beginTransaction();
        value= "example1";
        Log.d(LOG_TAG,"insert in " + DB_TABLE + " value " + value);
        insert(db,DB_TABLE,value);

        value= "example2";
        Log.d(LOG_TAG,"insert in " + DB_TABLE + " value " + value);
        insert(db,DB_TABLE,value);

        value= "example3";
        Log.d(LOG_TAG,"insert in " + DB_TABLE + " value " + value);
        insert(db,DB_TABLE,value);
        db.setTransactionSuccessful();
        db.endTransaction();

        Log.d(LOG_TAG,"content of table " + DB_TABLE + " is here:");
        read(db,DB_TABLE);
    }

    void delete(SQLiteDatabase _db, String _table){
        _db.delete(_table,null,null);
    }

    void insert(SQLiteDatabase _db, String _table, String _value){
        ContentValues cv = new ContentValues();
        cv.put("value",_value);
        _db.insert(_table,null,cv);
    }

    @SuppressLint("Range")
    void read(SQLiteDatabase _db, String _table){
        Cursor c = _db.query(_table,null,null,null,null,null,null);
        if (c!=null){
            if(c.moveToFirst()){
                do{
                    Log.d(LOG_TAG,"value: " + c.getString(c.getColumnIndex("value")));
                }while (c.moveToNext());
            }
        }
    }

    class DBhelper extends SQLiteOpenHelper{

        public DBhelper(@Nullable Context context) {
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("Create table "+DB_TABLE+"(_id integer primary key autoincrement, value text);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

}

