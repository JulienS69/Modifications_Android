package com.example.android_ppe.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Classe RendezVous.
  * @author : Julien. SEUX.
  * created on  31/01/2021.
  * modified on 01/02/2021.
 * Classe métier, implémente Parcelable pour pouvoir afficher un rendez-vous dans l'IHM
 */
public class RendezVous implements Parcelable {
    private int numero;
    private String dateRdv;
    private String heure;
    private com.example.android_ppe.model.Praticien praticien;

    /**
     * Constructeur.
     * @param numero
     * @param dateRdv
     * @param heure
     * @param praticien
     */
    public RendezVous(int numero, String dateRdv, String heure, com.example.android_ppe.model.Praticien praticien) {
        this.numero = numero;
        this.dateRdv = dateRdv;
        this.heure = heure;
        this.praticien = praticien;
    }

    protected RendezVous(Parcel in) {
        numero = in.readInt();
        dateRdv = in.readString();
        heure = in.readString();
        praticien = in.readParcelable(com.example.android_ppe.model.Praticien.class.getClassLoader());
    }

    public static final Creator<RendezVous> CREATOR = new Creator<RendezVous>() {
        @Override
        public com.example.android_ppe.model.RendezVous createFromParcel(Parcel in) {
            return new com.example.android_ppe.model.RendezVous(in);
        }

        @Override
        public com.example.android_ppe.model.RendezVous[] newArray(int size) {
            return new com.example.android_ppe.model.RendezVous[size];
        }
    };

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDate() {
        return dateRdv;
    }

    public void setDate(String date) {
        this.dateRdv = dateRdv;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public com.example.android_ppe.model.Praticien getPraticien() {
        return praticien;
    }

    public void setPraticien(com.example.android_ppe.model.Praticien praticien) {
        this.praticien = praticien;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getNumero());
        dest.writeString(getDate());
        dest.writeString(getHeure());
        dest.writeParcelable(getPraticien(), flags);
    }
}
