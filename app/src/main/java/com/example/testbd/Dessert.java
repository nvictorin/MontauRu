package com.example.testbd;

public class Dessert
{
    private long id;
    private String nom;

    public Dessert(long id, String n)
    {
        this.id = id;
        this.nom = n;
    }

    public Dessert(String n)
    {
        this.id = -1;
        this.nom = n;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String d) { this.nom = d; }

    @Override
    public String toString()
    {
        return "Dessert[id="+id+", nom="+nom+"]";
    }
}
