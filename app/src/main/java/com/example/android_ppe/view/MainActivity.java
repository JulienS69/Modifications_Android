package com.example.android_ppe.view;

import android.content.Intent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android_ppe.R;
import com.example.android_ppe.controller.PraticienController;

/**
 * Classe MainActivity.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/02/2021.
 * Classe principale, permettant la demande à l'utilisateur du mot de passe.
 */

public class MainActivity extends AppCompatActivity {
    PraticienController praticienController;
    private EditText editText;
    private EditText editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        praticienController = PraticienController.getInstance(getApplicationContext());

        editText = (EditText) findViewById(R.id.idApplication);
        editText2 = (EditText) findViewById(R.id.nom);
        editText.setOnEditorActionListener((v, actionId, event) -> {
                    // Si l'utilisateur a cliqué sur Valider
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        int numero = Integer.parseInt(editText2.getText().toString());
                        int mdp = Integer.parseInt(editText.getText().toString());
                        // Si le code saisi est valide
                        if (praticienController.VerifyIdentite(numero, mdp)) {
                            Intent intent = new Intent(MainActivity.this, RendezVousActivity.class);
                            // Permet de récupérer le numéro du praticien connecté.
                            intent.putExtra("idPraticien", numero);
                            startActivity(intent);
                            //Si code non valide
                        } else
                            Toast.makeText(MainActivity.this, "Code erroné", Toast.LENGTH_SHORT).show();
                    }
                    return false;
                }

        );

    }

}
