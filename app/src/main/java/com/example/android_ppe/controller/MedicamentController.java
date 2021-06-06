package com.example.android_ppe.controller;

import android.content.Context;

import com.example.android_ppe.model.Medicament;
import com.example.android_ppe.model.MedicamentDAO;

import java.util.ArrayList;

public final class MedicamentController {

    private static com.example.android_ppe.controller.MedicamentController medicamentController = null;
    private static ArrayList<Medicament>medicaments;

    private MedicamentController(){
        super();
    }

    /**
     * Accesseur
     * @return : une instance unique de MedicamentController (singleton)
     */
    public static final com.example.android_ppe.controller.MedicamentController getInstance(Context context){
        if(com.example.android_ppe.controller.MedicamentController.medicamentController == null) {
            com.example.android_ppe.controller.MedicamentController.medicamentController = new com.example.android_ppe.controller.MedicamentController();
            medicaments = new ArrayList<>();
            MedicamentDAO medicamentDAO = new MedicamentDAO(context);
            medicaments = medicamentDAO.read();

        }
        return com.example.android_ppe.controller.MedicamentController.medicamentController;
    }

    /**
     * Trouver un médicament par son indice dans l'arraylist
     * @param index
     * @return le médicament
     */

    public Medicament getMedicament(int index) {
        return medicaments.get(index);
    }

    /**
     * Liste des médicaments
     * @return : l'arraylist de médicaments
     */

    public ArrayList<Medicament> medicaments () {
        return medicaments;
    }
}
