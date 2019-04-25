package com.example.macstudent.styleme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.macstudent.styleme.adapter.DressAdapter;
import com.example.macstudent.styleme.db.helper.DBDress;
import com.example.macstudent.styleme.db.model.MDress;

import java.util.ArrayList;

public class DressesCollection extends AppCompatActivity {
    DressAdapter contactAdapter;
    ListView lstContact;
    ArrayList<MDress> contactList;

    public static void startIntent(Context context)
    {
        context.startActivity(new Intent(context,DressesCollection.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dresses_collection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstContact = (ListView)findViewById(R.id.list_dresses);

        DBDress dbContact = new DBDress(this);

        contactList = (ArrayList<MDress>) dbContact.getAllDresses();

        contactAdapter = new DressAdapter(this,contactList);
        lstContact.setAdapter(contactAdapter);

        lstContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MDress e = contactList.get(i);
            }
        });
    }

}
