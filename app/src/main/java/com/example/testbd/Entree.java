package com.example.testbd;

public class Entree
{
    private long id;
    private String nom;

    public Entree(long id, String n)
    {
        this.id = id;
        this.nom = n;
    }

    public Entree(String n)
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
        return "Entree[id="+id+", nom="+nom+"]";
    }
}
