package com.afemsc.beeren;

import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import static com.afemsc.beeren.R.id.ListBerry;
import static com.afemsc.beeren.R.id.ListBerryGuideResult;

public class BerryGuideResult extends AppCompatActivity {


    private ArrayList<Berry> berries;
    private BerryAdapter berryAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
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























    }
}
