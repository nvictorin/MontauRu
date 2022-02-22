package com.example.testbd;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private TextView tv_entree1;
    private TextView tv_entree2;
    private TextView tv_plat1;
    private TextView tv_plat2;
    private TextView tv_dessert1;
    private TextView tv_dessert2;

    private entreeDAO unEntreeDAO;
    private platDAO unPlatDAO;
    private dessertDAO unDessertDAO;
    private menuDAO unMenuDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_entree1 = findViewById(R.id.tv_entree1);
        tv_entree2 = findViewById(R.id.tv_entree2);
        tv_plat1 = findViewById(R.id.tv_plat1);
        tv_plat2 = findViewById(R.id.tv_plat2);
        tv_dessert1 = findViewById(R.id.tv_dessert1);
        tv_dessert2 = findViewById(R.id.tv_dessert2);

        unMenuDAO = new menuDAO(this);
        unEntreeDAO = new entreeDAO(this);
        unPlatDAO = new platDAO(this);
        unDessertDAO = new dessertDAO(this);

        tv_entree1.setText(unEntreeDAO.getEntree(unMenuDAO.getMenu(1).getIdEntree()).getNom());
        tv_entree2.setText(unEntreeDAO.getEntree(unMenuDAO.getMenu(2).getIdEntree()).getNom());

        tv_plat1.setText(unPlatDAO.getPlat(unMenuDAO.getMenu(1).getIdPlat()).getNom());
        tv_plat2.setText(unPlatDAO.getPlat(unMenuDAO.getMenu(2).getIdPlat()).getNom());

        tv_dessert1.setText(unDessertDAO.getDessert(unMenuDAO.getMenu(1).getIdDessert()).getNom());
        tv_dessert2.setText(unDessertDAO.getDessert(unMenuDAO.getMenu(2).getIdDessert()).getNom());

    }
}