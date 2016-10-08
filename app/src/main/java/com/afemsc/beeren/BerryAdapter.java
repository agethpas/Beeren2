package com.afemsc.beeren;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by aget on 06.10.2016.
 */

public class BerryAdapter extends ArrayAdapter<Berry>{


    public static class ViewHolder{
        TextView name;
        TextView lat_name;
        TextView poison;
        ImageView pic;

    }

    public BerryAdapter(Context context, ArrayList<Berry> berryArrayList){
        super(context, 0, berryArrayList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Get the date Item for this position
        Berry berry = getItem(position);

        // create new Viewholder
        ViewHolder viewHolder;

        // Check if an existing vie is being reused, otherwise inflate a new view from costum row layout
        if (convertView == null) {

            // create view if not view beeing used and save viewreference in the viewholder
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);

            // set views to viewholder to not go back and use find by id every time by new row
            viewHolder.name = (TextView) convertView.findViewById(R.id.txt);
            viewHolder.lat_name = (TextView) convertView.findViewById(R.id.lat_name);
            viewHolder.poison = (TextView) convertView.findViewById(R.id.poisonous);
            viewHolder.pic = (ImageView) convertView.findViewById(R.id.pic);


            // Use set tag to remember our viewholder which is holding reference
            convertView.setTag(viewHolder);
        }else{
            //we already have a view so just go to viewholder and grab widgets from it
            viewHolder = (ViewHolder) convertView.getTag();

        }

        // Populate the data into template view using the data object
        viewHolder.name.setText(berry.getName());
        viewHolder.lat_name.setText(berry.getLatname());
        viewHolder.poison.setText(berry.getPoisonous());
        //get picture



           // Uri imageUri = Uri.parse(berry.getPic());


           // viewHolder.pic.setImageResource(Integer.parseInt((berry.getPic())));



/*
        byte[] picture = berry.getPic();
        viewHolder.pic.setImageBitmap(BitmapFactory.decodeByteArray(picture, 0, picture.length));
*/

        //return the data to display
        return convertView;


    }




}
