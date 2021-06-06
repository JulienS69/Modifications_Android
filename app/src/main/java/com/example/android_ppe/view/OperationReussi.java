package com.example.android_ppe.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android_ppe.R;

/**
 * Classe OperationReussi.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/05/2021.
 * Classe permettant l'affichage du layout activity_operation_reussi en cas de réussite de la création d'un rendez-vous.
 */
public class OperationReussi extends AppCompatActivity {

    Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_reussi);
        gestionClick();
    }

    private void gestionClick() {
        ((Button) this.findViewById(R.id.RevenirAccueil)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(OperationReussi.this, "Menu des Rendez-Vous", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(OperationReussi.this, RendezVousActivity.class);
                startActivity(i);
            }
        });
    }
}