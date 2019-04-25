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

import com.example.macstudent.styleme.Dress;
import com.example.macstudent.styleme.R;
import com.example.macstudent.styleme.db.helper.DBDress;
import com.example.macstudent.styleme.db.model.MDress;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class DressAdapter extends ArrayAdapter<MDress>
{
    public DressAdapter(Context context, ArrayList<MDress> contactArrayList)
    {
        super(context, 0, contactArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        MDress contact = getItem(position);
        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.tvContactID.setText(String.valueOf(contact.get_type()));
        viewHolder.tvContactName.setText(contact.get_color());
        viewHolder.tvContactID1.setText(contact.get_season());
        byte[] outImage=contact._image;
        ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        viewHolder.tvContactID2.setImageBitmap(theImage);


        return convertView;
    }

    private class ViewHolder
    {
        TextView tvContactID;
        TextView tvContactName;
        TextView tvContactID1;
        ImageView tvContactID2;

        ViewHolder(View convertView)
        {
            tvContactID = (TextView) convertView.findViewById(R.id.txtDressType);
            tvContactName = (TextView) convertView.findViewById(R.id.txtDressColor);
            tvContactID1 = (TextView) convertView.findViewById(R.id.txtDressSeason);
            tvContactID2 = (ImageView) convertView.findViewById(R.id.imgContact);
        }
    }
}
