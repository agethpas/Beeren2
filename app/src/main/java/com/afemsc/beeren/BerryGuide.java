package com.afemsc.beeren;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.Calendar;
import petrov.kristiyan.colorpicker.ColorPicker;


public class BerryGuide extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {

    Button buttonberryGuideDatepick;
    Button buttonberryGuideColourpick;

    int day, month, year , displaymonth;
    int dayFinal, monthFinal, yearFinal;

    String[] formNames={"Round","Egg","Oval","Heart","Small Round"};
    int forms[] = {R.drawable.form_1_rund, R.drawable.form_2_elipse, R.drawable.form_3_elipse2, R.drawable.form_4_herz, R.drawable.form_5_runde};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berry_guide);

        //button finder
        buttonberryGuideDatepick = (Button) findViewById(R.id.button_guide_datepicker);
        buttonberryGuideColourpick  = (Button) findViewById(R.id.button_guide_colourpicker);

        //spinner
        Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);
        spin.setOnItemSelectedListener(this);
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),forms,formNames);
        spin.setAdapter(customAdapter);

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

        // für gewählte Farben gleich vorgehen wie bei der Detail ansicht die runden Punkte einfügen je nach dem was gewählt wurde.
        // colour picker
        buttonberryGuideColourpick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final ColorPicker colorPicker = new ColorPicker(BerryGuide.this);
                colorPicker.setColors(R.array.berrycolours);
                colorPicker.setDefaultColorButton(Color.parseColor("#0000FF")).setColumns(5).setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
                        Log.d("position",""+position);// will be fired only when OK button was tapped
                    }

                    @Override
                    public void onCancel() {

                    }
                }).setRoundColorButton(true).show();
            }

        });



    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
       // Toast.makeText(getApplicationContext(), formNames[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1+1;
        dayFinal = i2;

        buttonberryGuideDatepick.setText(dayFinal+"."+monthFinal+"."+yearFinal);

    }


}
