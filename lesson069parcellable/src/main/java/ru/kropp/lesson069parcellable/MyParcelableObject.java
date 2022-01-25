package ru.kropp.lesson069parcellable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class MyParcelableObject implements Parcelable {

    private String s;
    private int i;

    final static String LOG_TAG = "myLogs";

    MyParcelableObject(String _s, int _i){
        s = _s;
        i = _i;
    }

    protected MyParcelableObject(Parcel in) {
        s = in.readString();
        i = in.readInt();
    }

    public static final Creator<MyParcelableObject> CREATOR = new Creator<MyParcelableObject>() {
        @Override
        public MyParcelableObject createFromParcel(Parcel in) {
            Log.d(LOG_TAG, "createFromParcel");
            return new MyParcelableObject(in);
        }

        @Override
        public MyParcelableObject[] newArray(int size) {
            return new MyParcelableObject[size];
        }
    };

    public String getS() {
        return s;
    }

    public int getI() {
        return i;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int index) {
        Log.d(LOG_TAG, "writeToParcel");
        parcel.writeString(s);
        parcel.writeInt(i);
    }
}
