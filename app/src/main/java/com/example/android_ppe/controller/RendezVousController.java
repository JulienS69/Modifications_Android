package com.example.android_ppe.controller;

import android.content.Context;

import com.example.android_ppe.model.RendezVous;
import com.example.android_ppe.model.RendezVousDao;
import com.example.android_ppe.model.*;

import java.util.ArrayList;

public final class RendezVousController {

    private static com.example.android_ppe.controller.RendezVousController rendezVousController = null;
    private static ArrayList<RendezVous> rendezVous;
    private static RendezVousDao rendezVousDao;

    private RendezVousController(){
        super();
    }

    /**
     * Accesseur
     * @return : une instance unique de RendezVousController (singleton)
     */
    public static final com.example.android_ppe.controller.RendezVousController getInstance(Context context){
        if(com.example.android_ppe.controller.RendezVousController.rendezVousController == null) {
            com.example.android_ppe.controller.RendezVousController.rendezVousController = new com.example.android_ppe.controller.RendezVousController();
            rendezVous = new ArrayList<>();
            rendezVousDao = new RendezVousDao(context);

        }
        rendezVous = rendezVousDao.read();
        return com.example.android_ppe.controller.RendezVousController.rendezVousController;
    }

    /**
     * Trouver un rendez-vous par son indice dans l'arraylist
     * @param index
     * @return le rendez-vous
     */

    public RendezVous getRendezvous(int index) {
        return rendezVous.get(index);
    }

    /**
     * Liste des rendez-vous
     * @return : l'arraylist de rendez-vous
     */

    public ArrayList<RendezVous> rendezVous () {
        return rendezVous;
    }

    /**
     * Liste des rendez-vous pour une date donnée
     * @return : arraylist de rendez-vous
     */

    public ArrayList<RendezVous> rendezVous (String date) {
        ArrayList<RendezVous> rendezVousDate = new ArrayList<>();
        for (RendezVous rdv : rendezVous) {
            if (rdv.getDate().equals(date)) {
                rendezVousDate.add(rdv);
            }
        }
        return rendezVousDate;
    }

    public void ajouterRendezVous(String date, String heure, String numeroPraticien) {
        rendezVousDao.create(date, heure, numeroPraticien);
    }
}
