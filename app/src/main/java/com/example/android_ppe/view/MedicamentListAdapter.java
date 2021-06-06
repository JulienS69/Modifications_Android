package com.example.android_ppe.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android_ppe.R;
import com.example.android_ppe.model.Medicament;

import java.util.ArrayList;


/**
 * Classe MedicamentListAdapter.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/05/2021.
 * Classe permettant de récupérer les médicaments de la bdd dans les textView de layout_liste_medicaments
 * Aide à l'affichage de la liste dans un listview
 */
public class MedicamentListAdapter extends BaseAdapter {

    private ArrayList<Medicament> lesMedicaments;
    private LayoutInflater inflater;

    public MedicamentListAdapter(Context context, ArrayList<Medicament> lesMedicaments){
        this.lesMedicaments = lesMedicaments;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return lesMedicaments.size();
    }

    @Override
    public Object getItem(int position) {
        return lesMedicaments.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.layout_liste_medicaments, null);
            holder.txtNomCommercial = (TextView) convertView.findViewById(R.id.txtListNomCommercial);
            holder.txtEffet = (TextView) convertView.findViewById(R.id.txtListEffet);
            holder.txtPrix = (TextView) convertView.findViewById(R.id.txtListPrixEchant);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtNomCommercial.setText(lesMedicaments.get(position).getMNomCommercial());
        holder.txtEffet.setText(lesMedicaments.get(position).getMEffet());
        holder.txtPrix.setText(Double.toString(lesMedicaments.get(position).getMPrixEchant()));
        return convertView;
    }
    private class ViewHolder{
        TextView txtNomCommercial;
        TextView txtEffet;
        TextView txtPrix;

    }
}
