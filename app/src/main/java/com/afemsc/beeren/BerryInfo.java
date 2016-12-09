package com.afemsc.beeren;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BerryInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets back button -> view manifest for more info
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berry_info);
    }
}
