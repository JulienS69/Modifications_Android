package com.example.android_ppe.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.android_ppe.R;

import com.example.android_ppe.controller.PraticienController;
import com.example.android_ppe.model.Praticien;
import com.example.android_ppe.model.PraticienDao;
import com.google.android.material.bottomnavigation.BottomNavigationView;


/**
 * Classe Profil.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/05/2021.
 * Classe permettant au visiteur de pouvoir changer de mot de passe.
 */
public class Profil extends AppCompatActivity {

    private EditText mdpactuel;
    private EditText nouveaumdp;
    int idPraticien;
    Button btnvalidermdp;
    PraticienController praticienController;
    PraticienDao praticienDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        //1 - Configuration Toolbar
        this.configureToolbar();
        //2 - Configuration Navigation View
        this.configureNavigation();
        idPraticien = getIntent().getIntExtra("idPraticien", 0);
        btnvalidermdp = (Button) findViewById(R.id.btnvalidermdp);
        mdpactuel = (EditText) findViewById(R.id.mdpactuel);
        nouveaumdp = (EditText) findViewById(R.id.nouveaumdp);
        praticienController = PraticienController.getInstance(getApplicationContext());
        praticienDao = new PraticienDao(getApplicationContext());
        btnvalidermdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Si les différents champs sont supérieur à 0 caratère.
                if (mdpactuel.getText().length()>0 && nouveaumdp.getText().length()>0){
                    // Utilisation de la méthode du Controller (VérifyIdentite) pour pouvoir vérifier que les informations saisies sont correctes
                    if (praticienController.VerifyIdentite(idPraticien, Integer.parseInt(mdpactuel.getText().toString()))){
                        // Appel de la méthode créée dans la DAO Praticien permettant l'insertion/la modification du mot de passe.
                        praticienDao.ModifMDP(idPraticien, Integer.parseInt(nouveaumdp.getText().toString()));
                        Toast.makeText(Profil.this, "Mot de passe modifié avec succès !", Toast.LENGTH_SHORT).show();
                    }else{
                        //Si le mot de passe actuel ne correspond pas avec celui-ci du praticien alors une erreur surgie.
                        Toast.makeText(Profil.this, "Mot de passe incorrect !", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    // Si tous les champs ne sont pas remplis.
                    Toast.makeText(Profil.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //2 Ajouter le menu à la Toolbar
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }


    private void configureToolbar() {
        // Get the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Paramètres");
        // Sets the Toolbar
        setSupportActionBar(toolbar);
    }


    private void configureNavigation() {
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        //bottomNavigationView.setOnNavigationItemSelectedListener();
        bottomNavigationView.setSelectedItemId(R.id.action_settings);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                (item) -> {
                    Intent intent;
                    switch (item.getItemId()) {
                        //"action_medecine" définis dans le fichier situé dans le dossier menu
                        case R.id.action_accueil: {
                            intent = new Intent(Profil.this, RendezVousActivity.class);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                            break;
                        }
                        case R.id.action_settings: {
                            intent = new Intent(Profil.this, Profil.class);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                            break;
                        }
                        case R.id.action_medecine: {
                            intent = new Intent(Profil.this, MedicamentActivity.class);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                            break;
                        }
                    }
                    return true;
                }
        );
    }
}