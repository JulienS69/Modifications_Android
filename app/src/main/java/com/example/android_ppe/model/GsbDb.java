package com.example.android_ppe.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * Classe GsbDb.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/02/2021.
 * Permet de créer les différentes tables dans la BDD.
 */
public class GsbDb extends SQLiteOpenHelper {
    //Requête de création de tables.
    String medicament = "CREATE TABLE medicament ("
            + "depotlegal TEXT PRIMARY KEY,"
            + "nomcommercial TEXT,"
            + "composition TEXT,"
            + "effet TEXT,"
            + "contreindication TEXT,"
            + "prix REAL)";
    String praticien = "CREATE TABLE praticien ("
            + "numero INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "nom TEXT, "
            + "prenom TEXT, "
            + "adresse TEXT, "
            + "codepostal TEXT, "
            + "ville TEXT, "
            + "telephone TEXT, "
            + "mdp INTEGER,"
            + "coefnotoriete INTEGER)";
    String rendezVous = "CREATE TABLE rendezvous ("
            + "numero INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "date TEXT, "
            + "heure TEXT, "
            + "idPraticien INTEGER, "
            + "FOREIGN KEY (idPraticien) REFERENCES praticien(numero) )";


    /**
     * Constructeur.
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public GsbDb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * S'exécute si la base n'existe pas.
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS medicament");
        db.execSQL(medicament);
        db.execSQL("DROP TABLE IF EXISTS praticien");
        db.execSQL(praticien);
        db.execSQL("DROP TABLE IF EXISTS rendezvous");
        db.execSQL(rendezVous);
    }

    /**
     * S'exécute si la db a changé de version.
     * @param db
     * @param oldVersion
     * @param newVersion
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
