package com.afemsc.beeren;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BerryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berry_detail);

        TextView name = (TextView) findViewById(R.id.namedetail);
        TextView latname = (TextView) findViewById(R.id.lat_namedetail);
        TextView features = (TextView) findViewById(R.id.features);

        Intent intent = this.getIntent();
        name.setText(intent.getExtras().getString(BerryDirectory.BERRY_NAME_EXTRA,""));
        latname.setText(intent.getExtras().getString(BerryDirectory.BERRY_LATNAME_EXTRA,""));
        features.setText(intent.getExtras().getString(BerryDirectory.BERRY_FEATURES_EXTRA,""));


    }





}
