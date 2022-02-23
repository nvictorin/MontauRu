package com.example.testbd;

public class Menu
{
    private static long count = 0;
    private long id;
    private String nom;
    private long id_entree;
    private long id_plat;
    private long id_dessert;

    public Menu(long id, String n,long id_e, long id_p, long id_d)
    {
        this.id = id;
        this.nom = n;
        this.id_entree = id_e;
        this.id_plat = id_p;
        this.id_dessert = id_d;
    }

    public Menu(String n, long id_e, long id_p, long id_d)
    {
        this.setId(++count);
        this.nom = n;
        this.id_entree = id_e;
        this.id_plat = id_p;
        this.id_dessert = id_d;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String n) { this.nom = n;}
    public long getIdEntree() { return id_entree; }
    public void setIdEntree(long id_e) { this.id_entree = id_e; }
    public long getIdPlat() { return id_plat; }
    public void setIdPlat(long id_p) { this.id_plat = id_p; }
    public long getIdDessert() { return id_dessert; }
    public void setIdDessert(long id_d) { this.id_dessert = id_d; }

    public void creerUnMenu() //Evenement onClick du bouton valider dans la vue de création d'un menu
    {
        menuDAO unMenuDAO;
        entreeDAO uneEntreeDAO;
        platDAO unPlatDAO;
        dessertDAO unDessertDAO;
        //Entree entree = null;     //Création d'une entrée vide qu'on utilisera plus tard
        //Plat plat = null;         //Création d'un plat vide qu'on utilisera plus tard
        //Dessert dessert = null;   //Création d'un dessert vide qu'on utilisera plus tard
        //Menu menu = null;         //Création d'un menu vide qu'on utilisera plus tard

        //Si Spinner Entree "s_…" (nom au choix) n'est pas vide
            //Alors entree prend la valeur du spinner
            //Si Spinner Entree "s_…" == "Autre"    Evenement onChange() sur le Spinner "s_…"
                //Alors fais apparaitre un EditText "et_…" (nom au choix)
                //Et un Button "Créer une entrée" "b_…" (nom au choix)
                //Si Button "b…" cliqué
                    //Appel creerUneEntree();
        //Sinon afficher en rouge « Veuillez sélectionner une entrée. » en-dessous ou au-dessus du Spinner

        //Si Spinner Plat "s_…" (nom au choix) n'est pas vide
            //Alors plat prend la valeur du spinner
            //Si Spinner Plat "s_…" == "Autre"    Evenement onChange() sur le Spinner "s_…"
                //Alors fais apparaitre un EditText "et_…" (nom au choix)
                //Et un Button "Créer un plat" "b_…" (nom au choix)
                //Si Button "b…" cliqué
                    //Appel creerUnPlat();
        //Sinon afficher en rouge « Veuillez sélectionner un plat. » en-dessous ou au-dessus du Spinner

        //Si Spinner Dessert "s_…" (nom au choix) n'est pas vide
            //Alors dessert prend la valeur du spinner
            //Si Spinner Dessert "s_…" == "Autre"    Evenement onChange() sur le Spinner "s_…"
                //Alors fais apparaitre un EditText "et_…" (nom au choix)
                //Et un Button "Créer un dessert" "b_…" (nom au choix)
                //Si Button "b…" cliqué
                    //Appel creerUnDessert();
        //Sinon afficher en rouge « Veuillez sélectionner un dessert. » en-dessous ou au-dessus du Spinner

        //Si entree != null && plat != null && dessert != null
            //Alors Menu menu = new Menu(entree.getId(),plat.getId(),dessert.getId());
            //menu.nom = uneEntreeDAO.getEntree(menu.getIdEntree()).getNom() + " / "
            //         + unPlatDAO.getPlat(menu.getIdPlat()).getNom() + " / "
            //         + unDessertDAO.getDessert(menu.getIdDessert()).getNom();
            //unMenuDAO.insertMenu(Menu menu);
    }

