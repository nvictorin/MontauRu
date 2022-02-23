package com.example.testbd;

import static androidx.constraintlayout.widget.Constraints.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class menuDAO
{
    private static String base = "BDMenu";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;
    private static SQLiteDatabase bd;

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
            unMenu = new Menu(id,curseur.getString(1),curseur.getLong(2),curseur.getLong(3),curseur.getLong(4));
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
        String nom;
        long id_entree;
        long id_plat;
        long id_dessert;

        curseur.moveToFirst();
        while (!curseur.isAfterLast())
        {
            id = curseur.getLong(0);
            nom = curseur.getString(1);
            id_entree = curseur.getLong(2);
            id_plat = curseur.getLong(3);
            id_dessert = curseur.getLong(4);
            listeMenu.add(new Menu(id,nom,id_entree,id_plat,id_dessert));
            curseur.moveToNext();
        }
        return listeMenu;
    }

    public Boolean existMenu(Menu leMenu)
    {
        ArrayList<Menu> listeMenu = this.getMenus();
        for (int i = 0; i < listeMenu.size() ; i++)
        {
            if ( (listeMenu.get(i).getIdEntree() == leMenu.getIdEntree()) &&
                    (listeMenu.get(i).getIdPlat() == leMenu.getIdPlat()) &&
                    (listeMenu.get(i).getIdDessert() == leMenu.getIdDessert()))
            {
                return true;
            }
        }
        return false;
    }

    public void insertMenu (Menu monMenu)
    {
        try
        {
            if (!existMenu(monMenu))
            {
                bd = accesBD.getWritableDatabase();
                String req = "insert into menu (id_entree, id_plat, id_dessert) values ";
                req += "(" + monMenu.getIdEntree() + "," + monMenu.getIdPlat() + "," + monMenu.getIdDessert() + ")";
                bd.execSQL(req);
            }
        }
        catch (SQLiteConstraintException e)
        {
            Log.d(TAG, "insertMenu: erreur");
        }
    }

    public void deleteMenu(Menu monMenu)
    {
        try
        {
            bd = accesBD.getWritableDatabase();
            String req = "delete from menu where 'id' = " + monMenu.getId();
            bd.close();
            accesBD.onUpgrade(bd,1, 2);
        }
        catch(SQLiteConstraintException e)
        {
            Log.d(TAG, "deleteMenu: erreur delete menu");
        }
    }
}
