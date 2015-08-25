package com.example.matthew.qubapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Matthew on 12/08/2015.
 */
public class OfferDatabase extends SQLiteOpenHelper {

    private static OfferDatabase instance = null;

    public static final String DATABASE_NAME = "OfferDatabase.db";

     //Beacon Offers Table
    public static final String TABLE_NAME_BEACON_OFFER = "offer_table";
    public static final String OFFER_ID = "_id";
    public static final String OFFER_DESCRIPTION = "DESCRIPTION";
    public static final String OFFER_STORE = "STORE";
    public static final String OFFER_UUID = "UUID";
    public static final String OFFER_MAJOR = "MAJOR";
    public static final String OFFER_MINOR = "MINOR";
    public static final String OFFER_MAX_DISTANCE = "DISTANCE";

    //General Offers Table
    public static final String TABLE_NAME_GENERAL_OFFER = "general_offer_table";
    public static final String OFFER_NAME = "NAME";
    public static final String OFFER_SHOP = "SHOP";
    public static final String OFFER_EXPIRY = "EXPIRY";
    public static final String OFFER_LAT = "LATITUDE";
    public static final String OFFER_LON = "LONGITUDE";
    public static final String OFFER_ICON = "ICON";

    public SQLiteDatabase db;



    public static synchronized OfferDatabase getInstance(Context context){
        if (instance == null){
            instance = new OfferDatabase(context.getApplicationContext());
        }

        return instance;
    }