    public void ajouterUnMenu() //Evenement onClick du bouton valider dans la vue de sélection des menus
    {
        entreeDAO uneEntreeDAO;
        platDAO unPlatDAO;
        dessertDAO unDessertDAO;
        //Menu menu1 = null;         //Création d'un menu vide qu'on utilisera plus tard
        //Menu menu2 = null;         //Création d'un menu vide qu'on utilisera plus tard

        //Si Spinner Menu 1 "s_…" (nom au choix) && Spinner Menu 2 "s_…" (nom au choix) ne sont pas vides
            //Alors on récupére la valeur active du Spinner Menu 1 "s_…"
                //menu1 = s_….getSelectedItem()
                //Alors le TextView "tv_…" (nom au choix) de l'entrée du menu 1 prend la valeur de l'entrée du menu dans le Spinner
                    //tv_… = unEntreeDAO.getEntree(menu1.getIdEntree()).getNom();
                //Alors le TextView "tv_…" (nom au choix) du plat du menu 1 prend la valeur du plat du menu dans le Spinner
                    //tv_… = unPlatDAO.getPlat(menu1.getIdPlat()).getNom();
                //Alors le TextView "tv_…" (nom au choix) du dessert du menu 1 prend la valeur du dessert du menu dans le Spinner
                    //tv_… = unDessertDAO.getDessert(menu1.getIdDessert()).getNom();
            //Si Spinner Menu "s_…" (nom au choix) du menu 2 n'est pas vide
                //menu2 = s_….getSelectedItem()
                //Alors le TextView "tv_…" (nom au choix) de l'entrée du menu 2 prend la valeur de l'entrée du menu dans le Spinner
                    //tv_… = unEntreeDAO.getEntree(menu2.getIdEntree()).getNom();
                //Alors le TextView "tv_…" (nom au choix) du plat du menu 2 prend la valeur du plat du menu dans le Spinner
                    //tv_… = unPlatDAO.getPlat(menu2.getIdPlat()).getNom();
                //Alors le TextView "tv_…" (nom au choix) du dessert du menu 2 prend la valeur du dessert du menu dans le Spinner
                    //tv_… = unDessertDAO.getDessert(menu2.getIdDessert()).getNom();
        //Sinon vérifie quel(s) Spinner(s) est(sont) vide(s)
            //Si Spinner Menu 1 "s_…" (nom au choix) est vide
                //Alors affiche en rouge "Veuillez sélectionner un menu." en-dessous ou au-dessus du Spinner
            //Si Spinner Menu 2 "s_…" (nom au choix) est vide
                //Alors affiche en rouge "Veuillez sélectionner un menu." en-dessous ou au-dessus du Spinner
    }

    public void supprimerUnMenu() //Evenement onClick du Button "Supprimer"
    {
        menuDAO unMenuDAO;
        //Menu menu = null;         //Création d'un menu vide qu'on utilisera plus tard

        //A REDEFINIR PARCE QUE LES MAQUETTES DE SUPPRIMER UN MENU SONT PAS RACCORD AVEC CE QU'ON VEUT
            //Nous ce qu'on veut c'est supprimer le menu de la base de données
            //Alors que les maquettes indiquent que c'est supprimer le menu d'un jour de la semaine et pas de la base de données
        //PROPOSITION POUR REGLER CE PROBLEME
            //Quand on clique sur un Button "Supprimer un menu"
                //Ca nous met une interface avec un Spinner de menu
                //Et un Button "Supprimer" pour supprimer le menu qui sera sélectionner dans le spinner
                //Quand on clique sur le Button "Supprimer"
                    //Si le Spinner Menu "s_…" (nom au choix) n'est pas vide
                        //Appel la méthode deleteMenu(menu) de menuDAO
                        //Supprime le menu de la base de données
                        //Mais également de l'ArrayList Menu pour le retirer du Spinner
                    //Sinon affiche en rouge "Veuillez sélectionner un menu." en-dessous ou au-dessus du Spinner

        //unMenuDAO.deleteMenu(menu);   //Supprimer le menu

    }

        @Override
    public String toString()
    {
        return "Menu[id="+id+", nom="+nom+", id_entree="+id_entree+", id_plat="+id_plat+", id_dessert="+id_dessert+"]";
    }
}
