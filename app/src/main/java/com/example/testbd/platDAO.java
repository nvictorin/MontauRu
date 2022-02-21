package com.example.testbd;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class platDAO
{
    private static String base = "BDTodoList";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

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
        return cursorToTestArrayList(curseur);
    }

    private ArrayList<Plat> cursorToTestArrayList(Cursor curseur)
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
}
