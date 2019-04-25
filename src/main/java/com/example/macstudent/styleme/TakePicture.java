package com.example.macstudent.styleme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.macstudent.styleme.db.helper.DBDress;

public class TakePicture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String[] UpperBodyWomen = new String[] {"Blazer","Short Sleeve Shirt","Long Sleeve Shirt","Tank Top",
                "Coat","Hoodie","Sweat Shirt","Trench","Sweater","T-Shirt","Top"};
        String[] LowerBodyWomen = {"Shorts","Long Skirt","Leggins","Short Skirt",
                "Capri","Denim","Pants"};
        String[] ShoesWomen = {"Flat","Flip Flop","Sandals","Sneakers",
                "Heels","Boots"};
        String[] AccessoriesWomen = {"Cap","Bag","Belt","Tie",
                "Umbrella","Scarf","Gloves"};
        final ListView listView1 = (ListView) findViewById(R.id.list_Upper);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.activity_list_view,R.id.textView,UpperBodyWomen);
        listView1.setAdapter(adapter1);

        ArrayAdapter adapter2 = new ArrayAdapter<String>(this,
                R.layout.activity_list_view,R.id.textView, LowerBodyWomen);
        ListView listView2 = (ListView) findViewById(R.id.list_Lower);
        listView2.setAdapter(adapter2);

        ArrayAdapter adapter3 = new ArrayAdapter<String>(this,
                R.layout.activity_list_view,R.id.textView, ShoesWomen);
        ListView listView3 = (ListView) findViewById(R.id.list_Shoes);
        listView3.setAdapter(adapter3);

        ArrayAdapter adapter4 = new ArrayAdapter<String>(this,
                R.layout.activity_list_view,R.id.textView, AccessoriesWomen);
        ListView listView4 = (ListView) findViewById(R.id.list_Accessories);
        listView4.setAdapter(adapter4);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String result = (String) listView1.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TakePicture.this, Dress.class);
                intent.putExtra("Type","Upper Body");
                startActivity(intent);
            }
        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String result = (String) listView1.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TakePicture.this, Dress.class);
                intent.putExtra("Type","Lower Body");
                startActivity(intent);
            }
        });

        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String result = (String) listView1.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TakePicture.this, Dress.class);
                intent.putExtra("Type","Shoes");
                startActivity(intent);
            }
        });

        listView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String result = (String) listView1.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TakePicture.this, Dress.class);
                intent.putExtra("Type","Accessories");
                startActivity(intent);
            }
        });

    }

}