    private OfferDatabase(Context context) {
        super(context, DATABASE_NAME, null, 8);
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(OFFER_DESCRIPTION, "2 for 1 pizzas in store just for you!");
        contentValues.put(OFFER_STORE, "Tesco");
        contentValues.put(OFFER_UUID, "ebefd083-70a2-47c8-9837-e7b5634df524");
        contentValues.put(OFFER_MAJOR, 1);
        contentValues.put(OFFER_MINOR, 1);
        contentValues.put(OFFER_MAX_DISTANCE, 2);
        contentValues.put(OFFER_EXPIRY, "21 November 2015");
        contentValues.put(OFFER_ICON, R.drawable.tesco_icon);
        db.insert(TABLE_NAME_BEACON_OFFER, null, contentValues);

        contentValues.put(OFFER_DESCRIPTION, "2 for 1 beers in store just for you!");
        contentValues.put(OFFER_STORE, "Asda");
        contentValues.put(OFFER_UUID, "ebefd083-70a2-47c8-9837-e7b5634df524");
        contentValues.put(OFFER_MAJOR, 1);
        contentValues.put(OFFER_MINOR, 2);
        contentValues.put(OFFER_MAX_DISTANCE, 2);
        contentValues.put(OFFER_EXPIRY, "30 October 2015");
        contentValues.put(OFFER_ICON, R.drawable.asda);
        db.insert(TABLE_NAME_BEACON_OFFER, null, contentValues);

        contentValues.put(OFFER_DESCRIPTION, "Half price chocolate in store just for you!");
        contentValues.put(OFFER_STORE, "Sainsburys");
        contentValues.put(OFFER_UUID, "ebefd083-70a2-47c8-9837-e7b5634df524");
        contentValues.put(OFFER_MAJOR, 1);
        contentValues.put(OFFER_MINOR, 3);
        contentValues.put(OFFER_MAX_DISTANCE, 2);
        contentValues.put(OFFER_EXPIRY, "25 November 2015");
        contentValues.put(OFFER_ICON, R.drawable.sainsburys);
        db.insert(TABLE_NAME_BEACON_OFFER, null, contentValues);

        ContentValues contentValues2 = new ContentValues();

        contentValues2.put(OFFER_NAME, "20% off your main course");
        contentValues2.put(OFFER_SHOP, "Pizza Express");
        contentValues2.put(OFFER_EXPIRY, "21 October 2015");
        contentValues2.put(OFFER_LAT, 54.550426);
        contentValues2.put(OFFER_LON, -5.920730);
        contentValues2.put(OFFER_ICON, R.drawable.pizzaexpress);
        db.insert(TABLE_NAME_GENERAL_OFFER, null, contentValues2);

        contentValues2.put(OFFER_NAME, "25% off your bill");
        contentValues2.put(OFFER_SHOP, "Nandos");
        contentValues2.put(OFFER_EXPIRY, "30 October 2015");
        contentValues2.put(OFFER_LAT, 54.550426);
        contentValues2.put(OFFER_LON, -5.920730);
        contentValues2.put(OFFER_ICON, R.drawable.nandos);
        db.insert(TABLE_NAME_GENERAL_OFFER, null, contentValues2);

        contentValues2.put(OFFER_NAME, "2 for 1 on selected bestsellers");
        contentValues2.put(OFFER_SHOP, "Waterstones");
        contentValues2.put(OFFER_EXPIRY, "27 September 2015");
        contentValues2.put(OFFER_LAT, 54.550426);
        contentValues2.put(OFFER_LON, -5.920730);
        contentValues2.put(OFFER_ICON, R.drawable.waterstones);
        db.insert(TABLE_NAME_GENERAL_OFFER, null, contentValues2);

        contentValues2.put(OFFER_NAME, "15% off all fragrances");
        contentValues2.put(OFFER_SHOP, "The Perfume Shop");
        contentValues2.put(OFFER_EXPIRY, "3 October 2015");
        contentValues2.put(OFFER_LAT, 54.550426);
        contentValues2.put(OFFER_LON, -5.920730);
        contentValues2.put(OFFER_ICON, R.drawable.perfumeshop);
        db.insert(TABLE_NAME_GENERAL_OFFER, null, contentValues2);

        contentValues2.put(OFFER_NAME, "20% off in-store");
        contentValues2.put(OFFER_SHOP, "The Body Shop");
        contentValues2.put(OFFER_EXPIRY, "21 October 2015");
        contentValues2.put(OFFER_LAT, 54.550426);
        contentValues2.put(OFFER_LON, -5.920730);
        contentValues2.put(OFFER_ICON, R.drawable.bodyshop);
        db.insert(TABLE_NAME_GENERAL_OFFER, null, contentValues2);

        contentValues2.put(OFFER_NAME, "10% off all men's trainers");
        contentValues2.put(OFFER_SHOP, "Footlocker");
        contentValues2.put(OFFER_EXPIRY, "15 October 2015");
        contentValues2.put(OFFER_LAT, 54.550426);
        contentValues2.put(OFFER_LON, -5.920730);
        contentValues2.put(OFFER_ICON, R.drawable.footlocker);
        db.insert(TABLE_NAME_GENERAL_OFFER, null, contentValues2);

        contentValues2.put(OFFER_NAME, "15% off all womanswear");
        contentValues2.put(OFFER_SHOP, "Next");
        contentValues2.put(OFFER_EXPIRY, "25 September 2015");
        contentValues2.put(OFFER_LAT, 54.550426);
        contentValues2.put(OFFER_LON, -5.920730);
        contentValues2.put(OFFER_ICON, R.drawable.nextlogo);
        db.insert(TABLE_NAME_GENERAL_OFFER, null, contentValues2);

        contentValues2.put(OFFER_NAME, "10% off all homeware");
        contentValues2.put(OFFER_SHOP, "House of Fraser");
        contentValues2.put(OFFER_EXPIRY, "5 October 2015");
        contentValues2.put(OFFER_LAT, 54.550426);
        contentValues2.put(OFFER_LON, -5.920730);
        contentValues2.put(OFFER_ICON, R.drawable.houseoffraser);
        db.insert(TABLE_NAME_GENERAL_OFFER, null, contentValues2);

        contentValues2.put(OFFER_NAME, "30% off main courses");
        contentValues2.put(OFFER_SHOP, "Frankie & Benny's");
        contentValues2.put(OFFER_EXPIRY, "10 October 2015");
        contentValues2.put(OFFER_LAT, 54.550426);
        contentValues2.put(OFFER_LON, -5.920730);
        contentValues2.put(OFFER_ICON, R.drawable.frankieandbenny);
        db.insert(TABLE_NAME_GENERAL_OFFER, null, contentValues2);

        contentValues2.put(OFFER_NAME, "20% off all gift sets");
        contentValues2.put(OFFER_SHOP, "Rituals");
        contentValues2.put(OFFER_EXPIRY, "31 October 2015");
        contentValues2.put(OFFER_LAT, 54.550426);
        contentValues2.put(OFFER_LON, -5.920730);
        contentValues2.put(OFFER_ICON, R.drawable.rituals);
        db.insert(TABLE_NAME_GENERAL_OFFER, null, contentValues2);



    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME_BEACON_OFFER + " (_id INTEGER PRIMARY KEY, DESCRIPTION TEXT, STORE TEXT, " +
                "UUID TEXT, MAJOR TEXT, MINOR TEXT, DISTANCE TEXT, EXPIRY TEXT, ICON TEXT);");
        db.execSQL("CREATE TABLE " + TABLE_NAME_GENERAL_OFFER + " (_id INTEGER PRIMARY KEY, NAME TEXT, SHOP TEXT, EXPIRY TEXT, LATITUDE FLOAT, LONGITUDE FLOAT, ICON TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_BEACON_OFFER);

        onCreate(db);
    }

