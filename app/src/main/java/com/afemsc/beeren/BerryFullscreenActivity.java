package com.afemsc.beeren;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class BerryFullscreenActivity extends AppCompatActivity {

    SubsamplingScaleImageView pic_l;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berry_fullscreen);


        //Image View
        pic_l =  (SubsamplingScaleImageView)findViewById(R.id.fullscreen_berry);


        pic_l.setImage(ImageSource.resource(R.drawable.heidelbeere));



    }




}
