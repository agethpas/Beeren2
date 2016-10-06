package com.afemsc.beeren;

import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


import java.io.IOException;
import java.util.ArrayList;

import static com.afemsc.beeren.R.id.ListBerry;


public class BerryDirectory extends AppCompatActivity {

    private ArrayList<Berry> berries;
    private BerryAdapter berryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berry_directory);

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


        berries = helper.getAllBerries();
        helper.close();

        ListView listv=(ListView)findViewById(ListBerry);

       berryAdapter = new BerryAdapter(this, berries);
       listv.setAdapter(berryAdapter);

    }


    /*
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v, position, id);
        launchNoteDetailActivity(MainActivity.FragmentToLaunch.EDIT,position);
    }
*/

}

