package com.example.matthew.qubapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Matthew on 12/08/2015.
 */
public class BeaconTable extends SQLiteOpenHelper {

    private static BeaconTable instance = null;

    public static final String DATABASE_NAME = "BeaconTable.db";

    //Beacon Table
    public static final String TABLE_NAME_BEACON = "beacon_table";
    public static final String BEACON_ID = "_id";
    public static final String BEACON_UUID = "UUID";
    public static final String BEACON_MAJOR = "MAJOR";
    public static final String BEACON_MINOR = "MINOR";
    public static final String BEACON_TIMESTAMP = "TIMESTAMP";
    //public static final long BEACON_TIME_PERIOD = System.currentTimeMillis()/1000 - 30;


    private static final String TAG = BeaconTable.class.getSimpleName();

    public SQLiteDatabase db;

    public static synchronized BeaconTable getInstance(Context context){
        if (instance == null){
            instance = new BeaconTable(context.getApplicationContext());
        }

        return instance;
    }

    private BeaconTable(Context context) {
        super(context, DATABASE_NAME, null, 2);

        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME_BEACON + " (_id INTEGER PRIMARY KEY, UUID TEXT, MAJOR TEXT, MINOR TEXT, TIMESTAMP TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_BEACON);

        onCreate(db);

    }

    public boolean beaconQueryDatabase(String UUID, int major, int minor) {

        db = this.getReadableDatabase();
        String query = "SELECT " + BEACON_UUID + " FROM " + TABLE_NAME_BEACON + " WHERE "
                + BEACON_UUID + "= '" + UUID + "' AND "
                + BEACON_MAJOR + "= '" + major + "' AND "
                + BEACON_MINOR + "= '" + minor + "'";

        Cursor cs = db.rawQuery(query, null);
        cs.moveToFirst();
        Log.d(TAG, "Cursor count: " + cs.getCount());

        if(cs.getCount()> 0) {
            return true;
        }else{
            return false;
        }

    }

    public void insertBeacon(String UUID, int major, int minor, long timestamp){

        db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(BEACON_UUID, UUID);
        contentValues.put(BEACON_MAJOR, major);
        contentValues.put(BEACON_MINOR, minor);
        contentValues.put(BEACON_TIMESTAMP, timestamp);
        db.insert(TABLE_NAME_BEACON, null, contentValues);
    }

    public long getTimestamp(String UUID, int major, int minor){

        long timestamps;

        db = this.getReadableDatabase();

        String query = "SELECT " + BEACON_TIMESTAMP + " FROM " + TABLE_NAME_BEACON + " WHERE "
                + BEACON_UUID + "= '" + UUID + "' AND "
                + BEACON_MAJOR + "= '" + major + "' AND "
                + BEACON_MINOR + "= '" + minor + "'";

        Cursor cs = db.rawQuery(query, null);
        cs.moveToFirst();
        timestamps =  cs.getLong(cs.getColumnIndex(BEACON_TIMESTAMP));
        Log.d(TAG, "Timestamp count: " + cs.getCount());

        return timestamps;
    }

    public void updateTimestamp(String UUID, int major, int minor){

        db = this.getWritableDatabase();

       db.execSQL("UPDATE " + TABLE_NAME_BEACON + " SET " + BEACON_TIMESTAMP + " = " + System.currentTimeMillis()/1000 + " WHERE "
                + BEACON_UUID + "= '" + UUID + "' AND "
                + BEACON_MAJOR + "= '" + major + "' AND "
                + BEACON_MINOR + "= '" + minor + "'");

        Log.d(TAG, "Timestamp updated ");

    }

//    public void insertBeaconOffer(String date, int minor, String description, String store){
//
//        db = this.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(OFFER_DESCRIPTION, description);
//        contentValues.put(OFFER_MINOR, minor);
//        contentValues.put(OFFER_DATE_RECEIVED, date);
//        contentValues.put(OFFER_STORE, store);
//        db.insert(TABLE_NAME_OFFER_RECEIVED, null, contentValues);
//    }
//
//    public Cursor getAllRows() {
//
//        db = this.getReadableDatabase();
//        Cursor c = db.rawQuery("Select distinct " + OFFER_ID + " as _id, " + OFFER_DESCRIPTION + ", "
//                + OFFER_DATE_RECEIVED + ", " + OFFER_STORE + " from " + TABLE_NAME_OFFER_RECEIVED + " ORDER BY " + OFFER_ID + " DESC", null);
//        if (c != null) {
//            c.moveToFirst();
//        }
//        return c;
//    }


}