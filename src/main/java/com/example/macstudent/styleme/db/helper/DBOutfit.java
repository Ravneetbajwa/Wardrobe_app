package com.example.macstudent.styleme.db.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.macstudent.styleme.db.model.MDress;
import com.example.macstudent.styleme.db.model.MOutfit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DBOutfit {
    static final String TABLE_OUTFIT = "Outfits";

    // Contacts Table Columns names
    static final String OUTFIT_ID = "id";
    static final String OUTFIT_TYPE = "type";
    static final String OUTFIT_IMAGE = "mage";


    private DatabaseHandler databaseHandler;
    private Context context;

    public DBOutfit(Context context) {
        this.context = context;
    }

    // Adding new dress
    public void addOutfit(MOutfit outfit) {
        databaseHandler = new DatabaseHandler(context);

        SQLiteDatabase db = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(OUTFIT_ID, outfit.get_id());
        values.put(OUTFIT_TYPE, outfit.get_type());
        values.put(OUTFIT_IMAGE, outfit.get_image());


        // Inserting Row
        db.insert(TABLE_OUTFIT, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    public MOutfit getOutfit(String type) {
        databaseHandler = new DatabaseHandler(context);
        SQLiteDatabase db = databaseHandler.getReadableDatabase();

        Cursor cursor = db.query(TABLE_OUTFIT, new String[]{OUTFIT_ID,OUTFIT_TYPE,
                        OUTFIT_IMAGE}, OUTFIT_TYPE + "=?",
                new String[] {String.valueOf(type)}, null, null, "RANDOM()", "1");
        if (cursor != null)
            cursor.moveToFirst();

        MOutfit outfit = new MOutfit(Integer.parseInt(cursor.getString(0)),cursor.getString(1),
                cursor.getBlob(2));
        // return contact
        return outfit;
    }

    // Getting All Contacts
    public List<MOutfit> getAllOutfits() {
        databaseHandler = new DatabaseHandler(context);
        List<MOutfit> contactList = new ArrayList<MOutfit>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_OUTFIT ;

        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MOutfit contact = new MOutfit();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.set_type(cursor.getString(1));
                contact.set_image(cursor.getBlob(2));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // Getting contacts Count
    public int getOutfitCount() {

        databaseHandler = new DatabaseHandler(context);
        String countQuery = "SELECT  * FROM " + TABLE_OUTFIT;
        SQLiteDatabase db = databaseHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single contact
    public int updateOutfit(MOutfit contact) {

        databaseHandler = new DatabaseHandler(context);
        SQLiteDatabase db = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(OUTFIT_ID, contact.get_id());
        values.put(OUTFIT_TYPE, contact.get_type());
        values.put(OUTFIT_IMAGE, contact.get_image());


        // updating row
        return db.update(TABLE_OUTFIT, values, OUTFIT_ID + " = ?",
                new String[]{String.valueOf(contact.get_id())});


    }

    // Deleting single contact
    public void deleteOutfit(MOutfit contact) {

        databaseHandler = new DatabaseHandler(context);
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        db.delete(TABLE_OUTFIT, OUTFIT_ID + " = ?",
                new String[]{String.valueOf(contact.get_id())});
        db.close();
    }
}
