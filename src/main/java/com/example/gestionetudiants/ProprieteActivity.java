 package com.example.gestionetudiants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

 public class ProprieteActivity extends AppCompatActivity {

    EditText nom,niveau;
    Button mod,sup;
    int position;
    Lstes l = new Lstes();
     HashMap<String, String> m;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propriete);

        nom = findViewById(R.id.nom);
        niveau = findViewById(R.id.niveau);
        mod = findViewById(R.id.modif);
        sup = findViewById(R.id.supprimer);

        Bundle extras=getIntent().getExtras();
        if (extras!=null)
        {
            position=extras.getInt("position");

        }

        m = l.values.get(position);
        nom.setText(m.get("nom"));
        niveau.setText(m.get("niveau"));


        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.put("nom", nom.getText().toString());
                m.put("niveau", niveau.getText().toString());
                Intent i = new Intent(getApplicationContext(),ListeEtudiants.class);
                startActivity(i);
                finish();

            }
        });


        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                l.values.remove(position);
                Intent i = new Intent(getApplicationContext(),ListeEtudiants.class);
                startActivity(i);
                finish();

            }
        });



    }
}