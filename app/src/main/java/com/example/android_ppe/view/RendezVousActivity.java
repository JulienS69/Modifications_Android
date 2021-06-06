package com.example.android_ppe.view;

import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.example.android_ppe.controller.RendezVousController;
import com.example.android_ppe.model.RendezVous;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.android_ppe.R;

import java.util.ArrayList;

/**
 * Classe RendezVousActivity.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/05/2021.
 * Classe permettant de visualiser les rendez-vous pris par le visiteur.
 */

public class RendezVousActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    RendezVousListAdapter adapter;
    ArrayList<RendezVous> rendezvous;
    int idPraticien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendez_vous);
        creerListe();
        idPraticien = getIntent().getIntExtra("idPraticien", 0);

        //1 - Configuration Toolbar
        this.configureToolbar();

        //2 - Configuration Navigation View
        this.configureNavigation();

        //3 - Configuration FAB (Bouton Flottant ou Floating Button)
        this.configurationFAB();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //2 Ajouter le menu à la Toolbar
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }
    // ---

    private void creerListe(){
        Intent intent = getIntent();
        RendezVousController rendezVousController = RendezVousController.getInstance(getBaseContext());
        rendezvous = rendezVousController.rendezVous();
        if (rendezvous != null){
            ListView lstHisto = (ListView)this.findViewById(R.id.listRendezVous);
            adapter = new RendezVousListAdapter(this, rendezvous);
            lstHisto.setAdapter(adapter);
            lstHisto.setOnItemClickListener(this);
        }
    }

    private void configureToolbar() {
        // Get the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Mes rendez-vous");
        // Sets the Toolbar
        setSupportActionBar(toolbar);
    }

    private void configureNavigation() {
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        //bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                (item) -> {
                    Intent intent;
                    switch (item.getItemId()) {
                        //"action_medecine" définis dans le fichier situé dans le dossier menu
                        case R.id.action_medecine: {
                            intent = new Intent(RendezVousActivity.this, MedicamentActivity.class);
                            intent.putExtra("idPraticien", idPraticien);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                            break;
                        }
                        case R.id.action_settings: {
                            intent = new Intent(RendezVousActivity.this, Profil.class);
                            intent.putExtra("idPraticien", idPraticien);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                            break;
                        }
                    }
                    return true;
                }
        );
    }

    private void configurationFAB() {
        ((FloatingActionButton) this.findViewById(R.id.fabAjouter)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RendezVousActivity.this, "Prendre Rendez-Vous", Toast.LENGTH_SHORT).show();
                Intent i = new Intent (RendezVousActivity.this, PrendreRDV.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}