package com.afemsc.beeren;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by Pascal on 06.10.2016.
 */

public class BerryAdapter extends ArrayAdapter<Berry>{




    public static class ViewHolder{
        TextView name;
        TextView lat_name;
        TextView poison;
        ImageView pic;
        ImageView c1;
        ImageView c2;
        ImageView c3;
        ImageView v;


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
            viewHolder.c1 = (ImageView) convertView.findViewById(R.id.circle_c1);
            viewHolder.c2 = (ImageView) convertView.findViewById(R.id.circle_c2);
            viewHolder.c3 = (ImageView) convertView.findViewById(R.id.circle_c3);

            // Use set tag to remember our viewholder which is holding reference
            convertView.setTag(viewHolder);
        }else{
            //we already have a view so just go to viewholder and grab widgets from it
            viewHolder = (ViewHolder) convertView.getTag();

        }

        // Populate the data into template view using the data object
        viewHolder.name.setText(berry.getName());
        viewHolder.lat_name.setText(berry.getLatname());

        //Sets the poisonous value
        if(berry.getPoisonous().equals("y")){
            viewHolder.poison.setText(R.string.poisonous_y);
        }else{
            viewHolder.poison.setText(R.string.poisonous_n);
        }

        //Sets the colours in the list row

        //instantiate values for loop last if set's transparent circle if no colour is in db
        viewHolder.v = viewHolder.c1;
        String c = berry.getC1();

        for (int i = 0; i < 3; i++) {

            if (c.equals("r")) {
                viewHolder.v.setImageResource(R.drawable.circle_c1);
            } else if (c.equals("b")) {
                viewHolder.v.setImageResource(R.drawable.circle_c2);
            } else if (c.equals("bl")) {
                viewHolder.v.setImageResource(R.drawable.circle_c3);
            } else if (c.equals("y")) {
                viewHolder.v.setImageResource(R.drawable.circle_c4);
            } else if (c.equals("br")) {
                viewHolder.v.setImageResource(R.drawable.circle_c5);
            } else if (c.equals("g")) {
                viewHolder.v.setImageResource(R.drawable.circle_c6);
            } else if (c.equals("w")) {
                viewHolder.v.setImageResource(R.drawable.circle_c7);
            } else {
                viewHolder.v.setImageResource(R.drawable.circle_c8);
            }

            //sets viewholder for second loop
            c = berry.getC2();
            viewHolder.v = viewHolder.c2;

            //sets viewHolder for third loop
            if (i > 0) {
                c = berry.getC3();
                viewHolder.v = viewHolder.c3;
            }
        }

        int resId = getContext().getResources().getIdentifier(berry.getPic_s() ,"drawable", "com.afemsc.beeren");
        viewHolder.pic.setImageResource(resId);

        //return the data to display
        return convertView;


    }




}
