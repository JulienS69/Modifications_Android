package com.example.android_ppe.view;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;


/**
 * Classe DatePickerFragment.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 30/05/2021.
 * Classe permettant de récupérer l'année, le mois et le jour sélectionné.
 */
public class DatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }
    }
