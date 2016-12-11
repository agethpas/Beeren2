package com.afemsc.beeren;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/**
 * Created by Pascal on 06.10.2016.
 */

public class BerryFullscreenActivity extends AppCompatActivity {

    SubsamplingScaleImageView pic_l;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berry_fullscreen);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        String fullscName = BerryDetailActivity.getFullscName();
        setTitle(fullscName);


        //Image View
        pic_l =  (SubsamplingScaleImageView)findViewById(R.id.fullscreen_berry);
        int resId = getResources().getIdentifier(BerryDetailActivity.getPicname(), "drawable", getPackageName());
        pic_l.setImage(ImageSource.resource(resId));


    }




}
