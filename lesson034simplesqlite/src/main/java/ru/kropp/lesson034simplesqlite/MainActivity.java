package ru.kropp.lesson034simplesqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String LOG_TAG = "mylogs";
    Button btnAdd, btnRead, btnClear, btnUpdate, btnDelete;
    TextInputEditText tietName, tietMail, tietID;
    DBHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tietName = (TextInputEditText) findViewById(R.id.tietName);
        tietMail = (TextInputEditText) findViewById(R.id.tietMail);
        tietID = (TextInputEditText) findViewById(R.id.tietID);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        btnAdd.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        dbhelper = new DBHelper(this);

    }

    @Override
    public void onClick(View view) {

        String name = tietName.getText().toString();
        String mail = tietMail.getText().toString();
        String id = tietID.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("email",mail);

        SQLiteDatabase db = dbhelper.getWritableDatabase();

        switch (view.getId()){
            case R.id.btnAdd:
                Log.d(LOG_TAG,"insert in mytable");
                Long rowID = db.insert("mytable", null, cv);
                Log.d(LOG_TAG,"row with ID " + rowID);
                break;
            case R.id.btnRead:
                Log.d(LOG_TAG, "--- Rows in mytable: ---");
                // делаем запрос всех данных из таблицы mytable, получаем Cursor
                Cursor c = db.query("mytable", null, null, null, null, null, null);

                // ставим позицию курсора на первую строку выборки
                // если в выборке нет строк, вернется false
                if (c.moveToFirst()) {

                    // определяем номера столбцов по имени в выборке
                    int idColIndex = c.getColumnIndex("id");
                    int nameColIndex = c.getColumnIndex("name");
                    int emailColIndex = c.getColumnIndex("email");

                    do {
                        // получаем значения по номерам столбцов и пишем все в лог
                        Log.d(LOG_TAG,
                                "ID = " + c.getInt(idColIndex) +
                                        ", name = " + c.getString(nameColIndex) +
                                        ", email = " + c.getString(emailColIndex));
                        // переход на следующую строку
                        // а если следующей нет (текущая - последняя), то false - выходим из цикла
                    } while (c.moveToNext());
                } else
                    Log.d(LOG_TAG, "0 rows");
                c.close();
                break;
            case R.id.btnClear:
                Log.d(LOG_TAG, "--- Clear mytable: ---");
                // удаляем все записи
                int clearCount = db.delete("mytable", null, null);
                Log.d(LOG_TAG, "deleted rows count = " + clearCount);
                break;
            case R.id.btnUpdate:
                if(id.equalsIgnoreCase("")) break;
                Log.d(LOG_TAG,"--Updating my table row" + id);
                // обновляем по id
                int updCount = db.update("mytable", cv, "id = ?",
                        new String[] { id });
                Log.d(LOG_TAG, "updated rows count = " + updCount);
                break;
            case R.id.btnDelete:
                if(id.equalsIgnoreCase("")) break;
                Log.d(LOG_TAG,"--from mytable delete row" + id);
                int delCount = db.delete("mytable","id = ?", new String[] {id});
                Log.d(LOG_TAG,""+delCount+" rows was deleted");
                break;
        }
        db.close();
        dbhelper.close();
    }

   class DBHelper extends SQLiteOpenHelper {

       public DBHelper(@Nullable Context context) {
           super(context, "myDB", null, 1);
       }

       @Override
       public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Log.d(LOG_TAG,"database was created");
            sqLiteDatabase.execSQL("create table mytable (" +
                              "id integer primary key autoincrement," +
                              "name text," +
                              "email text" + ");");
       }

       @Override
       public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

       }
   }
}