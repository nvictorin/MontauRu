package com.example.testbd;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private TextView tv_test;
    private TextView tv_resultat;
    private testDAO unTestDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_test = findViewById(R.id.tv_test);
        tv_resultat = findViewById(R.id.tv_resultat);

        unTestDAO = new testDAO(this);
        tv_resultat.setText(unTestDAO.getTest(1).getNom());

    }
}