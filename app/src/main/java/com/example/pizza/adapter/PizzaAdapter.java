package com.example.pizza.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.pizza.R;
import com.example.pizza.beans.Produit;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {
    private List<Produit> produits;

    private LayoutInflater inflater;

    public PizzaAdapter(Activity activity, List<Produit> produits) {
        this.produits = produits;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position + 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.general_iteam, null);

        TextView idf = convertView.findViewById(R.id.idf);
        TextView nom = convertView.findViewById(R.id.nom);
        TextView duree = convertView.findViewById(R.id.duree);
        TextView nbrIndegredients = convertView.findViewById(R.id.nbrIndegredients);
        ImageView photo = convertView.findViewById(R.id.photo);

        idf.setText(produits.get(position).getId() + "");
        nom.setText(produits.get(position).getNom());
        nbrIndegredients.setText(produits.get(position).getNbrIndegredients() + "");
        duree.setText(produits.get(position).getDuree() + "");
        photo.setImageResource(produits.get(position).getPhoto());


        return convertView;
    }
}
