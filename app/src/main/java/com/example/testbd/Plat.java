package com.example.testbd;

public class Plat
{
    private static long count = 0;
    private long id;
    private String nom;

    public Plat(long id, String n)
    {
        this.id = id;
        this.nom = n;
    }

    public Plat(String n)
    {
        this.setId(++count);
        this.nom = n;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String n) { this.nom = n; }

    public void creerUnPlat() //Evenement onClick du bouton valider dans la vue de création d'un menu
    {
        //Plat plat = null;         //Création d'un plat vide qu'on utilisera plus tard
        //Alors String nomPlat = ...;       //Récupère la valeur du EditText liée au plat "et_…" (nom au choix)
        //Plat unPlat = new Plat(nomPlat);
        //insertPlat(unPlat);
    }

    @Override
    public String toString()
    {
        return "Plat[id="+id+", nom="+nom+"]";
    }
}
