package com.example.testbd;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class utilisateurDAO
{
    private static String base = "BDTodoList";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public utilisateurDAO(Context ct)
    {
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    public Utilisateur getUtilisateur(String email, String mdp)
    {
        Utilisateur unUtilisateur = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery(
                "select * from utilisateur where email="+email+" AND mdp="+mdp+";",
                null );
        if (curseur.getCount() > 0)
        {
            curseur.moveToFirst();
            unUtilisateur = new Utilisateur(curseur.getString(0),curseur.getString(1),curseur.getString(2),curseur.getString(3),curseur.getInt(4));
        }
        return unUtilisateur;
    }

    public ArrayList<Utilisateur> getUtilisateurs()
    {
        Cursor curseur;
        String req = "select * from utilisateur;";
        curseur = accesBD.getReadableDatabase().rawQuery(req,null);
        return cursorToTestArrayList(curseur);
    }

    private ArrayList<Utilisateur> cursorToTestArrayList(Cursor curseur)
    {
        ArrayList<Utilisateur> listeUtilisateur = new ArrayList<>();
        String email;
        String mdp;
        String nom;
        String prenom;
        int estAdmin;

        curseur.moveToFirst();
        while (!curseur.isAfterLast())
        {
            email = curseur.getString(0);
            mdp = curseur.getString(1);
            nom = curseur.getString(2);
            prenom = curseur.getString(3);
            estAdmin = curseur.getInt(4);
            listeUtilisateur.add(new Utilisateur(email,mdp,nom,prenom,estAdmin));
            curseur.moveToNext();
        }
        return listeUtilisateur;
    }
}
