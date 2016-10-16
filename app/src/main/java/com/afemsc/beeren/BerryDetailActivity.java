package com.afemsc.beeren;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BerryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets back button -> view manifest for more info
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berry_detail);


        TextView features = (TextView) findViewById(R.id.features);
        TextView poisonous = (TextView) findViewById(R.id.poisonous_detail);
        ImageView pic = (ImageView) findViewById(R.id.pic_detail);
        ImageView c1 = (ImageView) findViewById(R.id.circle_c1_detail);
        ImageView c2 = (ImageView) findViewById(R.id.circle_c2_detail);
        ImageView c3 = (ImageView) findViewById(R.id.circle_c3_detail);


        //get intent and set it in View
        Intent intent = this.getIntent();
        features.setText(intent.getExtras().getString(BerryDirectory.BERRY_FEATURES_EXTRA,""));


        //Sets name and lat name in AcitionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        setTitle(intent.getExtras().getString(BerryDirectory.BERRY_NAME_EXTRA,""));
        actionBar.setSubtitle(intent.getExtras().getString(BerryDirectory.BERRY_LATNAME_EXTRA,""));


        //sets poisonous
        if(intent.getExtras().getString(BerryDirectory.BERRY_POISONOUS_EXTRA,"").equals("y")){
            poisonous.setText(R.string.poisonous_y);
        }else{
            poisonous.setText(R.string.poisonous_n);
        }

        //set colours
        ImageView v = c1;
        String s = intent.getExtras().getString(BerryDirectory.BERRY_C1_EXTRA,"");

        for (int i = 0; i < 3; i++) {

            if (s.equals("r")) {
                v.setImageResource(R.drawable.circle_c1);
            } else if (s.equals("b")) {
                v.setImageResource(R.drawable.circle_c2);
            } else if (s.equals("bl")) {
                v.setImageResource(R.drawable.circle_c3);
            } else if (s.equals("y")) {
                v.setImageResource(R.drawable.circle_c4);
            } else if (s.equals("br")) {
                v.setImageResource(R.drawable.circle_c5);
            } else if (s.equals("g")) {
                v.setImageResource(R.drawable.circle_c6);
            } else if (s.equals("w")) {
                v.setImageResource(R.drawable.circle_c7);
            } else {
                v.setImageResource(R.drawable.circle_c8);
            }

            //sets ImageView for second loop
            s = intent.getExtras().getString(BerryDirectory.BERRY_C2_EXTRA,"");
            v = c2;

            //sets ImageView for third loop
            if (i > 0) {
                s = intent.getExtras().getString(BerryDirectory.BERRY_C3_EXTRA,"");
                v = c3;
            }
        }




        int resId = getResources().getIdentifier(intent.getExtras().getString(BerryDirectory.BERRY_PIC_S_EXTRA,""), "drawable", getPackageName());
        pic.setImageResource(resId);





    }














}
