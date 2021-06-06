package com.example.android_ppe.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Classe Dal.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/02/2021.
 * Permet de créer la base de données GsbDb.sqlite.
 */
public class Dal {
    private static com.example.android_ppe.model.Dal dal = null;
    //Nom de la base stocké dans le dispositif.
    private static GsbDb createDb = null;

    /**
     * Constructeur privé : création d'une unique instance (singleton).
     */
    private Dal() {
        super();
    }

    /**
     * Crée la db dans le dispositif.
     * @param context : passé par l'activity
     */
    public static com.example.android_ppe.model.Dal getInstance(Context context) {
        if(com.example.android_ppe.model.Dal.dal == null) {
            com.example.android_ppe.model.Dal.dal=new com.example.android_ppe.model.Dal();
            SQLiteDatabase db;
            String dbNom = "GsbDb.sqlite";
            int version = 1;
            createDb = new GsbDb(context, dbNom, null, version);
            db = createDb.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS medicament");
            createDb.onCreate(db);
        }
        return com.example.android_ppe.model.Dal.dal;
    }


    /**
     * Accès à la db créée.
     * @return instance de GsbDb (création de la db).
     */
    public GsbDb getCreateDb() {
        return createDb;
    }

}
