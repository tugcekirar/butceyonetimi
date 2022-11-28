package com.example.kiiselbteynetimi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String GELIR_TABLE = "GELIR_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_GELIR_GIRIS = "GELIR_GIRIS";
    public static final String COLUMN_GELIR_TUR = "GELIR_TUR";
    public DatabaseHelper(@Nullable Context context) {
        super(context, "gelir.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable= "CREATE TABLE " + GELIR_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_GELIR_GIRIS + " INTEGER, " + COLUMN_GELIR_TUR + " STRING)";
        db.execSQL(createtable);
    }
    public boolean addonegelir(GELIR glr){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_GELIR_GIRIS,glr.getGelirmiktar());
        cv.put(COLUMN_GELIR_TUR,glr.getGelirturu());
        long insert=db.insert(GELIR_TABLE,null,cv);
        if(insert==-1){ return false; }
        else{ return  true; }
    }
    public List<GELIR> tumgelirgetir(){
        List<GELIR>gelirlist=new ArrayList<>();
        String query=" SELECT * FROM " +GELIR_TABLE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                int id=cursor.getInt(0);
                int gelir=cursor.getInt(1);
                String gelirtur=cursor.getString(2);
                GELIR g=new GELIR(id,gelir,gelirtur);
                gelirlist.add(g);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return  gelirlist;
    }
    public boolean deletegelir(GELIR glr){
        SQLiteDatabase db= this.getWritableDatabase();
        String query= "DELETE FROM "+ GELIR_TABLE+" WHERE "+COLUMN_ID+"="+glr.getId();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){ return true; }
        else{ return false; }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
class DatabaseHelper2 extends SQLiteOpenHelper{
    public static final String COLUMN_ID = "ID";
    public static final String GIDER_TABLE = "GIDER_TABLE";
    public static final String COLUMN_GIDER_GIRIS = "GIDER_GIRIS";
    public static final String COLUMN_GIDER_TUR = "GIDER_TUR";
    public DatabaseHelper2(@Nullable Context context) { super(context, "gider.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
      String createtable2= "CREATE TABLE " + GIDER_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_GIDER_GIRIS + " INTEGER, " + COLUMN_GIDER_TUR + " STRING)";
      db.execSQL(createtable2);
    }
    public boolean addonegider(GIDER gdr){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_GIDER_GIRIS,gdr.getGidermiktar());
        cv.put(COLUMN_GIDER_TUR,gdr.getGiderturu());
        long insert=db.insert(GIDER_TABLE,null,cv);
        if(insert==-1){ return false; }
        else { return true; }
    }
    public List<GIDER>tumgidergetir(){
        List<GIDER>giderlist=new ArrayList<>();
        String query="SELECT * FROM " +GIDER_TABLE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                int id=cursor.getInt(0);
                int gider=cursor.getInt(1);
                String gidertur=cursor.getString(2);
                GIDER g2=new GIDER(id,gider,gidertur);
                giderlist.add(g2);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return giderlist;
    }
    public boolean deletegider(GIDER gdr){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="DELETE FROM "+GIDER_TABLE+" WHERE "+COLUMN_ID+"="+gdr.getId();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){ return true; }
        else { return false; }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
class DatabaseHelper3 extends SQLiteOpenHelper {
    public static final String COLUMN_ID = "ID";
    public static final String NOTLAR_TABLE = "NOTLAR_TABLE";
    public static final String COLUMN_NOT_GIRIS = "NOT_GIRIS";
    public DatabaseHelper3(@Nullable Context context) { super(context, "notlar.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable3= "CREATE TABLE " + NOTLAR_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NOT_GIRIS + " STRING)";
        db.execSQL(createtable3);
    }
    public boolean addonenot(NOTLAR nt){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NOT_GIRIS,nt.getNot());
        long insert=db.insert(NOTLAR_TABLE,null,cv);
        if(insert==-1){ return false; }
        else { return true; }
    }
    public List<NOTLAR> tumnotlargetir(){
        List<NOTLAR> notlarlist=new ArrayList<>();
        String query=" SELECT * FROM " + NOTLAR_TABLE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                int id=cursor.getInt(0);
                String not=cursor.getString(1);
                NOTLAR n=new NOTLAR(id,not);
                notlarlist.add(n);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notlarlist;
    }
    public boolean deletenotlar(NOTLAR nt){
        SQLiteDatabase db=this.getWritableDatabase();
        String query=" DELETE FROM "+NOTLAR_TABLE+" WHERE "+COLUMN_ID+"="+nt.getId();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){ return true; }
        else { return false; }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
class DatabaseHelper4 extends SQLiteOpenHelper {
    public static final String COLUMN_ID = "ID";
    public static final String ALISVERIS_TABLE = "ALISVERIS_TABLE";
    public static final String COLUMN_ALINACAK_GIRIS = "ALINACAK_GIRIS";
    public DatabaseHelper4(@Nullable Context context) { super(context, "alisveris.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable4= "CREATE TABLE " + ALISVERIS_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ALINACAK_GIRIS + " STRING)";
        db.execSQL(createtable4);
    }
    public boolean addonealinacak(ALISVERIS al){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_ALINACAK_GIRIS,al.getAlinacak());
        long insert=db.insert(ALISVERIS_TABLE,null,cv);
        if(insert==-1){ return false; }
        else { return true; }
    }
    public List<ALISVERIS> tumlistegetir(){
        List<ALISVERIS> alinacaklarlist=new ArrayList<>();
        String query=" SELECT * FROM " + ALISVERIS_TABLE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                int id=cursor.getInt(0);
                String not=cursor.getString(1);
                ALISVERIS a=new ALISVERIS(id,not);
                alinacaklarlist.add(a);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return alinacaklarlist;
    }
    public boolean deletesatir(ALISVERIS al){
        SQLiteDatabase db=this.getWritableDatabase();
        String query=" DELETE FROM "+ALISVERIS_TABLE+" WHERE "+COLUMN_ID+"="+al.getId4();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){ return true; }
        else { return false; }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}


