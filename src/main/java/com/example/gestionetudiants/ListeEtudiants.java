package com.example.gestionetudiants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class ListeEtudiants extends AppCompatActivity {

        ListView ls;
        String nom,niveau;
        HashMap<String,String>map;
        Lstes l=new Lstes();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_etudiants);
        ls = findViewById(R.id.list);

        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            nom=extras.getString("nom");
            niveau=extras.getString("niveau");
            map=new HashMap<String, String>();
            map.put("nom", nom);
            map.put("niveau", niveau);

            l.values.add(map);

        }

        SimpleAdapter adapter = new SimpleAdapter( ListeEtudiants.this,l.values,R.layout.item,
                    new String []{"nom", "niveau"},
                    new int []{R.id.nom,R.id.niveau}
                );
            ls.setAdapter(adapter);


            ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(getApplicationContext(),ProprieteActivity.class);
                    i.putExtra("position", position);
                    startActivity(i);


                }
            });

    }
}