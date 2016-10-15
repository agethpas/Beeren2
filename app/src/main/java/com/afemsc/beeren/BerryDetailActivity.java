package com.afemsc.beeren;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BerryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets back button -> view manifest for more info
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berry_detail);

        TextView name = (TextView) findViewById(R.id.namedetail);
        TextView latname = (TextView) findViewById(R.id.lat_namedetail);
        TextView features = (TextView) findViewById(R.id.features);
        TextView poisonous = (TextView) findViewById(R.id.poisonous_detail);
        ImageView pic = (ImageView) findViewById(R.id.pic_detail);


        Intent intent = this.getIntent();
        name.setText(intent.getExtras().getString(BerryDirectory.BERRY_NAME_EXTRA,""));
        latname.setText(intent.getExtras().getString(BerryDirectory.BERRY_LATNAME_EXTRA,""));
        features.setText(intent.getExtras().getString(BerryDirectory.BERRY_FEATURES_EXTRA,""));
        //poisonous.setText(intent.getExtras().getString(BerryDirectory.BERRY_POISONOUS,""));


        if(intent.getExtras().getString(BerryDirectory.BERRY_POISONOUS,"").equals("y")){
            poisonous.setText(R.string.poisonous_y);
        }else{
            poisonous.setText(R.string.poisonous_n);
        }

        //pic.setImageResource(R.drawable.berberitze_s);


    }





}
