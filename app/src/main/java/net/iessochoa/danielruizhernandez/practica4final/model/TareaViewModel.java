package net.iessochoa.danielruizhernandez.practica4final.model;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class TareaViewModel extends AndroidViewModel {
    //si queremos que la actividad reciba un aviso cuando se modifican los datos, tenemos que crear
    //un LiveData(https://developer.android.com/topic/libraries/architecture/livedata)
    //
    private MutableLiveData<List<Tarea>> listaTareasLiveData;

    private List<Tarea> listaTareas;

    public TareaViewModel(@NonNull Application application) {
        super(application);
        //el liveData nos permitirá recibir notificaciones  en la actividad cuando se modifique la lista
        listaTareasLiveData = new MutableLiveData<List<Tarea>>();
        //creamos unos datos de ejemplo
        crearDatos();
        //avisamos de la modificación con el LiveData
        listaTareasLiveData.setValue(listaTareas);
    }

    public LiveData<List<Tarea>> getUserList() {
        return listaTareasLiveData;
    }

    public void addNota(Tarea tarea) {
        //añadimos una Nota a la lista, si existe(mismo id), la sustituimos
        int i = listaTareas.indexOf(tarea);
        if (i < 0)
            listaTareas.add(tarea);
        else {
            listaTareas.remove(i);
            listaTareas.add(i, tarea);
        }
        //avisamos al LiveData para que active el Observer y la actividad muestre los cambios
        listaTareasLiveData.setValue(listaTareas);
    }

    //Eliminamos segun id
    public void delNota(Tarea tarea) {
        if (listaTareas.size() > 0) {
            listaTareas.remove(tarea);

            listaTareasLiveData.setValue(listaTareas);
        }
    }

    public void delNota() {
        if (listaTareas.size() > 0) {
            listaTareas.remove(0);
            listaTareasLiveData.setValue(listaTareas);
        }
    }

    //Pongo datos aleatorios
    private void crearDatos() {

        listaTareas = new ArrayList<Tarea>();
        Tarea tarea = new Tarea("Abierta", "Mantenimiento", "Alta", "PEPE Madrid", "Actualización de Windows", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris laoreet aliquam sapien, quis mattis diam pretium vel. Integer nec tincidunt turpis. Vestibulum interdum accumsan massa, sed blandit ex fringilla at. Vivamus non sem vitae nisl viverra pharetra. Pellentesque pulvinar vestibulum risus sit amet tempor. Sed blandit arcu sed risus interdum fermentum. Integer ornare lorem urna, eget consequat ante lacinia et. Phasellus ut diam et diam euismod convallis");
        listaTareas.add(tarea);
        tarea = new Tarea("En curso", "Reparación", "Baja", "John Wick", "Actualización de MAC", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris laoreet aliquam sapien, quis mattis diam pretium vel. Integer nec tincidunt turpis. Vestibulum interdum accumsan massa, sed blandit ex fringilla at. Vivamus non sem vitae nisl viverra pharetra. Pellentesque pulvinar vestibulum risus sit amet tempor. Sed blandit arcu sed risus interdum fermentum. Integer ornare lorem urna, eget consequat ante lacinia et. Phasellus ut diam et diam euismod convallis");
        listaTareas.add(tarea);
        tarea = new Tarea("En curso", "Instalación", "Media", "Manuela Perez", "Sustitución de ordenadores", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris laoreet aliquam sapien, quis mattis diam pretium vel. Integer nec tincidunt turpis. Vestibulum interdum accumsan massa, sed blandit ex fringilla at. Vivamus non sem vitae nisl viverra pharetra. Pellentesque pulvinar vestibulum risus sit amet tempor. Sed blandit arcu sed risus interdum fermentum. Integer ornare lorem urna, eget consequat ante lacinia et. Phasellus ut diam et diam euismod convallis");
        listaTareas.add(tarea);
        tarea = new Tarea("Terminada", "Comercial", "Alta", "Aurelio Ruiz", "Venta", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris laoreet aliquam sapien, quis mattis diam pretium vel. Integer nec tincidunt turpis. Vestibulum interdum 9accumsan massa, sed blandit ex fringilla at. Vivamus non sem vitae nisl viverra pharetra. Pellentesque pulvinar vestibulum risus sit amet tempor.Sed blandit arcu sed risus interdum fermentum. Integer ornare lorem urna, eget consequat ante lacinia et. Phasellus ut diam et diam euismod convallis");
        listaTareas.add(tarea);
        tarea = new Tarea("Abierta", "Otros", "Media", "Martin Hernandez", "Presentar presupuesto Web", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris laoreet aliquam sapien, quis mattis diam pretium vel. Integer nec tincidunt turpis. Vestibulum interdum accumsan massa, sed blandit ex fringilla at. Vivamus non sem vitae nisl viverra pharetra. Pellentesque pulvinar vestibulum risus sit amet tempor.Sed blandit arcu sed risus interdum fermentum. Integer ornare lorem urna, eget consequat ante lacinia et. Phasellus ut diam et diam euismod convallis");
        listaTareas.add(tarea);
    }
}
