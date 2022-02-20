package com.example.testbd;

public class Test
{
    private long id;
    private String nom;

    public Test(long id, String nom)
    {
        this.id = id;
        this.nom = nom;
    }

    public Test(String nom)
    {
        this.id = -1;
        this.nom = nom;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    @Override
    public String toString()
    {
        return "Test[id="+id+", nom="+nom+"]";
    }
}
