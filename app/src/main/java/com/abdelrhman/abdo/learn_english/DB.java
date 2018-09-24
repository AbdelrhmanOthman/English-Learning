package com.abdelrhman.abdo.learn_english;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

/**
 * Created by Dell on 22/04/18.
 */

public class DB extends SQLiteOpenHelper{
    public static final String DBname ="data.db";

    public DB(Context context) {
        super(context, DBname, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table favou(id INTEGER PRIMARY KEY AUTOINCREMENT,englishWord TEXT ,arabicWord TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS favou");
        onCreate(sqLiteDatabase);

    }
    public boolean insertData(String englisWord, String ArabicWord){
        SQLiteDatabase sqLiteDatabase = this .getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("englishWord",englisWord);
        contentValues.put("arabicWord",ArabicWord);

        long result = sqLiteDatabase.insert("favou",null,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

    public ArrayList getAllrecord(){
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from favou",null);
        res.moveToFirst();
        while (res.isAfterLast()==false){
            String t1 = res.getString(0);
            String t2 = res.getString(1);
            String t3 = res.getString(2);

            arrayList.add(t1+" : "+t2+" : "+t3);
            res.moveToNext();



        }
        return arrayList;
    }

    public Integer Delete (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("favou","id=?",new String[]{id});
    }











}
