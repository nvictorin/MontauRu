package com.example.testbd;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BdSQLiteOpenHelper extends SQLiteOpenHelper
{
    private String table_test = "create table test ("
            + "id INTEGER PRIMARY KEY NOT NULL UNIQUE,"
            + "nom TEXT NOT NULL);";


    public BdSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(table_test);
        db.execSQL("insert into test (nom) values('LETS GO CA MARCHE')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}