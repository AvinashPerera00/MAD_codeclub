package com.example.madit20246914.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "family.db";

    public DBHelper(Context context) { super(context, DATABASE_NAME, null, 1); }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        //Family database
        String SQL_CREATE_ENTRIES =
                " CREATE TABLE " + UsersMaster.family.TABLE_NAME + " (" +
                        UsersMaster.family._ID+ " INTEGER PRIMARY KEY," +
                        UsersMaster.family.COLUMN_NAME_NAME+ " TEXT," +
                        UsersMaster.family.COLUMN_NAME_NIC+ " TEXT)" ;

        MyDB.execSQL(SQL_CREATE_ENTRIES);

    }
    //Family database
    public Long addFam(String name,String nic){
        SQLiteDatabase MyDB = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.family.COLUMN_NAME_NAME, name);
        values.put(UsersMaster.family.COLUMN_NAME_NIC, nic);



        return MyDB.insert(UsersMaster.family.TABLE_NAME, null,values);



    }
    // To view the things
    public List readAll(){
        SQLiteDatabase MyDB = getReadableDatabase();

        //Where get the info
        String [] projection = {
                UsersMaster.family._ID,
                UsersMaster.family.COLUMN_NAME_NAME,
                UsersMaster.family.COLUMN_NAME_NIC,



        };

        String sortOder = UsersMaster.family._ID + " DESC";
        Cursor cursor = MyDB.query(
                UsersMaster.family.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOder
        );
        List info = new ArrayList<>();

        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.family.COLUMN_NAME_NAME));
            String nic = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.family.COLUMN_NAME_NIC));


            info.add(name+ ":"+ ":"+nic);
        }
        cursor.close();
        return info;
    }
    public void updateInfo(View view, String name, String nic){
        SQLiteDatabase MyDB = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UsersMaster.family.COLUMN_NAME_NAME,name);
        values.put(UsersMaster.family.COLUMN_NAME_NIC,nic);

        String selection = UsersMaster.family.COLUMN_NAME_NAME + " LIKE ?";
        String[] selectionArgs = {name};

        int count = MyDB.update(
                UsersMaster.family.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );

        Snackbar snackbar = Snackbar.make(view, count+"Rows were affected!!!!",Snackbar.LENGTH_LONG);
        snackbar.setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE);
        snackbar.show();



    }

    public void deleteInfo(String name){
        SQLiteDatabase db = getReadableDatabase();

        String selection = UsersMaster.family.COLUMN_NAME_NAME + " LIKE ?";
        String[] stringArgs = {name};

        db.delete(UsersMaster.family.TABLE_NAME,selection,stringArgs);

    }











    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {

    }





}


