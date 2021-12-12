package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foodapp.Database.MyDatabase;
import com.example.foodapp.Database.RecetteData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class RecettesActivity extends AppCompatActivity {
    private TextView recettesView;
    private MyDatabase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recettes);

        recettesView=(TextView) findViewById(R.id.recettesView);
        dataBase=new MyDatabase(this);

        dataBase.insertData("Pizza : 1 Ananas, Ricotta, Pousses d'épinards 200g, Jambon Italien 4 tranches ");
        dataBase.insertData("Saumon en papillote au four: 4 filets de suamon, Aluminium, Sauce Magique");
        dataBase.insertData("Salade Estivale: Pennes 500g, Salade verte, 2 Fromages de chèvre, Huile de tournesol 2 cuillères, ");
        dataBase.insertData("Cake au Champignons: Girolles 400g, Crème 100ml, Fromage de chèvre");

        List<RecetteData> recettes=dataBase.readData();
        for (RecetteData recetteData : recettes ){
            recettesView.append(recetteData.toString()+ "\n\n");
        }
        dataBase.close();


        bottomNavigation();
    }
    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout recettesBtn = findViewById(R.id.recettesBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecettesActivity.this, CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecettesActivity.this, MainActivity.class));
            }
        });

        recettesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecettesActivity.this, RecettesActivity.class));
            }
        });
    }
}