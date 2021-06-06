package com.example.android_ppe.view;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.example.android_ppe.R;
import com.example.android_ppe.model.Medicament;

/**
 * Classe DetailMedicament.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/02/2021.
 * Classe permettant l'affichage du détail des médicaments.
 */
public class DetailMedicament extends AppCompatActivity {

    private TextView txtNom;
    private TextView txtEffet;
    private TextView txtPrix;
    private TextView txtContreIndic;
    private TextView txtComposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_medicament);
        txtNom = (TextView) this.findViewById(R.id.txtNomCommercial);
        txtEffet = (TextView) this.findViewById(R.id.txtEffet);
        txtPrix = (TextView) this.findViewById(R.id.txtPrix);
        txtContreIndic = (TextView) this.findViewById(R.id.txtContreindication);
        txtComposition = (TextView) this.findViewById(R.id.txtComposition);
        Medicament medicament = getIntent().getParcelableExtra("medicament");
     //   txtNom.setText(this.getIntent().getExtras().getString("nom"));
     //   txtEffet.setText(this.getIntent().getExtras().getString("effet"));
     //   Double prix = this.getIntent().getDoubleExtra("prix", 0);
      //  txtPrix.setText(prix.toString());
        txtNom.setText(medicament.getMNomCommercial());
        txtEffet.setText(medicament.getMEffet());
        Double prix = medicament.getMPrixEchant();
        txtPrix.setText(prix.toString());
        txtContreIndic.setText(medicament.getMContreIndication());
        txtComposition.setText(medicament.getMComposition());
        gestionClic();
        configureToolbar();
    }

    private void configureToolbar() {
        // Get the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Détail du Médicament");
        // Sets the Toolbar
        setSupportActionBar(toolbar);
    }

    private void gestionClic() {
        ((Button) this.findViewById(R.id.btnRetourdeDetail)).setOnClickListener((v) -> {
            Intent i = new Intent(DetailMedicament.this, MedicamentActivity.class);
            startActivity(i);
        });
    }
}