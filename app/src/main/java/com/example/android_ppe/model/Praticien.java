package com.example.android_ppe.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Classe Praticien.
 * @author : Julien. SEUX.
 * created on  31/01/2021.
 * modified on 25/04/2021.
 * Classe métier, implémente Parcelable pour pouvoir afficher un praticien dans l'IHM
 */
public class Praticien implements Parcelable {
    private int numero;
    private String nom;
    private String prenom;
    private String adresse;
    private String codepostal;
    private String ville;
    private String telephone;
    private int mdp;
    private int coefnotoriete;

    /**
     * Constructeur.
     * @param numero
     * @param nom
     * @param prenom
     * @param adresse
     * @param codepostal
     * @param ville
     * @param telephone
     * @param coefnotoriete
     */
    public Praticien(int numero, String nom, String prenom, String adresse, String codepostal, String ville, String telephone, int mdp, int coefnotoriete) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codepostal = codepostal;
        this.ville = ville;
        this.telephone = telephone;
        this.mdp = mdp;
        this.coefnotoriete = coefnotoriete;
    }

    protected Praticien(Parcel in) {
        numero = in.readInt();
        nom = in.readString();
        prenom = in.readString();
        adresse = in.readString();
        codepostal = in.readString();
        ville = in.readString();
        telephone = in.readString();
        mdp = in.readInt();
        coefnotoriete = in.readInt();
    }

    public static final Creator<Praticien> CREATOR = new Creator<Praticien>() {
        @Override
        public com.example.android_ppe.model.Praticien createFromParcel(Parcel in) {
            return new com.example.android_ppe.model.Praticien(in);
        }

        @Override
        public com.example.android_ppe.model.Praticien[] newArray(int size) {
            return new com.example.android_ppe.model.Praticien[size];
        }
    };

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getCoefnotoriete() {
        return coefnotoriete;
    }

    public void setCoefnotoriete(int coefnotoriete) {
        this.coefnotoriete = coefnotoriete;
    }

    public int getMdp() {
        return mdp;
    }

    public void setMdp(int mdp) {
        this.mdp = mdp;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numero);
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(adresse);
        dest.writeString(codepostal);
        dest.writeString(ville);
        dest.writeString(telephone);
        dest.writeInt(coefnotoriete);
    }
}
