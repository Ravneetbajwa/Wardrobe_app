package com.example.macstudent.styleme.db.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
DBDress mdbDress;
private SQLiteDatabase mDb;
DatabaseHandler dbHand;
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "WardrobeManager";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DRESS_TABLE = "CREATE TABLE " + DBDress.TABLE_DRESS + "("
                + DBDress.DRESS_TYPE + " TEXT ," + DBDress.DRESS_IMAGE + " BLOB,"
                + DBDress.DRESS_COLOR + " TEXT, " +   DBDress.DRESS_SEASON + " TEXT )";
        db.execSQL(CREATE_DRESS_TABLE);

        String CREATE_OUTFIT_TABLE = "CREATE TABLE " + DBOutfit.TABLE_OUTFIT + "("
                + DBOutfit.OUTFIT_ID + " INTEGER PRIMARY KEY," + DBOutfit.OUTFIT_TYPE + " TEXT," + DBOutfit.OUTFIT_IMAGE+ " BLOB)";

        db.execSQL(CREATE_OUTFIT_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DBDress.TABLE_DRESS);
        db.execSQL("DROP TABLE IF EXISTS " + DBOutfit.TABLE_OUTFIT);

        // Create tables again
        onCreate(db);
    }
    public DatabaseHandler open() throws SQLException {
        mDb = dbHand.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHand.close();
    }

}
