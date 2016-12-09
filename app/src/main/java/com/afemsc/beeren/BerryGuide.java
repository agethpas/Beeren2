package com.afemsc.beeren;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import petrov.kristiyan.colorpicker.ColorPicker;



public class BerryGuide extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {

    Button buttonberryGuideDatepick;
    Button buttonberryGuideColourpick;
    Button buttonGuideResult;
    SeekBar seekbarberry;
    TextView textberrysize;




    //criteria
    static String  colourguide;
    static int season;
    static double size;
    static int form;




    //Getter
    public static String getColourguide() {
        return colourguide;
    }

    public static int getSeason() {
        return season;
    }

    public static double getSize() {
        return size;
    }

    public static int getForm() {
        return form;
    }

    //Setter
    public static void setColourguide(String colourguide) {
        BerryGuide.colourguide = colourguide;
    }

    public static void setSeason(int season) {
        BerryGuide.season = season;
    }

    public static void setSize(double size) {
        BerryGuide.size = size;
    }

    public static void setForm(int form) {
        BerryGuide.form = form;
    }


    //DatePicker
    int day, month, year , displaymonth;
    int dayFinal, monthFinal, yearFinal;

    //Forms
    String[] formNames={"Round","Egg","Oval","Heart","Small Round"};
    int forms[] = {R.drawable.form_1_rund, R.drawable.form_2_elipse, R.drawable.form_3_elipse2, R.drawable.form_4_herz, R.drawable.form_5_runde};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets back button -> view manifest for more info
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berry_guide);

        //Database
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





        // Size seekbar and text
        seekbarberry = (SeekBar) findViewById(R.id.seekBarBerrySize);
        textberrysize = (TextView) findViewById(R.id.textBerrySize);


        //button finder
        buttonberryGuideDatepick = (Button) findViewById(R.id.button_guide_datepicker);
        buttonberryGuideColourpick  = (Button) findViewById(R.id.button_guide_colourpicker);
        buttonGuideResult = (Button) findViewById(R.id.button_guide_result);

        //Result

        buttonGuideResult.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //
                Intent i = new Intent(getApplicationContext(),BerryGuideResult.class);
                startActivity(i);
            }
        });

        //colour picker imageview for bubble
        final ImageView imageviewpickedcolour = (ImageView) findViewById(R.id.circle_colour_pick);

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



        //initialize Berry size SeekBar
        textberrysize.setText("Grösse: " + seekbarberry.getProgress() +" cm");
        seekbarberry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            double progress = 0;

            //Seekbar
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = (seekbarberry.getProgress()*0.01)*10;
                String BerrySize = String.valueOf((double)Math.round(progress*10d)/10);
                textberrysize.setText("Grösse: "+ BerrySize+" cm");

                //TODO this size
                 setSize(Math.round((progress*10d)/10));


            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String BerrySize = String.valueOf((double)Math.round(progress*10d)/10);
                textberrysize.setText("Grösse: "+ BerrySize+" cm");
            }
        });


        //Date Picker
        buttonberryGuideDatepick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DatePickerDialog datePickerDialog = new DatePickerDialog(BerryGuide.this, BerryGuide.this, year, month, day);
                datePickerDialog.show();

            }
        });


        // colour picker
        buttonberryGuideColourpick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final ColorPicker colorPicker = new ColorPicker(BerryGuide.this);
                colorPicker.setColors(R.array.berrycolours);
                colorPicker.setColumns(5).setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
                        Log.d("position",""+position);// When ok is pressed

                        if (position == 0){
                            imageviewpickedcolour.setImageResource(R.drawable.circle_c1);
                            setColourguide("r");
                        } else if (position == 1){
                            imageviewpickedcolour.setImageResource(R.drawable.circle_c2);
                            setColourguide("b");
                        }else if (position == 2){
                            imageviewpickedcolour.setImageResource(R.drawable.circle_c3);
                            setColourguide("bl");
                        }else if (position == 3){
                            imageviewpickedcolour.setImageResource(R.drawable.circle_c4);
                            setColourguide("y");
                        }else if (position == 4){
                            imageviewpickedcolour.setImageResource(R.drawable.circle_c5);
                            setColourguide("br");
                        }else if (position == 5){
                            imageviewpickedcolour.setImageResource(R.drawable.circle_c6);
                            setColourguide("g");
                        }else if (position == 6){
                            imageviewpickedcolour.setImageResource(R.drawable.circle_c7);
                            setColourguide("w");
                        }
                    }

                    @Override
                    public void onCancel() {

                    }
                }).setRoundColorButton(true).show();
            }

        });

    }



    //Spinner action onItemSelected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
       setForm(position+1);
         //Toast.makeText(getApplicationContext(), position, Toast.LENGTH_LONG).show();
    }

    //Spinner action onNothingSelected
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    // Datepicker user input
    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1+1;
        dayFinal = i2;

        buttonberryGuideDatepick.setText(dayFinal+"."+monthFinal+"."+yearFinal);
        if(monthFinal>=4 && monthFinal<=6){
            setSeason(1);
        } else if(monthFinal>=6  && monthFinal <=8){
            setSeason(2);
        }else if (monthFinal>=8 && monthFinal <=9){
            setSeason(3);
        }else if (monthFinal>=10 && monthFinal <=3){
            setSeason(4);
        }



    }




}
