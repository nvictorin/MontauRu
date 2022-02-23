package com.example.testbd;

import static androidx.constraintlayout.widget.Constraints.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class platDAO
{
    private static String base = "BDPlat";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;
    private static SQLiteDatabase bd;

    public platDAO(Context ct)
    {
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public Plat getPlat(long id)
    {
        Plat unPlat = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery(
                "select * from plat where id="+id+";",
                null );
        if (curseur.getCount() > 0)
        {
            curseur.moveToFirst();
            unPlat = new Plat(id,curseur.getString(1));
        }
        return unPlat;
    }

    public ArrayList<Plat> getPlats()
    {
        Cursor curseur;
        String req = "select * from plat;";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToPlatArrayList(curseur);
    }

    private ArrayList<Plat> cursorToPlatArrayList(Cursor curseur)
    {
        ArrayList<Plat> listePlat = new ArrayList<>();
        long id;
        String nom;

        curseur.moveToFirst();
        while (!curseur.isAfterLast())
        {
            id = curseur.getLong(0);
            nom = curseur.getString(1);
            listePlat.add(new Plat(id,nom));
            curseur.moveToNext();
        }
        return listePlat;
    }

    public void insertPlat(Plat monPlat)
    {
        try
        {
            bd = accesBD.getWritableDatabase();
            String req = "insert into plat (nom) values ('" + monPlat.getNom() + "');";
            bd.execSQL(req);
        }
        catch (SQLiteConstraintException e)
        {
            Log.d(TAG, "insertPlat: erreur");
        }
    }

    public void deletePlat(Plat monPlat)
    {
        try
        {
            bd = accesBD.getWritableDatabase();
            String req = "delete from plat where 'id' = " + monPlat.getId();
            bd.close();
            accesBD.onUpgrade(bd,1, 2);
        }
        catch(SQLiteConstraintException e)
        {
            Log.d(TAG, "deletePlat: erreur delete plat");
        }
    }
}
