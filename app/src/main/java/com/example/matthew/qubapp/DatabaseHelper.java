package com.example.matthew.qubapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Matthew on 22/07/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Product.db";
    public static final String TABLE_NAME = "product_table";
    public static final String PRODUCT_ID = "ID";
    public static final String PRODUCT_NAME = "NAME";
    public static final String PRODUCT_BRAND = "BRAND";
    public static final String PRODUCT_CAT = "CATEGORY";
    public static final String PRODUCT_RRP = "RRP";
    public static final String PRODUCT_PRICE = "PRICE";
    public static final String PRODUCT_SAVING = "SAVING";

    public static final String[] SOME_KEYS = new String[] {PRODUCT_ID, PRODUCT_NAME, PRODUCT_BRAND, PRODUCT_CAT, PRODUCT_RRP, PRODUCT_PRICE, PRODUCT_SAVING};

    public SQLiteDatabase db;



    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(PRODUCT_NAME, "Tennis");
        contentValues.put(PRODUCT_BRAND, "Wilson");
        contentValues.put(PRODUCT_CAT, "Sports");
        contentValues.put(PRODUCT_RRP, 120);
        contentValues.put(PRODUCT_PRICE, 80);
        contentValues.put(PRODUCT_SAVING, 33);
        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(PRODUCT_NAME, "Men's Jeans");
        contentValues.put(PRODUCT_BRAND, "Levis");
        contentValues.put(PRODUCT_CAT, "Menswear");
        contentValues.put(PRODUCT_RRP, 60);
        contentValues.put(PRODUCT_PRICE, 48);
        contentValues.put(PRODUCT_SAVING, 20);
        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(PRODUCT_NAME, "Men's Running Trainers");
        contentValues.put(PRODUCT_BRAND, "Adida");
        contentValues.put(PRODUCT_CAT, "Sports");
        contentValues.put(PRODUCT_RRP, 60);
        contentValues.put(PRODUCT_PRICE, 42);
        contentValues.put(PRODUCT_SAVING, 30);
        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(PRODUCT_NAME, "Women's Black Cardigan");
        contentValues.put(PRODUCT_BRAND, "Next");
        contentValues.put(PRODUCT_CAT, "Womenswear");
        contentValues.put(PRODUCT_RRP, 30);
        contentValues.put(PRODUCT_PRICE, 15);
        contentValues.put(PRODUCT_SAVING, 50);
        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(PRODUCT_NAME, "Men's Brown Leather Shoes");
        contentValues.put(PRODUCT_BRAND, "Red Herring");
        contentValues.put(PRODUCT_CAT, "Men's Footwear");
        contentValues.put(PRODUCT_RRP, 100);
        contentValues.put(PRODUCT_PRICE, 30);
        contentValues.put(PRODUCT_SAVING, 70);
        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(PRODUCT_NAME, "Leather Recliner Chair & Stool");
        contentValues.put(PRODUCT_BRAND, "Debenhams");
        contentValues.put(PRODUCT_CAT, "Furniture");
        contentValues.put(PRODUCT_RRP, 400);
        contentValues.put(PRODUCT_PRICE, 280);
        contentValues.put(PRODUCT_SAVING, 30);
        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(PRODUCT_NAME, "Ultra Agents Stealth Patrol");
        contentValues.put(PRODUCT_BRAND, "Lego");
        contentValues.put(PRODUCT_CAT, "Toys");
        contentValues.put(PRODUCT_RRP, 40);
        contentValues.put(PRODUCT_PRICE, 24);
        contentValues.put(PRODUCT_SAVING, 40);
        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(PRODUCT_NAME, "Black Powershot sx610 Camera");
        contentValues.put(PRODUCT_BRAND, "Canon");
        contentValues.put(PRODUCT_CAT, "Cameras & camcorders");
        contentValues.put(PRODUCT_RRP, 180);
        contentValues.put(PRODUCT_PRICE, 126);
        contentValues.put(PRODUCT_SAVING, 30);
        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(PRODUCT_NAME, "DC44 Origin Cordless Vacuum Cleaner");
        contentValues.put(PRODUCT_BRAND, "Dyson");
        contentValues.put(PRODUCT_CAT, "Vacuum cleaners");
        contentValues.put(PRODUCT_RRP, 269);
        contentValues.put(PRODUCT_PRICE, 209);
        contentValues.put(PRODUCT_SAVING, 22);
        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(PRODUCT_NAME, "Charcoal 2 Button Suit Jacket");
        contentValues.put(PRODUCT_BRAND, "Jeff Banks");
        contentValues.put(PRODUCT_CAT, "Menswear");
        contentValues.put(PRODUCT_RRP, 95);
        contentValues.put(PRODUCT_PRICE, 57);
        contentValues.put(PRODUCT_SAVING, 40);
        db.insert(TABLE_NAME, null, contentValues);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY, NAME TEXT, BRAND TEXT, CATEGORY TEXT, RRP TEXT, PRICE TEXT, SAVING TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }


    public String databaseToString(){
        String dbString = "";
        db = this.getReadableDatabase();
        String query = "SELECT " + PRODUCT_NAME + " FROM " + TABLE_NAME + " WHERE " + PRODUCT_NAME + "= 'Tennis'";

        Cursor cs = db.rawQuery(query, null);
        cs.moveToFirst();
        dbString = cs.getString(cs.getColumnIndex(PRODUCT_NAME));

        db.close();
        return dbString;
    }

    public Cursor getSomeRows() {
        String where = null;
        db = this.getReadableDatabase();
        Cursor c = db.query(true, TABLE_NAME, SOME_KEYS,
                where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }





}
