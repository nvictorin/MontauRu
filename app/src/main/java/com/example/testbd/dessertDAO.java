package com.example.testbd;

import static androidx.constraintlayout.widget.Constraints.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class dessertDAO
{
    private static String base = "BDDessert";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;
    private static SQLiteDatabase bd; // permet l'éxécution des requetes sql

    public dessertDAO(Context ct)
    {
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public Dessert getDessert(long id)
    {
        Dessert unDessert = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery(
                "select * from dessert where id="+id+";",
                null );
        if (curseur.getCount() > 0)
        {
            curseur.moveToFirst();
            unDessert = new Dessert(id,curseur.getString(1));
        }
        return unDessert;
    }

    public ArrayList<Dessert> getDesserts()
    {
        Cursor curseur;
        String req = "select * from dessert;";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToDessertArrayList(curseur);
    }

    private ArrayList<Dessert> cursorToDessertArrayList(Cursor curseur)
    {
        ArrayList<Dessert> listeDessert = new ArrayList<>();
        long id;
        String nom;

        curseur.moveToFirst();
        while (!curseur.isAfterLast())
        {
            id = curseur.getLong(0);
            nom = curseur.getString(1);
            listeDessert.add(new Dessert(id,nom));
            curseur.moveToNext();
        }
        return listeDessert;
    }

    public void insertDessert(Dessert monDessert)
    {
        try
        {
            bd = accesBD.getWritableDatabase();
            String req = "insert into dessert (nom) values ('" + monDessert.getNom() + "');";
            bd.execSQL(req);
            bd.close();
        }
        catch (SQLiteConstraintException e)
        {
            Log.d(TAG, "insertDessert: erreur");
        }

    }

    public void deleteDessert(Dessert monDessert)
    {
        try
        {
            bd = accesBD.getWritableDatabase();
            String req = "delete from dessert where 'id' = " + monDessert.getId();
            // accesBD.onUpgrade(bd,1, 2);
            bd.close();
        }
        catch(SQLiteConstraintException e)
        {
            Log.d(TAG, "deleteDessert: erreur delete dessert");
        }
    }

    public Dessert getLast()
    {
        bd = accesBD.getReadableDatabase();
        Dessert dessert = null;
        String req = "select * from dessert";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToLast();
        if (!curseur.isAfterLast())
        {
            String nom = curseur.getString(1);
            dessert = new Dessert(nom);
        }
        curseur.close();
        return dessert;
    }
}
