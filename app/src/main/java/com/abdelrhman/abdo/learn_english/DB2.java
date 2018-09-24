package com.abdelrhman.abdo.learn_english;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Dell on 23/04/18.
 */

public class DB2 extends SQLiteOpenHelper {

    public static final String DBnamE = "exambel.db";


    public DB2(Context context) {
        super(context, DBnamE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table exambels(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "englishWords TEXT ,arabicWords TEXT,exambel TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS exambels");
        onCreate(sqLiteDatabase);


    }

    public boolean insertData2(String englisWord, String ArabicWord, String exambels) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("englishWords", englisWord);
        contentValues.put("arabicWords", ArabicWord);
        contentValues.put("exambel", exambels);

        long result = sqLiteDatabase.insert("exambels", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public ArrayList getAllrecord2() {
        ArrayList arrayList2 = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from exambels", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            String t1 = res.getString(0);
            String t2 = res.getString(1);
            String t3 = res.getString(2);
            String t4 = res.getString(3);

            arrayList2.add(t1 + "  : " + t2 + " : " + t3 + "    :   \n " +"\n"+ t4);
            res.moveToNext();


        }
        return arrayList2;
    }

    public Integer Delete2 (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("exambels","id=?",new String[]{id});
    }



}
