package com.example.macstudent.styleme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Season extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season);
        final String[] seasons = {"Summer","Winter","Autumn","Spring"};
        Bundle extras = getIntent().getExtras();
       // final String list = extras.getString("Type");
     //   final String colors = extras.getString("Color");
        final ListView listView1 = (ListView) findViewById(R.id.listSeason);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.activity_list_view,R.id.textView,seasons);
        listView1.setAdapter(adapter1);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String result = (String) listView1.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Season.this, Generate_Outfit.class);
               // intent.putExtra("Color",colors);
               // intent.putExtra("Type", list);
                intent.putExtra("Season", result);
                startActivity(intent);
            }
        });

    }
}
