package com.example.android_ppe.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Classe RendezVousDAO.
 * @author : Julien. SEUX.
 * created on  31/01/2021.
 * modified on 01/02/2021.
 * Permet de faire les insertion de données dans la BDD
 */
public class RendezVousDao {
    final private Dal dal;
    private SQLiteDatabase db;
    private Context context;

    public RendezVousDao(Context context) {
        this.context = context;
        this.dal = Dal.getInstance(context);
        // todo create();
    }

    public RendezVousDao(Context context,SQLiteDatabase db){
        this.context = context;
        this.dal = Dal.getInstance(context);
        this.db = db;
    }

    /**
     * C du Crud.
     */
    public void create(String date, String heure, String idPraticien) {
        db = dal.getCreateDb().getWritableDatabase();
        // décommenter pour ajouter des rendez-vous dans la BDD
/*        if (read().size() == 0) {
            String req = "insert into rendezvous values ("
                    + "1,"
                    + "'2021/02/01',"
                    + "'14:00',"
                    + "1)";
            db.execSQL(req);
            req = "insert into rendezvous values ("
                    + "2,"
                    + "'2021/02/01',"
                    + "'16:00',"
                    + "2)";
            db.execSQL(req);
            req = "insert into rendezvous values ("
                    + "3,"
                    + "'2021/02/02',"
                    + "'10:00',"
                    + "3)";
            db.execSQL(req);
        }*/
        String req = "insert into rendezvous (date, heure, idPraticien) values ("
                + "'" + date + "'"
                + ", "
                + "'" + heure + "'"
                +", "
                + idPraticien
                + ")";
        db.execSQL(req);
    }

    /**
     * R du Crud.
     * @return arraylist contenant les rendez-vous de la table rendez-vous.
     */
    public ArrayList<com.example.android_ppe.model.RendezVous> read() {
        ArrayList<com.example.android_ppe.model.RendezVous> rendezVous = new ArrayList<>();
        com.example.android_ppe.model.RendezVous leRendezVous;
        db = dal.getCreateDb().getReadableDatabase();
        String req = "Select * from rendezvous";
        Cursor cursor = db.rawQuery(req,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            int numero = cursor.getInt(0);
            String dateRdv = cursor.getString(1);
            String heureRdv = cursor.getString(2);
            int praticienId = cursor.getInt(3);
            com.example.android_ppe.model.PraticienDao praticienDao = new com.example.android_ppe.model.PraticienDao(context,db);
            com.example.android_ppe.model.Praticien praticien = praticienDao.findById(context,praticienId);
            leRendezVous = new com.example.android_ppe.model.RendezVous(numero,dateRdv,heureRdv,praticien);
            rendezVous.add(leRendezVous);
            cursor.moveToNext();
        }
        cursor.close();
        return rendezVous;
    }
}
