package com.afemsc.beeren;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BerryDirectory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berry_directory);
        String[] items={"Testi","Testp","Testl","Testj","Testi","Testp","Testl","Testj","Testi","Testp","Testl","Testj","Testi",
                "Testp","Testl"};
        ListView listv=(ListView)findViewById(R.id.ListBerry);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_row,R.id.txt,items);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(new ItemList());





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

