 package com.example.macstudent.styleme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

 public class MainActivity extends AppCompatActivity {


    ImageButton male, female;
    Button next;
     SharedPreferences myPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPref = getSharedPreferences("mypref",MODE_PRIVATE);

        male = (ImageButton) findViewById(R.id.btnMale);
        female = (ImageButton) findViewById(R.id.btnFemale);

        final String gender = myPref.getString("gender",null);


        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainPage.class);
                intent.putExtra("gender", "female");
                startActivity(intent);
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainPage.class);
                intent.putExtra("gender", "male");
                startActivity(intent);
            }
        });

    }
}
