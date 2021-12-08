package ru.kropp.lesson053simplecursortreeadapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB {
    private static final String DB_NAME = "mydb2";
    private static final int DB_VERSION = 1;

    private final String COMPANY_TABLE = "company";
    public static final String COMPANY_COLUMN_ID = "_id";
    public static final String COMPANY_COLUMN_NAME = "name";
    private final String COMPANY_CREATE = "Create table " + COMPANY_TABLE + "(" + COMPANY_COLUMN_ID + " integer primary key, " + COMPANY_COLUMN_NAME +" text)";

    private final String CARS_TABLE = "cars";
    private final String CARS_COLUMN_ID = "_id";
    public static final String CARS_COLUMN_NAME = "name";
    public static final String CARS_COLUMN_COMPANY = "company";
    private final String CARS_CREATE = "Create table " + CARS_TABLE
            + "(" + CARS_COLUMN_ID + " integer primary key autoincrement, " + CARS_COLUMN_NAME +" text," + CARS_COLUMN_COMPANY +" text)";

    private Context myContext;
    private MyDBHelper myDBHepler;
    private SQLiteDatabase myDB;

    public DB (Context ctx){
        myContext = ctx;
    }

    public void openDB(){
        myDBHepler = new MyDBHelper(myContext,DB_NAME,null,DB_VERSION);
        myDB = myDBHepler.getWritableDatabase();
    }

    public void closeDB(){
        if(myDBHepler!=null) myDBHepler.close();
    }

    public Cursor getCompanyData(){
        return myDB.query(COMPANY_TABLE,null,null,null,null,null,null);
    }

    public  Cursor getCarsData(int companyID){
        return myDB.query(CARS_TABLE,null, "" + CARS_COLUMN_COMPANY + " = " + companyID,null,null,null,null);
    }


    private class MyDBHelper extends SQLiteOpenHelper{

        public MyDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String[] companies = {"Toyota", "Suzuki", "Mazda"};
            String[] cars_1 = {"LandCruiser", "Camry", "Supra"};
            String[] cars_2 = {"Liana", "Vitara"};
            String[] cars_3 = {"Familia", "RX-5"};
            ContentValues cv;

            sqLiteDatabase.execSQL(COMPANY_CREATE);

            for(int i = 0; i< companies.length; i++){
                cv = new ContentValues();
                cv.put(COMPANY_COLUMN_ID,i+1);
                cv.put(COMPANY_COLUMN_NAME, companies[i]);
                sqLiteDatabase.insert(COMPANY_TABLE,null,cv);
            }

            sqLiteDatabase.execSQL(CARS_CREATE);

            for(int i = 0; i< cars_1.length; i++){
                cv = new ContentValues();
                //cv.put(CARS_COLUMN_ID,i+1);
                cv.put(CARS_COLUMN_COMPANY,1);
                cv.put(CARS_COLUMN_NAME, cars_1[i]);
                sqLiteDatabase.insert(CARS_TABLE,null,cv);
            }
            for(int i = 0; i< cars_2.length; i++){
                cv = new ContentValues();
               // cv.put(CARS_COLUMN_ID,i+1);
                cv.put(CARS_COLUMN_COMPANY,2);
                cv.put(CARS_COLUMN_NAME, cars_2[i]);
                sqLiteDatabase.insert(CARS_TABLE,null,cv);
            }
            for(int i = 0; i< cars_3.length; i++){
                cv = new ContentValues();
               //cv.put(CARS_COLUMN_ID,i+1);
                cv.put(CARS_COLUMN_COMPANY,3);
                cv.put(CARS_COLUMN_NAME, cars_3[i]);
                sqLiteDatabase.insert(CARS_TABLE,null,cv);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}

