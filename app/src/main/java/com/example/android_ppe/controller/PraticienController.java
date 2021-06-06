package com.example.android_ppe.controller;

import android.content.Context;

import com.example.android_ppe.model.Praticien;
import com.example.android_ppe.model.PraticienDao;

import java.util.ArrayList;

public final class PraticienController {

    private static com.example.android_ppe.controller.PraticienController praticienController = null;
    private static ArrayList<Praticien> praticiens;

    private PraticienController(){
        super();
    }

    /**
     * Accesseur
     * @return : une instance unique de PraticienController (singleton)
     */
    public static final com.example.android_ppe.controller.PraticienController getInstance(Context context){
        if(com.example.android_ppe.controller.PraticienController.praticienController == null) {
            com.example.android_ppe.controller.PraticienController.praticienController = new com.example.android_ppe.controller.PraticienController();
            praticiens = new ArrayList<>();
            PraticienDao praticienDao = new PraticienDao(context);
            praticiens = praticienDao.read();

        }
        return com.example.android_ppe.controller.PraticienController.praticienController;
    }

    /**
     * Trouver un praticien par son indice dans l'arraylist
     * @param index
     * @return le praticien
     */

    public Praticien getPraticien(int index) {
        return praticiens.get(index);
    }

    /**
     * Liste des praticiens
     * @return : l'arraylist de praticiens
     */

    public ArrayList<Praticien> praticiens () {
        return praticiens;
    }

    public boolean VerifyIdentite(int numero, int mdp) {
        for (Praticien praticien: praticiens) {
            if (praticien.getNumero() == numero && praticien.getMdp() == mdp){
                return true;
            }
        }
        return false;
    }
}
