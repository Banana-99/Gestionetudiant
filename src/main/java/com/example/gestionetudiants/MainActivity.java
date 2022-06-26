package com.example.gestionetudiants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nom,niveau;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_main);

        nom=findViewById(R.id.nom);
        niveau=findViewById(R.id.niveau);
        add=findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ListeEtudiants.class);
                i.putExtra("nom", nom.getText().toString());
                i.putExtra( "niveau", niveau.getText().toString());
                startActivity(i);
            }
        });
    }
}