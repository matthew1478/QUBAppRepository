package com.example.matthew.qubapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Matthew on 12/08/2015.
 */
public class OfferDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "OfferDatabase.db";

     //Offer Table
    public static final String TABLE_NAME_OFFER  = "offer_table";
    public static final String OFFER_ID = "_id";
    public static final String OFFER_DESCRIPTION = "DESCRIPTION";
    public static final String OFFER_UUID = "UUID";
    public static final String OFFER_MAJOR = "MAJOR";
    public static final String OFFER_MINOR = "MINOR";


    public SQLiteDatabase db;



    public OfferDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 7);
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(OFFER_DESCRIPTION, "2 for 1 pizzas in store just for you!!");
        contentValues.put(OFFER_UUID,"ebefd083-70a2-47c8-9837-e7b5634df524");
        contentValues.put(OFFER_MAJOR, 1);
        contentValues.put(OFFER_MINOR, 1);
        db.insert(TABLE_NAME_OFFER, null, contentValues);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME_OFFER + " (_id INTEGER PRIMARY KEY, DESCRIPTION TEXT, UUID TEXT, MAJOR TEXT, MINOR TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_OFFER);

        onCreate(db);
    }

    public String databaseToString(){
        String dbString;
        db = this.getReadableDatabase();
        String query = "SELECT " + OFFER_DESCRIPTION + " FROM " + TABLE_NAME_OFFER + " WHERE " + OFFER_MAJOR + "= '1';";

        Cursor cs = db.rawQuery(query, null);
        cs.moveToFirst();
        dbString = cs.getString(cs.getColumnIndex(OFFER_DESCRIPTION));

        return dbString;
    }

    public String getOffer(int major){

        String offerDes = null;
        db = this.getReadableDatabase();
        String query = "SELECT " + OFFER_DESCRIPTION + " FROM " + TABLE_NAME_OFFER + " WHERE " +  OFFER_MAJOR + "= '" + major +"'";

        Cursor cs = db.rawQuery(query, null);
        cs.moveToFirst();
        offerDes = cs.getString(cs.getColumnIndex(OFFER_DESCRIPTION));
        return offerDes;
    }
}