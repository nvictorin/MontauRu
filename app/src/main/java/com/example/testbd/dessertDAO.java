package com.example.testbd;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class dessertDAO
{
    private static String base = "BDTodoList";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

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
        return cursorToTestArrayList(curseur);
    }

    private ArrayList<Dessert> cursorToTestArrayList(Cursor curseur)
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
}
