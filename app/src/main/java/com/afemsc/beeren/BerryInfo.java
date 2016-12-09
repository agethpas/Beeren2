package com.afemsc.beeren;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BerryInfo extends AppCompatActivity {


    TextView infocall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets back button -> view manifest for more info
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berry_info);

        infocall=(TextView) findViewById(R.id.info2);
        infocall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:145"));
                startActivity(callIntent);
            }
        });



    }
}