    public String databaseToString(){
        String dbString;
        db = this.getReadableDatabase();
        String query = "SELECT " + OFFER_DESCRIPTION + " FROM " + TABLE_NAME_BEACON_OFFER + " WHERE " + OFFER_MINOR + "= '1';";

        Cursor cs = db.rawQuery(query, null);
        cs.moveToFirst();
        dbString = cs.getString(cs.getColumnIndex(OFFER_DESCRIPTION));

        return dbString;
    }

    public String getOfferDes(String UUID, int major, int minor){

        String offerDes = null;
        db = this.getReadableDatabase();
        String query = "SELECT " + OFFER_DESCRIPTION + " FROM " + TABLE_NAME_BEACON_OFFER + " WHERE "
                +  OFFER_UUID + " = '" + UUID + "' AND "
                + OFFER_MAJOR + " = '" + major + "' AND "
                + OFFER_MINOR + "= '" + minor +"'";

        Cursor cs = db.rawQuery(query, null);
        cs.moveToFirst();
        offerDes = cs.getString(cs.getColumnIndex(OFFER_DESCRIPTION));
        return offerDes;
    }

    public String getOfferStore(String UUID, int major, int minor){

        String offerStore = null;
        db = this.getReadableDatabase();
        String query = "SELECT " + OFFER_STORE + " FROM " + TABLE_NAME_BEACON_OFFER + " WHERE "
                +  OFFER_UUID + " = '" + UUID + "' AND "
                + OFFER_MAJOR + " = '" + major + "' AND "
                + OFFER_MINOR + "= '" + minor +"'";

        Cursor cs = db.rawQuery(query, null);
        cs.moveToFirst();
        offerStore = cs.getString(cs.getColumnIndex(OFFER_STORE));
        return offerStore;
    }

    public int getOfferDistance(String UUID, int major, int minor){

        int offerDistance;
        db = this.getReadableDatabase();
        String query = "SELECT " + OFFER_MAX_DISTANCE + " FROM " + TABLE_NAME_BEACON_OFFER + " WHERE "
                +  OFFER_UUID + " = '" + UUID + "' AND "
                + OFFER_MAJOR + " = '" + major + "' AND "
                + OFFER_MINOR + "= '" + minor +"'";

        Cursor cs = db.rawQuery(query, null);
        cs.moveToFirst();
        offerDistance = cs.getInt(cs.getColumnIndex(OFFER_MAX_DISTANCE));
        return offerDistance;
    }

    public Cursor getAllRows() {
        db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select distinct " + OFFER_ID + " as _id, " + OFFER_NAME + ", " + OFFER_SHOP + ", " + OFFER_EXPIRY + ", " + OFFER_ICON + " from " + TABLE_NAME_GENERAL_OFFER, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public ArrayList<String> getOfferDetails(String name){

        ArrayList<String> details = new ArrayList<>();
        db = this.getReadableDatabase();

        String query = "SELECT " + OFFER_SHOP + ", " + OFFER_EXPIRY + " FROM "+  TABLE_NAME_GENERAL_OFFER + " WHERE " + OFFER_NAME + " = '" +name + "'";

        Cursor cs = db.rawQuery(query, null);
        cs.moveToFirst();
        details.add(0, cs.getString(cs.getColumnIndex(OFFER_SHOP)));
        details.add(1, cs.getString(cs.getColumnIndex(OFFER_EXPIRY)));


        return details;
    }

    public ArrayList<String> getBeaconOfferDetails(String name){

        ArrayList<String> details = new ArrayList<>();
        db = this.getReadableDatabase();

        String query = "SELECT " + OFFER_STORE + ", " + OFFER_EXPIRY + " FROM "+  TABLE_NAME_BEACON_OFFER + " WHERE " + OFFER_DESCRIPTION + " = '" +name + "'";

        Cursor cs4 = db.rawQuery(query, null);
        cs4.moveToFirst();
        details.add(0, cs4.getString(cs4.getColumnIndex(OFFER_STORE)));
        details.add(1, cs4.getString(cs4.getColumnIndex(OFFER_EXPIRY)));


        return details;
    }

    public ArrayList<Float> getCoordinates(String offer){

        ArrayList<Float> coordinates = new ArrayList<>();
        db = this.getReadableDatabase();

        String query = "SELECT " + OFFER_LAT + ", " + OFFER_LON + " FROM "+  TABLE_NAME_GENERAL_OFFER + " WHERE " + OFFER_NAME + " = '" + offer + "'";
        Cursor cs5 = db.rawQuery(query, null);
        cs5.moveToFirst();

        coordinates.add(0, cs5.getFloat(cs5.getColumnIndex(OFFER_LAT)));
        coordinates.add(1, cs5.getFloat(cs5.getColumnIndex(OFFER_LON)));

        return coordinates;

    }


}
