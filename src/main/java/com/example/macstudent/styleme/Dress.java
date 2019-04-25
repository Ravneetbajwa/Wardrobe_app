package com.example.macstudent.styleme;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macstudent.styleme.adapter.DressAdapter;
import com.example.macstudent.styleme.db.helper.DBDress;
import com.example.macstudent.styleme.db.helper.DatabaseHandler;
import com.example.macstudent.styleme.db.model.MDress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dress extends AppCompatActivity {
    Button addImage;
    ArrayList<MDress> imageArry = new ArrayList<MDress>();
    DressAdapter imageAdapter;
    private static final int CAMERA_REQUEST = 1;
    private static final int PICK_FROM_GALLERY = 2;
    ListView dataList;
    byte[] imageName;
    String imageId;
    Bitmap theImage;
    DatabaseHandler db;
    DBDress dbDress;
    TextView style;
    EditText col, seas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         style = (TextView) findViewById(R.id.txtStyle);
         col = (EditText) findViewById(R.id.txtColor);
         seas = (EditText) findViewById(R.id.txtSeason);
        Bundle b  = getIntent().getExtras();
        String Type = b.getString("Type");
        style.setText(Type);

        /**
         * create DatabaseHandler object
         */
        db = new DatabaseHandler(this);
        /**
         * Reading and getting all records from database
         */
        dbDress = new DBDress(this);

    /**
     * open dialog for choose camera/gallery
     */

    final String[] option = new String[]{"Take from Camera"};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.select_dialog_item, option);
    AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Select Option");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Log.e("Selected Item", String.valueOf(which));
                if (which == 0) {
                    callCamera();
                }
                if (which == 1) {
                    callGallery();
                }

            }
        });
        final AlertDialog dialog = builder.create();

        addImage = (Button) findViewById(R.id.btnSave);

        addImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.show();
            }
        });

    }

    /**
     * On activity result
     */
    @SuppressLint("LongLogTag")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK)
            return;

        switch (requestCode) {
            case CAMERA_REQUEST:

                Bundle extras = data.getExtras();

                if (extras != null) {
                    Bitmap yourImage = extras.getParcelable("data");
                    // convert bitmap to byte
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    yourImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte imageInByte[] = stream.toByteArray();
                    Log.e("output before conversion", imageInByte.toString());
                    // Inserting Contacts
                    Log.d("Insert: ", "Inserting ..");
                    String c = col.getText().toString();
                    String t = style.getText().toString();
                    String s = seas.getText().toString();
                    dbDress.addDress(new MDress(c, imageInByte,t,s));
                    Intent i = new Intent(Dress.this,
                            TakePicture.class);

                    startActivity(i);
                    finish();

                }
                break;

        }
    }

    /**
     * open camera method
     */
    public void callCamera() {
        Intent cameraIntent = new Intent(
                android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra("crop", "true");
        cameraIntent.putExtra("aspectX", 0);
        cameraIntent.putExtra("aspectY", 0);
        cameraIntent.putExtra("outputX", 200);
        cameraIntent.putExtra("outputY", 217);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }

    /**
     * open gallery method
     */

    public void callGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 0);
        intent.putExtra("aspectY", 0);
        intent.putExtra("outputX", 200);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(
                Intent.createChooser(intent, "Complete action using"),
                PICK_FROM_GALLERY);

    }

}
