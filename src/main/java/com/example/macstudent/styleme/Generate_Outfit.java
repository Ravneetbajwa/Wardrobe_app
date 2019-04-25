package com.example.macstudent.styleme;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.macstudent.styleme.adapter.DressAdapter;
import com.example.macstudent.styleme.adapter.OutfitAdapter;
import com.example.macstudent.styleme.db.helper.DBDress;
import com.example.macstudent.styleme.db.helper.DBOutfit;
import com.example.macstudent.styleme.db.helper.DatabaseHandler;
import com.example.macstudent.styleme.db.model.MDress;
import com.example.macstudent.styleme.db.model.MOutfit;
import com.example.macstudent.styleme.db.model.Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Generate_Outfit extends AppCompatActivity {
    private static final String TAG ="Generate_Outfit" ;
    OutfitAdapter contactAdapter;
    ImageView lstContact;
    MDress contactList;
    //DBDress dbDress;
    DatabaseHandler dbHAndler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate__outfit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lstContact = (ImageView)findViewById(R.id.imgUpper);
        ImageView lower = (ImageView) findViewById(R.id.imgLower);
        ImageView shoes = (ImageView) findViewById(R.id.imgShoes);
        ImageView accessories = (ImageView) findViewById(R.id.imgAccess);
        Bundle b  = getIntent().getExtras();
        String Season = b.getString("Season");
        DBDress dbContact = new DBDress(this);
        byte[] bytes = dbContact.retreiveImageFromDB("Upper Body", Season);
        lstContact.setImageBitmap(Utils.getImage(bytes));
        byte[] bytes1 = dbContact.retreiveImageFromDB("Shoes", Season);
        shoes.setImageBitmap(Utils.getImage(bytes1));
        byte[] bytes2 = dbContact.retreiveImageFromDB("Lower Body",Season);
        lower.setImageBitmap(Utils.getImage(bytes2));
        byte[] bytes3 = dbContact.retreiveImageFromDB("Accessories",Season);
        accessories.setImageBitmap(Utils.getImage(bytes3));

    }

//    Boolean loadImageFromDB() {
//        try {
//    //dbHAndler.open();
//            byte[] bytes = dbDress.retreiveImageFromDB("Accessories");
//            System.out.println("****************" + bytes);
//           //dbHAndler.close();
//            // Show Image from DB in ImageView
//            lstContact = (ImageView)findViewById(R.id.imgUpper);
//            lstContact.setImageBitmap(Utils.getImage(bytes));
//
//            return true;
//        } catch (Exception e) {
//            Log.e(TAG, "<loadImageFromDB> Error : " + e);
//            //dbHAndler.close();
//            return false;
//        }
//    }

}
