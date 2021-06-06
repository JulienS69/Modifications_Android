package com.example.android_ppe.view;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.widget.*;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import com.example.android_ppe.R;
import android.view.View;
import com.example.android_ppe.controller.MedicamentController;
import com.example.android_ppe.controller.RendezVousController;
import com.example.android_ppe.model.Medicament;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * Classe PrendreRDV.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/05/2021.
 * Classe permettant au visiteur de pouvoir prendre un rendez-vous, un jour et une heure est demandé. Si l'un des deux champs
 * reste vide, un message d'erreur apparaît.
 */

public class PrendreRDV extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prendre_r_d_v);

        // Permet de mettre la langue du calendrier en français.
        String languageToLoad = "fr"; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;

        //1- Configuration ToolBar
        this.configureToolbar();

        //Bouton permettant de choisir une date.
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "Cliquez ici pour prendre un rendez-vous");
            }
        });

        // Bouton permettant de choisir une heure.
        Button button2 = (Button) findViewById(R.id.buttonhr);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        //Bouton permettant de valider le rendez-vous.

        Button buttonValider = (Button) findViewById(R.id.buttonvaliderdv);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtHeure = (TextView) findViewById(R.id.textViewAfficheHeure);
                TextView txtDate = (TextView) findViewById(R.id.textViewAfficheDate);

                if(!txtDate.getText().toString().equals("Choisissez une date") && !txtHeure.getText().toString().equals("Selectionner une heure")) {
                    String Heure = txtHeure.getText().toString();
                    String Date = txtDate.getText().toString();

                    RendezVousController rendezVousController = RendezVousController.getInstance(getBaseContext());
                    rendezVousController.ajouterRendezVous(Date, Heure, "1");
                    Toast.makeText(PrendreRDV.this, "Rendez-vous validé !", Toast.LENGTH_SHORT).show();
                    Intent intent;
                    intent = new Intent(PrendreRDV.this, OperationReussi.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(PrendreRDV.this, "Veuillez renseigner un date et une heure !", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private void configureToolbar() {
        //Get the toolbar (Serialise)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Set the toolbar
        toolbar.setTitle("Prendre un Rendez-Vous");
        setSupportActionBar(toolbar);
        //Get a support ActionBar corresponding to this toolbar
        // Ce code permet d'activer le button "up" dans la "Toolbar"
        ActionBar actionBar = getSupportActionBar();
        //Enable the Up button
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    // Méthode permettant d'afficher de la date yyyy/MM/dd.
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String dateString = dateFormat.format(calendar.getTime());
        TextView textView = (TextView) findViewById(R.id.textViewAfficheDate);
        textView.setText(dateString);
    }

    @Override
    // Méthode permettant d'afficher de l'heure sous le format hh:mm.
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textView2 = (TextView) findViewById(R.id.textViewAfficheHeure);
        if (String.valueOf(hourOfDay).length() == 1) {
            textView2.setText("0" + hourOfDay + ":");
        } else {
            if (String.valueOf(hourOfDay).length() == 0) {
                textView2.setText("00:");
            } else {
                textView2.setText(hourOfDay + ":");
            }
        }

        if (String.valueOf(minute).length() == 1) {
            textView2.setText(textView2.getText() + "0" + minute);
        } else {
            if (String.valueOf(hourOfDay).length() == 0) {
                textView2.setText(textView2.getText() + "00");
            } else {
                textView2.setText(textView2.getText() + String.valueOf(minute));
            }
        }
    }
}