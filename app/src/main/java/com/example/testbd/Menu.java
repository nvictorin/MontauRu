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

    public void creerUnMenu() //Evenement onClick du bouton valider dans la vue de création d'un menu
    {
        //Entree entree = null;     //Création d'une entrée vide qu'on utilisera plus tard
        //Plat plat = null;         //Création d'un plat vide qu'on utilisera plus tard
        //Dessert dessert = null;   //Création d'un dessert vide qu'on utilisera plus tard

        //Si Spinner Entree "s_…" (nom au choix) n'est pas vide
            //Alors entree prend la valeur du spinner
        //Sinon afficher en rouge « Veuillez sélectionner une entrée. » en-dessous ou au-dessus du Spinner

        //Si Spinner Plat "s_…" (nom au choix) n'est pas vide
            //Alors plat prend la valeur du spinner
        //Sinon afficher en rouge « Veuillez sélectionner un plat. » en-dessous ou au-dessus du Spinner

        //Si Spinner Dessert "s_…" (nom au choix) n'est pas vide
            //Alors dessert prend la valeur du spinner
        //Sinon afficher en rouge « Veuillez sélectionner un dessert. » en-dessous ou au-dessus du Spinner

        //Si entree != null && plat != null && dessert != null
            //Alors Menu(entree.getId(),plat.getId(),dessert.getId());
    }

    @Override
    public String toString()
    {
        return "Menu[id="+id+", id_entree="+id_entree+", id_plat="+id_plat+", id_dessert="+id_dessert+"]";
    }
}
