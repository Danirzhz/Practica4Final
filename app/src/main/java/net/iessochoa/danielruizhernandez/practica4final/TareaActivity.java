package net.iessochoa.danielruizhernandez.practica4final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import net.iessochoa.danielruizhernandez.practica4final.model.Tarea;

import java.util.Arrays;

public class TareaActivity extends AppCompatActivity {

    Spinner categorias,estados,prioridad;
    EditText tecnicoAsig, breveDesc, descripcion;
    public static Tarea tarea=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        tarea=null;
        super.onCreate(savedInstanceState);
        this.setTitle("Nueva Tarea");

        setContentView(R.layout.activity_anyadir_tarea);

        categorias = findViewById(R.id.spCat);
        ArrayAdapter<CharSequence> adapterCat = ArrayAdapter.createFromResource(this,
                R.array.categoria, android.R.layout.simple_spinner_item);
        categorias.setAdapter(adapterCat);

        estados = findViewById(R.id.spEstado);
        ArrayAdapter<CharSequence> adapterEst = ArrayAdapter.createFromResource(this,
                R.array.estado, android.R.layout.simple_spinner_item);
        estados.setAdapter(adapterEst);

        prioridad = findViewById(R.id.spPrio);
        ArrayAdapter<CharSequence> adapterPrio = ArrayAdapter.createFromResource(this,
                R.array.prioridad, android.R.layout.simple_spinner_item);
        prioridad.setAdapter(adapterPrio);
        prioridad.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        String ele=(String) parent.getItemAtPosition(position);
                        Toast.makeText(getApplicationContext(),getString(R.string.msg_seleccion)+ ele,Toast.LENGTH_LONG).show();
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
        Bundle bundle = getIntent().getExtras();
        tarea = bundle.getParcelable("Datos");
        if (tarea!=null){
            this.setTitle("Editar Tarea "+tarea.getId());
            editarTarea();
        }
    }

    private void editarTarea() {
        tecnicoAsig = findViewById(R.id.tecnicoAsig);
        breveDesc = findViewById(R.id.breveDesc);
        descripcion = findViewById(R.id.descripcion);
        tecnicoAsig.setText(tarea.getTecnico());
        breveDesc.setText(tarea.getResumen());
        descripcion.setText(tarea.getDesc());
        String[] categoria = getResources().getStringArray(R.array.categoria);
        categorias.setSelection(Arrays.asList(categoria).indexOf(tarea.getCategoria()));
        String[] estado = getResources().getStringArray(R.array.estado);
        estados.setSelection(Arrays.asList(estado).indexOf(tarea.getEstado()));
        String[] priori = getResources().getStringArray(R.array.prioridad);
        prioridad.setSelection(Arrays.asList(priori).indexOf(tarea.getPrioridad()));
    }

    /**Spinner categorias,estados,prioridad;
     EditText tecnicoAsig, breveDesc, descripcion**/
    public void Guardar(View v){

        tecnicoAsig = findViewById(R.id.tecnicoAsig);
        breveDesc = findViewById(R.id.breveDesc);
        descripcion = findViewById(R.id.descripcion);
        String cat = (String) categorias.getSelectedItem();
        String est = (String) estados.getSelectedItem();
        String prio = (String) prioridad.getSelectedItem();
        String tec = String.valueOf(tecnicoAsig.getText());
        String brev = String.valueOf(breveDesc.getText());
        String descrip = String.valueOf(descripcion.getText());

        if (!cat.equals("") || !est.equals("") || !prio.equals("") || !tec.equals("")|| !brev.equals("")|| !descrip.equals("")){
            if (tarea!=null && tarea.getTecnico()!=null && tarea.getResumen()!=null){
                tarea.setCategoria(cat);
                tarea.setEstado(est);
                tarea.setPrioridad(prio);
                tarea.setDesc(descrip);
                tarea.setResumen(brev);
                tarea.setTecnico(tec);
            }
            else
                tarea = new Tarea(est,cat,prio,tec,brev,descrip);
            Intent iBack = getIntent();
            iBack.putExtra("Datos", String.valueOf(tarea));
            setResult(RESULT_OK,iBack);
        }else{
            setResult(RESULT_CANCELED);
        }
        finish();
        tarea=null;
    }
}