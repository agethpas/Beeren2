package com.afemsc.beeren;

import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        String[] items={"Testi","Testp","Testl","Testj","Testi","Testp","Testl","Testj","Testi","Testp","Testl","Testj","Testi",
                "Testp","Testl"};

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


/*
       // ListView listv=(ListView)findViewById(ListBerry);
        ArrayAdapter<Berry> adapter = new ArrayAdapter<Berry>(this,R.layout.list_row,R.id.txt,berryArray);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(new ItemList());
*/

        /* OLD for items
        ListView listv=(ListView)findViewById(R.id.ListBerry);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_row,R.id.txt,items);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(new ItemList());

        */

    }



    class ItemList implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            ViewGroup vg=(ViewGroup) view;
            TextView tv=(TextView) vg.findViewById(R.id.txt);
            Toast.makeText(BerryDirectory.this, tv.getText().toString(),Toast.LENGTH_SHORT).show();
        }
    }



}

