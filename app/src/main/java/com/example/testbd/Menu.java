package com.example.testbd;

public class Menu
{
    private long id;
    private long id_entree;
    private long id_plat;
    private long id_dessert;

    public Menu(long id, long id_e, long id_p, long id_d)
    {
        this.id = id;
        this.id_entree = id_e;
        this.id_plat = id_p;
        this.id_dessert = id_d;
    }

    public Menu(long id_e, long id_p, long id_d)
    {
        this.id = -1;
        this.id_entree = id_e;
        this.id_plat = id_p;
        this.id_dessert = id_d;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public long getIdEntree() { return id_entree; }
    public void setIdEntree(long id_e) { this.id_entree = id_e; }
    public long getIdPlat() { return id_plat; }
    public void setIdPlat(long id_p) { this.id_plat = id_p; }
    public long getIdDessert() { return id_dessert; }
    public void setIdDessert(long id_d) { this.id_dessert = id_d; }

    @Override
    public String toString()
    {
        return "Menu[id="+id+", id_entree="+id_entree+", id_plat="+id_plat+", id_dessert="+id_dessert+"]";
    }
}
