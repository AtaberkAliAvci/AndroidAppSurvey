package com.example.cmse419_term_project_19331130;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Objects;

public class StudentDB extends SQLiteOpenHelper {

    private static final String DBName="myDatabase";
    private static final String DBTablename="All_participanta";
    private static final String DBTablenameCMPE="Female";
    private static final String DBTablenameCMSE="Male";

    private static final int DBversion=1;

    private static final String MT_1="gender";
    private static final String MT_2="score";

    private static final String CREATE_TABLE="CREATE TABLE " + DBTablename + " (" + MT_1 + " STRING," + MT_2 + " STRING"  + ")";
    private static final String CREATE_TABLE_CMPE="CREATE TABLE " + DBTablenameCMPE + " (" +  MT_1 + " STRING," + MT_2 + " STRING"  + ")";
    private static final String CREATE_TABLE_CMSE="CREATE TABLE " + DBTablenameCMSE + " ("   + MT_1 + " STRING," + MT_2 + " STRING"  + ")";
    private static final String DROP_TABLE="DROP TABLE IF EXISTS " + DBTablename;
    private static final String SELECT_FROM="SELECT COUNT(*) FROM "+DBTablename;
    private static final String SELECT_CMSE="SELECT COUNT(*) FROM " + DBTablenameCMSE;
    private static final String SELECT_MALE_L="SELECT COUNT(*) FROM " + DBTablename + " WHERE " + MT_2 + " == 'Low' and " + MT_1 + " == 'Male'";
    private static final String SELECT_MALE_M="SELECT COUNT(*) FROM " + DBTablename + " WHERE " + MT_2 + " == 'Mid' and " + MT_1 + " == 'Male'";
    private static final String SELECT_MALE_H="SELECT COUNT(*) FROM " + DBTablename + " WHERE " + MT_2 + " == 'High' and " + MT_1 + " == 'Male'";
    private static final String SELECT_FEMALE_L="SELECT COUNT(*) FROM " + DBTablename + " WHERE " + MT_2 + " == 'Low' and " + MT_1 + " == 'Female'";
    private static final String SELECT_FEMALE_M="SELECT COUNT(*) FROM " + DBTablename + " WHERE " + MT_2 + " == 'Mid' and " + MT_1 + " == 'Female'";
    private static final String SELECT_FEMALE_H="SELECT COUNT(*) FROM " + DBTablename + " WHERE " + MT_2 + " == 'High' and " + MT_1 + " == 'Female'";
    private static final String SELECT_CMPE="SELECT COUNT(*) FROM " + DBTablenameCMPE;
    private static final String SELECT_STU="SELECT * FROM " + DBTablenameCMSE + " WHERE " + MT_1 + " == ";



    private Context context;

    public StudentDB(@Nullable Context context) {
        super(context, DBName, null, DBversion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            db.execSQL(CREATE_TABLE_CMPE);
            db.execSQL(CREATE_TABLE_CMSE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void AddParticipant(String mid1, String mid2){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(MT_1, mid1);
        values.put(MT_2, mid2);
        if(Objects.equals(mid1, "Female")){
            db.insert(DBTablenameCMPE, null, values);
        }else if(Objects.equals(mid1, "Male")){
            db.insert(DBTablenameCMSE, null, values);
        }
        db.insert(DBTablename, null, values);
    }


    Cursor getAll(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;
        if (db != null){
            c = db.rawQuery(SELECT_FROM, null);
        }
        return(c);
    }

    Cursor getMale(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;
        if (db != null){
            c = db.rawQuery(SELECT_CMSE, null);
        }
        return(c);
    }

    Cursor getFemale(){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(SELECT_CMPE, null);
    }

    Cursor getSelectedStudent(String stuno){
            SQLiteDatabase db = getReadableDatabase();
            Cursor c = null;
            if (db != null){
                c = db.rawQuery(SELECT_STU+stuno, null);
            }
            return(c);
        }


    void Delete(String mt1){
        SQLiteDatabase db = getReadableDatabase();
        db.delete(DBTablename, mt1 + " = ?", new String[]{mt1}); // IF IT IS ALREADY STRING, NO NEED TO USE String.valueOf()
        db.close();
    }

    void Update( String mid1, String mid2){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(MT_1, mid1);
        values.put(MT_2, mid2);

        db.update(DBTablename, values, MT_1 + " = ?", new String[]{MT_1});

    }

     int getCountFromDatabase() {
        int count = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_FROM, null);

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        db.close();

        return count;
    }
     int getFemaleCountFromDatabase() {
        int count = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_CMPE, null);

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        db.close();

        return count;
    }
     int getMaleCountFromDatabase() {
        int count = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_CMSE, null);

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        db.close();

        return count;
    }

     int getLowMaleCountFromDatabase() {
        int count = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_MALE_L, null);

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        db.close();

        return count;
    }

     int getMidMaleCountFromDatabase() {
        int count = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_MALE_M, null);

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        db.close();

        return count;
    }

     int getHighMaleCountFromDatabase() {
        int count = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_MALE_H, null);

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        db.close();

        return count;
    }
     int getLowFemaleCountFromDatabase() {
        int count = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_FEMALE_L, null);

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        db.close();

        return count;
    }

     int getMidFemaleCountFromDatabase() {
        int count = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_FEMALE_M, null);

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        db.close();

        return count;
    }

     int getHighFemaleCountFromDatabase() {
        int count = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_FEMALE_H, null);

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        db.close();

        return count;
    }
}


