package net.iessochoa.danielruizhernandez.practica4final;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

//Creo que el dialogo acercaDe aparte
public class DialogoAlerta extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("Práctica 4\n" +
                "V 1.0\n" +
                "Daniel Ruiz Hernandez\n" +
                "Licencia cc " + " (Creative Commons)")
                .setTitle("Acerca de...")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
