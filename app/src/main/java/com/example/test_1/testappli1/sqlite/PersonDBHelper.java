package com.example.test_1.testappli1.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PersonDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "PersonDBHelper";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "personDN.db";

    private static PersonDBHelper sInstance;

    public static synchronized PersonDBHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PersonDBHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    public PersonDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i(TAG, "PersonDBHelper");
    }

    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "onCreate");
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db,oldVersion,newVersion);
    }
    private static final String SQL_CREATE_ENTRIES=
            "CREATE TABLE " + PersonContract.PersonEntry.TABLE_NAME + " (" +
                    PersonContract.PersonEntry._ID + " INTEGER PRIMARY KEY," +
                    PersonContract.PersonEntry.COLUMN_NAME_FIRSTNAME + " TEXT," +
                    PersonContract.PersonEntry.COLUMN_NAME_LASTNAME + " TEXT," +
                    PersonContract.PersonEntry.COLUMN_NAME_AVATAR + " TEXT)";

    private static final String SQL_DELETE_ENTRIES=
            "DROP TABLE IF EXISTS " + PersonContract.PersonEntry.TABLE_NAME;
}
