package com.example.testbd;

public class Dessert
{
    private static long count = 0;
    private long id;
    private String nom;

    public Dessert(long id, String n)
    {
        this.id = id;
        this.nom = n;
    }

    public Dessert(String n)
    {
        this.setId(++count);
        this.nom = n;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String d) { this.nom = d; }

    public void creerUnDessert() //Evenement onClick du bouton valider dans la vue de création d'un menu
    {
        //Dessert dessert = null;   //Création d'un dessert vide qu'on utilisera plus tard
        //Alors String nomDessert = ...;       //Récupère la valeur du EditText liée au dessert "et_…" (nom au choix)
        //Dessert unDessert = new Dessert(nomDessert);
        //insertDessert(unDessert);
    }

    @Override
    public String toString()
    {
        return "Dessert[id="+id+", nom="+nom+"]";
    }
}
