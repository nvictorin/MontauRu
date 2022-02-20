package com.example.testbd;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class testDAO
{
    private static String base = "BDTodoList";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public testDAO(Context ct)
    {
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public Test getTest(long id)
    {
        Test leTest = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery(
                "select * from test where id="+id+";",
                null );
        if (curseur.getCount() > 0)
        {
            curseur.moveToFirst();
            leTest = new Test(id,curseur.getString(1));
        }
        return leTest;
    }

    public ArrayList<Test> getTests()
    {
        Cursor curseur;
        String req = "select * from test;";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToTestArrayList(curseur);
    }

    private ArrayList<Test> cursorToTestArrayList(Cursor curseur)
    {
        ArrayList<Test> listeTest = new ArrayList<>();
        long id;
        String nom;

        curseur.moveToFirst();
        while (!curseur.isAfterLast())
        {
            id = curseur.getLong(0);
            nom = curseur.getString(1);
            listeTest.add(new Test(id,nom));
            curseur.moveToNext();
        }
        return listeTest;
    }
}
