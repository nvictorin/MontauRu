package com.example.testbd;

import static androidx.constraintlayout.widget.Constraints.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class entreeDAO
{
    private static String base = "BDEntree";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;
    private static SQLiteDatabase bd;

    public entreeDAO(Context ct)
    {
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public Entree getEntree(long id)
    {
        Entree uneEntree = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery(
                "select * from entree where id="+id+";",
                null );
        if (curseur.getCount() > 0)
        {
            curseur.moveToFirst();
            uneEntree = new Entree(id,curseur.getString(1));
        }
        return uneEntree;
    }

    public ArrayList<Entree> getEntrees()
    {
        Cursor curseur;
        String req = "select * from entree;";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToEntreeArrayList(curseur);
    }

    private ArrayList<Entree> cursorToEntreeArrayList(Cursor curseur)
    {
        ArrayList<Entree> listeEntree = new ArrayList<>();
        long id;
        String nom;

        curseur.moveToFirst();
        while (!curseur.isAfterLast())
        {
            id = curseur.getLong(0);
            nom = curseur.getString(1);
            listeEntree.add(new Entree(id,nom));
            curseur.moveToNext();
        }
        return listeEntree;
    }

    public void insertEntree(Entree uneEntree)
    {
        try
        {
            bd = accesBD.getWritableDatabase();
            String req = "insert into entree (nom) values ('" + uneEntree.getNom() + "');";
            bd.execSQL(req);
        }
        catch (SQLiteConstraintException e)
        {
            Log.d(TAG, "insertEntree: erreur");
        }
    }

    public void deleteEntree(Entree monEntree)
    {
        try
        {
            bd = accesBD.getWritableDatabase();
            String req = "delete from entree where 'id' = " + monEntree.getId();
            bd.close();
            accesBD.onUpgrade(bd,1, 2);
        }
        catch(SQLiteConstraintException e)
        {
            Log.d(TAG, "deleteEntree: erreur delete entree");
        }
    }
}
