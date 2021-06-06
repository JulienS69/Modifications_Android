package com.example.android_ppe.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.example.android_ppe.R;
import com.example.android_ppe.controller.MedicamentController;
import com.example.android_ppe.model.Medicament;
import com.example.android_ppe.model.Praticien;
import com.example.android_ppe.model.RendezVous;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


/**
 * Classe MedicamentActivity.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/02/2021.
 * Classe permettant l'affichage des médicaments'
 */
public class MedicamentActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvMedicaments;
    MedicamentListAdapter adapter;
    ArrayList<Medicament> medicaments;
    ArrayList<Praticien> praticiens;
    ArrayList<RendezVous> rendezVous;
    Bundle bundleRDV = new Bundle();
    Bundle bundleMedocs = new Bundle();
    Bundle bundlePraticiens = new Bundle();

    /**
     * Appeler lors de l'ouverture de la page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicament);
        creerListe();
        // Ajout d'un évènement "clic dans la liste"
        // lvMedicaments.setOnItemClickListener(this);
        //Création de l'instance de ListAdapter
        //listAdapter = new MedicamentListAdapter(this, medicaments);
        // lvMedicaments.setAdapter(adapter);
        configureToolbar();
        configureNavigation();
    }

    /**
     * Créer la liste de médicaments
     */
    private void creerListe(){
        Intent intent = getIntent();
        MedicamentController medicamentController = MedicamentController.getInstance(getBaseContext());
        medicaments = medicamentController.medicaments();
        if (medicaments != null){
            ListView lstHisto = (ListView)this.findViewById(R.id.listMedicaments);
            adapter = new com.example.android_ppe.view.MedicamentListAdapter(this, medicaments);
            lstHisto.setAdapter(adapter);
            lstHisto.setOnItemClickListener(this);
        }
    }


    private void configureNavigation() {
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_medecine);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                (item) -> {
                    Intent intent;
                    switch (item.getItemId()) {
                        case R.id.action_accueil:
                            intent = new Intent(MedicamentActivity.this, RendezVousActivity.class);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                            break;
                        case R.id.action_medecine: {
                            intent = new Intent(MedicamentActivity.this, MedicamentActivity.class);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                            break;
                        }
                        case R.id.action_settings: {
                            intent = new Intent(MedicamentActivity.this, Profil.class);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                            break;
                        }
                    }
                    return true;
                }
        );
    }

    private void configureToolbar() {
        // Get the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Liste des médicaments");
        // Sets the Toolbar
        setSupportActionBar(toolbar);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("Medoc", " Position " + String.valueOf(position));
        Medicament medicament = (Medicament)adapter.getItem(position);
        String value = medicament.getMNomCommercial();
        Toast.makeText(getApplicationContext(),value, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MedicamentActivity.this, DetailMedicament.class);
        // intent.putExtra("nom", medicament.getMNomCommercial());
        // intent.putExtra("effet", medicament.getMEffet());
        // intent.putExtra("prix", medicament.getMPrixEchant());
        intent.putExtra("medicament", medicament);
        startActivity(intent);
    }
}