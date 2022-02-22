package com.example.testbd;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BdSQLiteOpenHelper extends SQLiteOpenHelper
{
    private static final String table_entree = "create table entree ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nom TEXT NOT NULL UNIQUE);";

    private static final String table_plat = "create table plat ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nom TEXT NOT NULL UNIQUE);";

    private static final String table_dessert = "create table dessert ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nom TEXT NOT NULL UNIQUE);";

    private static final String table_menu = "create table menu ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "id_entree INTEGER NOT NULL,"
            + "id_plat INTEGER NOT NULL,"
            + "id_dessert INTEGER NOT NULL,"
            + "foreign key (id_entree) references entree(id),"
            + "foreign key (id_plat) references plat(id),"
            + "foreign key (id_dessert) references dessert(id));";

    private static final String table_utilisateur = "create table utilisateur ("
            + "email TEXT NOT NULL UNIQUE,"
            + "mdp TEXT NOT NULL,"
            + "nom TEXT NOT NULL,"
            + "prenom TEXT NOT NULL,"
            + "estAdmin INTEGER(1) NOT NULL DEFAULT(0),"
            + "primary key (email,mdp));";


    public BdSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //Création des tables
        db.execSQL(table_entree);
        db.execSQL(table_plat);
        db.execSQL(table_dessert);
        db.execSQL(table_menu);
        db.execSQL(table_utilisateur);
        //Création des Utilisateurs
        db.execSQL("insert into utilisateur values('admin','admin','admin','admin',1)");
        db.execSQL("insert into utilisateur values('test','test','test','test',0)");
        //Création des Entrées
        db.execSQL("insert into entree (nom) values('Macedoine')");
        db.execSQL("insert into entree (nom) values('Jambon')");
        //Création des Plats
        db.execSQL("insert into plat (nom) values('Pates carbonara')");
        db.execSQL("insert into plat (nom) values('Risotto aux champignons')");
        //Création des Desserts
        db.execSQL("insert into dessert (nom) values('Fondant au chocolat')");
        db.execSQL("insert into dessert (nom) values('Yaourt nature')");
        //Création des Menus
        db.execSQL("insert into menu (id_entree,id_plat,id_dessert) values(1,1,1)");
        db.execSQL("insert into menu (id_entree,id_plat,id_dessert) values(2,2,2)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}