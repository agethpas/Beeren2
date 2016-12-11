package com.afemsc.beeren;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Pascal on 06.10.2016.
 */


public class BerryDetailActivity extends AppCompatActivity {

    private static String FullscName = "heidelbeere";

    private static String picname = "heidelbeere";

    public static String getFullscName() {
        return FullscName;
    }

    public static String getPicname() {
        return picname;
    }



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

        //sets name or path for Fullscreen activity
        FullscName = (intent.getExtras().getString(BerryDirectory.BERRY_NAME_EXTRA,""));
        picname = (intent.getExtras().getString(BerryDirectory.BERRY_PIC_EXTRA,""));


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

            switch (s) {
                case "r":
                    v.setImageResource(R.drawable.circle_c1);
                    break;
                case "b":
                    v.setImageResource(R.drawable.circle_c2);
                    break;
                case "bl":
                    v.setImageResource(R.drawable.circle_c3);
                    break;
                case "y":
                    v.setImageResource(R.drawable.circle_c4);
                    break;
                case "br":
                    v.setImageResource(R.drawable.circle_c5);
                    break;
                case "g":
                    v.setImageResource(R.drawable.circle_c6);
                    break;
                case "w":
                    v.setImageResource(R.drawable.circle_c7);
                    break;
                default:
                    v.setImageResource(R.drawable.circle_c8);
                    break;
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

        //sets the pictures
        int resId = getResources().getIdentifier(intent.getExtras().getString(BerryDirectory.BERRY_PIC_S_EXTRA,""), "drawable", getPackageName());
        pic.setImageResource(resId);



        //OnClickListener for pic
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),BerryFullscreenActivity.class);
                startActivity(i);
            }
        });







    }




}
