package com.example.macstudent.styleme.db.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;

import com.example.macstudent.styleme.db.model.MDress;
import com.example.macstudent.styleme.db.model.Utils;

import java.util.ArrayList;
import java.util.List;

public class DBDress {

    static final String TABLE_DRESS = "Dresses";

    // Contacts Table Columns names
    static final String DRESS_TYPE = "type";
    static final String DRESS_IMAGE = "image";
    static final String DRESS_SEASON = "season";
    static final String DRESS_COLOR = "color";

    private static DatabaseHandler databaseHandler;
    private static Context context;
    private SQLiteDatabase mDb;
    private DBDress mDbDress;
    public DBDress(Context context) {
        this.context = context;
    }

    // Adding new dress
    public void addDress(MDress dress) {
        databaseHandler = new DatabaseHandler(context);
        SQLiteDatabase db = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DRESS_TYPE, dress.get_type());
        values.put(DRESS_IMAGE, dress.get_image());
        values.put(DRESS_SEASON, dress.get_season());
        values.put(DRESS_COLOR, dress.get_color());

        // Inserting Row
        db.insert(TABLE_DRESS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    public MDress getDress(String type) {
        databaseHandler = new DatabaseHandler(context);
        SQLiteDatabase db = databaseHandler.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DRESS, new String[]{DRESS_TYPE,
                        DRESS_IMAGE,DRESS_SEASON,DRESS_COLOR}, DRESS_TYPE + "=?",
                new String[]{String.valueOf(type)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        MDress dress = new MDress((cursor.getString(0)),
                cursor.getBlob(1), cursor.getString(2), cursor.getString(3));
        // return contact
        return dress;
    }

    public byte[] retreiveImageFromDB(String type, String season) {
        databaseHandler = new DatabaseHandler(context);
        SQLiteDatabase db = databaseHandler.getReadableDatabase();
        Cursor cur = db.query(TABLE_DRESS, new String[]{ DRESS_IMAGE,},
                DRESS_TYPE + "=? AND " + DRESS_SEASON + "=?" ,  new String[]{type,season}, null, null,
                "RANDOM()", "1");
        if (cur.moveToFirst()) {
            byte[] blob = cur.getBlob(cur.getColumnIndex(DRESS_IMAGE));
            System.out.println("****************" + type);
//            String col = cur.getString(cur.getColumnIndex(DRESS_COLOR));
//            String style = cur.getString(cur.getColumnIndex(DRESS_TYPE));
//            String season = cur.getString(cur.getColumnIndex(DRESS_SEASON));
            cur.close();
            return blob;
        }
        cur.close();
        return null;
    }

   // Getting All Contacts
    public List<MDress> getAllDresses() {
        databaseHandler = new DatabaseHandler(context);
        List<MDress> contactList = new ArrayList<MDress>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_DRESS;

        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MDress contact = new MDress();
                contact.set_type((cursor.getString(0)));
                contact.set_image(cursor.getBlob(1));
                contact.set_season(cursor.getString(2));
                contact.set_color(cursor.getString(3));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // Getting contacts Count
    public int getContactsCount() {

        databaseHandler = new DatabaseHandler(context);
        String countQuery = "SELECT  * FROM " + TABLE_DRESS;
        SQLiteDatabase db = databaseHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single contact
    public int updateContact(MDress contact) {

        databaseHandler = new DatabaseHandler(context);
        SQLiteDatabase db = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DRESS_TYPE, contact.get_type());
        values.put(DRESS_IMAGE, contact.get_image());
        values.put(DRESS_SEASON, contact.get_season());
        values.put(DRESS_COLOR, contact.get_color());

        // updating row
        return db.update(TABLE_DRESS, values, DRESS_IMAGE + " = ?",
                new String[]{String.valueOf(contact.get_image())});


    }

    // Deleting single contact
    public void deleteContact(MDress contact) {

        databaseHandler = new DatabaseHandler(context);
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        db.delete(TABLE_DRESS, DRESS_IMAGE + " = ?",
                new String[]{String.valueOf(contact.get_image())});
        db.close();
    }
}
