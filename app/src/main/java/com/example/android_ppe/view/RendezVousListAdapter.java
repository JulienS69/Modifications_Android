package com.example.android_ppe.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.android_ppe.R;
import com.example.android_ppe.model.RendezVous;

import java.util.ArrayList;

/**
 * Classe RendezVousListAdapter.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/05/2021.
 * Classe permettant de récupérer les rendez-vous de la bdd dans les textView de layout_liste_rendez-vous
 * Aide à l'affichage de la liste dans un listview
 */

public class RendezVousListAdapter extends BaseAdapter {

    private ArrayList<RendezVous> lesRendezvous;
    private LayoutInflater inflater;

    public RendezVousListAdapter(Context context, ArrayList<RendezVous> lesrendezvous){
        this.lesRendezvous = lesrendezvous;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return lesRendezvous.size();
    }

    @Override
    public Object getItem(int position) {
        return lesRendezvous.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RendezVousListAdapter.ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.layout_liste_rendez_vous, null);
            holder.txtnumerordv = (TextView) convertView.findViewById(R.id.txtnumerordv);
            holder.txtdaterdv = (TextView) convertView.findViewById(R.id.txtdaterdv);
            holder.txtheure = (TextView) convertView.findViewById(R.id.txtheure);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtnumerordv.setText(Integer.toString(lesRendezvous.get(position).getNumero()));
        holder.txtdaterdv.setText(lesRendezvous.get(position).getDate());
        holder.txtheure.setText(lesRendezvous.get(position).getHeure());
        return convertView;
    }
    private class ViewHolder{
        TextView txtnumerordv;
        TextView txtdaterdv;
        TextView txtheure;

    }
}
