package com.example.macstudent.styleme;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainPage extends AppCompatActivity {
ImageView img;
Button tkpic, gnrtOf, ofGall, inf, set, brow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        img = (ImageView) findViewById(R.id.imageView);
        Bundle b  = getIntent().getExtras();
        if(b.containsKey("gender")){
            if(b.getString("gender").equals("female")){
                img.setImageResource(R.drawable.girl);
                System.out.println("gender is :   " + (b.getString("gender")));
            }
            else{
                img.setImageResource(R.drawable.boy);
                System.out.println("gender is :   " + (b.getString("gender")));
            }

        }

         tkpic = (Button) findViewById(R.id.btnTakePicture);
         gnrtOf = (Button) findViewById(R.id.btnGenerateOutfit);
         ofGall = (Button) findViewById(R.id.btnOutfitGallery);

         inf = (Button) findViewById(R.id.btnInfo);
         brow = (Button) findViewById(R.id.btnBrowse);

         tkpic.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainPage.this, TakePicture.class);
               startActivity(intent);
             }
         });
         gnrtOf.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent1 = new Intent(MainPage.this, Season.class);
                 startActivity(intent1);
             }
         });
         ofGall.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent2 = new Intent(MainPage.this, DressesCollection.class);
                 startActivity(intent2);
             }
         });

         inf.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent4 = new Intent(MainPage.this, Info.class);
                 startActivity(intent4);
             }
         });
         brow.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent5 = new Intent(MainPage.this, Browse.class);
                 startActivity(intent5);
             }
         });



            }


}
