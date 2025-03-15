package com.example.pizza;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pizza.beans.Produit;
import com.example.pizza.service.ProduitService;

public class DetailsPizzas extends AppCompatActivity {
    private ProduitService ps;
    private ImageView image;
    private TextView desc;
    private TextView nom;
    private TextView ingrediants;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pizzas);
        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("idf"));
        ps = ProduitService.getInstance();
        image = findViewById(R.id.photo);
        nom = findViewById(R.id.nom);
        desc = findViewById(R.id.description);
        ingrediants = findViewById(R.id.detaisIngrediant);

        Produit p = ps.findById(id);
        image.setImageResource(p.getPhoto());
        ingrediants.setText(p.getDetaisIngrediant());
        desc.setText(p.getDescription());
        nom.setText(p.getNom());
    }
}