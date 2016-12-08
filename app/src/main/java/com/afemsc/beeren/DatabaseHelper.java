package com.afemsc.beeren;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.BitmapFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by aget on 06.10.2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    //The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/com.afemsc.beeren/databases/";
    private static String DB_NAME = "berryDB_xpp.db";
    private SQLiteDatabase myDataBase;
    private final Context myContext;
    public static final String TABLE_NAME = "berries";


    private String[] allColumns = {"_id","name","lat_name","c1","c2","c3","features","poisonous","form,pic,pic_s,size_min,size_max,vegetation,spring,summer,autumn,winter"};


    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DatabaseHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException{

        boolean dbExist = checkDataBase();

        if(dbExist){
            //do nothing - database already exist
        }else{
            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){
            //database does't exist yet.
        }

        if(checkDB != null){
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{

        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {
        if(myDataBase != null)
            myDataBase.close();
        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    // Add your public helper methods to access and get content from the database.
    // You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
    // to you to create adapters for your views.


    public ArrayList<Berry> getAllBerries(){
        ArrayList<Berry> berries = new ArrayList<Berry>();


            //grab all of the information in our database for the notes in it
            Cursor cursor = myDataBase.query(TABLE_NAME, allColumns, null , null, null, null, "name DESC");

            for (cursor.moveToLast(); !cursor.isBeforeFirst(); cursor.moveToPrevious()) {
                Berry berry = cursorToBerry(cursor);
                berries.add(berry);
            }

            //close our cursor required
            cursor.close();

        //return arrayList now filled with database notes or notes in our database
        return berries;
    }

    //TODO Where statement ist noch incomplete
    public ArrayList<Berry> getGuidedBerries(){
        ArrayList<Berry> berries = new ArrayList<Berry>();
        String colour = BerryGuide.getColourguide();
        int season = BerryGuide.getSeason();
        String where = "(c1 = '"+colour+"' OR c2 = '"+colour+ "' OR c3 = '"+ colour+"') AND (spring = "+season+
                " OR summer = "+season+" OR autumn = "+season+ " OR winter = "+ season+" )";
        Cursor cursor = myDataBase.query(TABLE_NAME, allColumns,where, null, null, null, "name DESC");



        for (cursor.moveToLast(); !cursor.isBeforeFirst(); cursor.moveToPrevious()) {
            Berry berry = cursorToBerry(cursor);
            berries.add(berry);
        }

        //close our cursor required
        cursor.close();

        //return arrayList now filled with database notes or notes in our database
        return berries;

    }



    //give a cursor returns a berry object
    private Berry cursorToBerry(Cursor cursor){
        Berry newBerry = new Berry ( cursor.getInt(0),cursor.getString(1),
                cursor.getString(2), cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),
                cursor.getString(7),cursor.getInt(8),cursor.getString(9), cursor.getString(10), cursor.getDouble(11),cursor.getDouble(12),
                cursor.getString(13),cursor.getInt(14),cursor.getInt(15),cursor.getInt(16),cursor.getInt(17));


        return newBerry;
    }






}