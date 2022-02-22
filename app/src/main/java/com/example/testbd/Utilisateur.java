package com.example.testbd;

public class Utilisateur
{
    private String email;
    private String mdp;
    private String nom;
    private String prenom;
    private int estAdmin;

    public Utilisateur(String e, String m, String n, String p, int a)
    {
        this.email = e;
        this.mdp = m;
        this.nom = n;
        this.prenom = p;
        this.estAdmin = a;
    }

    public Utilisateur(String e, String m, String n, String p)
    {
        this.email = e;
        this.mdp = m;
        this.nom = n;
        this.prenom = p;
        this.estAdmin = 0;
    }

    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }
    public String getMdp() { return mdp; }
    public void setMdp(String m) { this.mdp = m; }
    public String getNom() { return nom; }
    public void setNom(String n) { this.nom = n; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String p) { this.prenom = p; }
    public int getEstAdmin() { return estAdmin; }
    public void setEstAdmin(int a) { this.estAdmin = a; }

    public void seConnecter()
    {
        //-------------------------------VARIABLES------------------------------------
        //Récupération des valeurs des champs de saisie de l'email et mdp
        //mail = ...;
        //password = ...;
        //-------------------------------TRAITEMENT------------------------------------
        //Si (mail == email de l'utilisateur) && (password == mdp de l'utilisateur)
            //Alors affiche "Connexion établie" sur un pop up ephémere (j'ai oublié le nom)
                //Si estAdmin de l'utilisateur == 0
                    //Renvoie sur la page d'accueil à l'état connecté non admin (client)
                //Sinon renvoie sur la page d'accueil à l'état connecté admin (employé CROUS)
        //Sinon affiche "Email ou mot de passe erronné"
    }

    public void sinscrire()
    {
        //-------------------------------VARIABLES------------------------------------
        //Récupération des valeurs des champs de saisie de l'email et mdp
        //mail = ...;
        //password = ...;
        //nom = ...;
        //prenom = ...;
        //-------------------------------TRAITEMENT------------------------------------
        //Si mail déjà utilisé pour un compte
            //Alors affiche "Cette adresse email est déjà utilisée"
        //Sinon Utilisateur(mail, password, nom, prenom); (constructeur avec estAdmin à 0 par défaut)
    }

    @Override
    public String toString()
    {
        return "Utilisateur[email="+email+", mdp="+mdp+", nom="+nom+", prenom="+prenom+", estAdmin="+estAdmin+"]";
    }
}
