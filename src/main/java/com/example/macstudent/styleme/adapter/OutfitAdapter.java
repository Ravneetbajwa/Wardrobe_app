package com.example.macstudent.styleme.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macstudent.styleme.R;
import com.example.macstudent.styleme.db.model.MOutfit;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class OutfitAdapter extends ArrayAdapter <MOutfit>
{
public OutfitAdapter(Context context, MOutfit contactArrayList)
        {
        super(context, 0, (List<MOutfit>) contactArrayList);
        }

@Override
public View getView(int position, View convertView, ViewGroup parent)
        {
        // Get the data item for this position
        MOutfit contact = getItem(position);
        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
        {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_color, parent, false);
        viewHolder = new ViewHolder(convertView);
        convertView.setTag(viewHolder);
        }
        else
        {
        viewHolder = (ViewHolder)convertView.getTag();
        }

        // Populate the data into the template view using the data object

        byte[] outImage=contact._image;
        ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        viewHolder.tvContactID2.setImageBitmap(theImage);
        viewHolder.tvContactID.setImageBitmap(theImage);
        viewHolder.tvContactID1.setImageBitmap(theImage);
        viewHolder.tvContactName.setImageBitmap(theImage);


        return convertView;
        }

private class ViewHolder
{
    ImageView tvContactID;
    ImageView tvContactName;
    ImageView tvContactID1;
    ImageView tvContactID2;

    ViewHolder(View convertView)
    {
//    {
//        tvContactID = (ImageView) convertView.findViewById(R.id.imgUpper);
//        tvContactName = (ImageView) convertView.findViewById(R.id.imgLower);
//        tvContactID1 = (ImageView) convertView.findViewById(R.id.imgShoes);
//        tvContactID2 = (ImageView) convertView.findViewById(R.id.imgAccess);
    }
}
}