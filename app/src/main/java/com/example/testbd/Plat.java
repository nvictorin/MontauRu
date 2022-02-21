package com.example.testbd;

public class Plat
{
    private long id;
    private String nom;

    public Plat(long id, String n)
    {
        this.id = id;
        this.nom = n;
    }

    public Plat(String n)
    {
        this.id = -1;
        this.nom = n;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String n) { this.nom = n; }

    @Override
    public String toString()
    {
        return "Plat[id="+id+", nom="+nom+"]";
    }
}
