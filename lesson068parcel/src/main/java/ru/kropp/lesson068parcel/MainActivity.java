package ru.kropp.lesson068parcel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String LOG_TAG = "myLogs";
    Parcel p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeParcel();
        readParcel();
    }

    public void writeParcel(){
        p = Parcel.obtain();

        byte b = 1;
        int i = 2;
        long l = 3;
        float f = 4;
        double d = 5;
        String s = "abcdefgh";

        writeLog("before writing");
        p.writeByte(b);
        writeLog("byte");
        p.writeInt(i);
        writeLog("int");
        p.writeLong(l);
        writeLog("long");
        p.writeFloat(f);
        writeLog("float");
        p.writeDouble(d);
        writeLog("double");
        p.writeString(s);
        writeLog("String");
    }

    public void readParcel(){
        logReadInfo("Read parcel");
        p.setDataPosition(0);
        logReadInfo("byte = " + p.readByte());
        logReadInfo("int = " + p.readInt());
        logReadInfo("long = " + p.readLong());
        logReadInfo("float = " + p.readFloat());
        logReadInfo("double = " + p.readDouble());
        logReadInfo("string = " + p.readString());
    }

    public void writeLog(String _s){
        Log.d(LOG_TAG,_s + ": " + "dataSize = " + p.dataSize());
    }

    void logReadInfo(String txt) {
        Log.d(LOG_TAG, txt + ": " + "dataPosition = " + p.dataPosition());
    }
}