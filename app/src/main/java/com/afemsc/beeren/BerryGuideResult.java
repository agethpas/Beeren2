package com.afemsc.beeren;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import static com.afemsc.beeren.R.id.ListBerry;
import static com.afemsc.beeren.R.id.ListBerryGuideResult;

/**
 * Created by Pascal on 06.10.2016.
 */


public class BerryGuideResult extends AppCompatActivity {


    private ArrayList<Berry> berries;
    private BerryAdapter berryAdapter;


    public static final String BERRY_ID_EXTRA = "com.afemsc.beeren.Identifier";
    public static final String BERRY_NAME_EXTRA = "com.afemsc.beeren.Name";
    public static final String BERRY_LATNAME_EXTRA = "com.afemsc.beeren.Latname";
    public static final String BERRY_FEATURES_EXTRA = "com.afemsc.beeren.Features";
    public static final String BERRY_PIC_S_EXTRA ="com.afemsc.beeren.Pic_s";
    public static final String BERRY_PIC_EXTRA ="com.afemsc.beeren.Pic";
    public static final String BERRY_POISONOUS_EXTRA ="com.afemsc.beeren.Poisonous";
    public static final String BERRY_C1_EXTRA ="com.afemsc.beeren.C1";
    public static final String BERRY_C2_EXTRA ="com.afemsc.beeren.C2";
    public static final String BERRY_C3_EXTRA ="com.afemsc.beeren.C3";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets back button -> view manifest for more info
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berry_guide_result);




        DatabaseHelper helper = new DatabaseHelper(this);
        try {
            helper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            helper.openDataBase();
        }catch(SQLException sqle){
            throw sqle;
        }


        berries = helper.getGuidedBerries();
        helper.close();

        ListView listv=(ListView)findViewById(ListBerryGuideResult);

        berryAdapter = new BerryAdapter(this, berries);
        listv.setAdapter(berryAdapter);




        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(BerryGuideResult.this, BerryDetailActivity.class);
                Berry berry = (Berry) parent.getItemAtPosition(position);
                intent.putExtra(BerryDirectory.BERRY_NAME_EXTRA, berry.getName());
                intent.putExtra(BerryDirectory.BERRY_LATNAME_EXTRA, berry.getLatname());
                intent.putExtra(BerryDirectory.BERRY_FEATURES_EXTRA, berry.getFeatures());
                intent.putExtra(BerryDirectory.BERRY_ID_EXTRA, berry.getId());
                intent.putExtra(BerryDirectory.BERRY_PIC_S_EXTRA,berry.getPic_s());
                intent.putExtra(BerryDirectory.BERRY_PIC_EXTRA,berry.getPic());
                intent.putExtra(BerryDirectory.BERRY_POISONOUS_EXTRA,berry.getPoisonous());
                intent.putExtra(BerryDirectory.BERRY_C1_EXTRA,berry.getC1());
                intent.putExtra(BerryDirectory.BERRY_C2_EXTRA,berry.getC2());
                intent.putExtra(BerryDirectory.BERRY_C3_EXTRA,berry.getC3());
                startActivity(intent);
            }
        });


















    }
}
