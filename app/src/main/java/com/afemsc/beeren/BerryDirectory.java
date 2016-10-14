package com.afemsc.beeren;

import android.content.Intent;
import android.database.SQLException;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.io.IOException;
import java.util.ArrayList;


import static com.afemsc.beeren.R.id.ListBerry;





public class BerryDirectory extends AppCompatActivity  implements SearchView.OnQueryTextListener{

    private ArrayList<Berry> berries;
    private BerryAdapter berryAdapter;

    public static final String BERRY_ID_EXTRA = "com.afemsc.beeren.Identifier";
    public static final String BERRY_NAME_EXTRA = "com.afemsc.beeren.Name";
    public static final String BERRY_LATNAME_EXTRA = "com.afemsc.beeren.Latname";
    public static final String BERRY_FEATURES_EXTRA = "com.afemsc.beeren.Features";




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



        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(BerryDirectory.this, BerryDetailActivity.class);
                Berry berry = (Berry) parent.getItemAtPosition(position);
                intent.putExtra(BerryDirectory.BERRY_NAME_EXTRA, berry.getName());
                intent.putExtra(BerryDirectory.BERRY_LATNAME_EXTRA, berry.getLatname());
                intent.putExtra(BerryDirectory.BERRY_FEATURES_EXTRA, berry.getFeatures());
                intent.putExtra(BerryDirectory.BERRY_ID_EXTRA, berry.getId());
                startActivity(intent);
            }
        });



        //sets back button -> view manifest for more info
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // User pressed the search button
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // User changed the text
        berryAdapter.getFilter().filter(newText);
        return false;
    }

}

