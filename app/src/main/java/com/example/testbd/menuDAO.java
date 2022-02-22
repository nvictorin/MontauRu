package com.example.testbd;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class menuDAO
{
    private static String base = "BDMenu";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public menuDAO(Context ct)
    {
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public Menu getMenu(long id)
    {
        Menu unMenu = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery(
                "select * from menu where id="+id+";",
                null );
        if (curseur.getCount() > 0)
        {
            curseur.moveToFirst();
            unMenu = new Menu(id,curseur.getLong(1),curseur.getLong(2),curseur.getLong(3));
        }
        return unMenu;
    }

    public ArrayList<Menu> getMenus()
    {
        Cursor curseur;
        String req = "select * from menu;";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToMenuArrayList(curseur);
    }

    private ArrayList<Menu> cursorToMenuArrayList(Cursor curseur)
    {
        ArrayList<Menu> listeMenu = new ArrayList<>();
        long id;
        long id_entree;
        long id_plat;
        long id_dessert;

        curseur.moveToFirst();
        while (!curseur.isAfterLast())
        {
            id = curseur.getLong(0);
            id_entree = curseur.getLong(1);
            id_plat = curseur.getLong(2);
            id_dessert = curseur.getLong(3);
            listeMenu.add(new Menu(id,id_entree,id_plat,id_dessert));
            curseur.moveToNext();
        }
        return listeMenu;
    }
}
