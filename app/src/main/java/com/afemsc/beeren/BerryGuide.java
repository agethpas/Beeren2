package com.afemsc.beeren;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;


import java.util.Calendar;


public class BerryGuide extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button buttonberryGuideDatepick;

    int day, month, year , displaymonth;
    int dayFinal, monthFinal, yearFinal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berry_guide);




        //button finder
        buttonberryGuideDatepick = (Button) findViewById(R.id.button_guide_datepicker);

        //current date
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        displaymonth = month  +1;
        buttonberryGuideDatepick.setText(day+"."+displaymonth+"."+year+ "(Heute)");




        //Date Picker
        buttonberryGuideDatepick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DatePickerDialog datePickerDialog = new DatePickerDialog(BerryGuide.this, BerryGuide.this, year, month, day);
                datePickerDialog.show();

            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1+1;
        dayFinal = i2;

        buttonberryGuideDatepick.setText(dayFinal+"."+monthFinal+"."+yearFinal);

    }
}
