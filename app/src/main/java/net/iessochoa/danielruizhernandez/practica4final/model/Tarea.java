package net.iessochoa.danielruizhernandez.practica4final.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Objects;

public class Tarea implements Parcelable {
    static int CONTADOR=1;
    private int id;
    private String estado;
    private String categoria;
    private String prioridad;
    private String tecnico;
    private String resumen;
    private String desc;

    public Tarea(String estado, String categoria, String prioridad, String tecnico, String resumen, String desc) {
        this.id = CONTADOR++;
        this.estado = estado;
        this.categoria = categoria;
        this.prioridad = prioridad;
        this.tecnico = tecnico;
        this.resumen = resumen;
        this.desc = desc;
    }


    public int getId() {        return id;    }

    public void setId(int id) {        this.id = id;    }

    public String getEstado() {        return estado;    }

    public void setEstado(String estado) {        this.estado = estado;    }

    public String getCategoria() {        return categoria;    }

    public void setCategoria(String categoria) {        this.categoria = categoria;    }

    public String getPrioridad() {        return prioridad;    }

    public void setPrioridad(String prioridad) {        this.prioridad = prioridad;    }

    public String getTecnico() {        return tecnico;    }

    public void setTecnico(String tecnico) {        this.tecnico = tecnico;    }

    public String getResumen() {        return resumen;    }

    public void setResumen(String resumen) {        this.resumen = resumen;    }

    public String getDesc() {        return desc;    }

    public void setDesc(String desc) {        this.desc = desc;    }




////Parcelable//////


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.estado);
        dest.writeString(this.categoria);
        dest.writeString(this.prioridad);
        dest.writeString(this.tecnico);
        dest.writeString(this.resumen);
        dest.writeString(this.desc);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.estado = source.readString();
        this.categoria = source.readString();
        this.prioridad = source.readString();
        this.tecnico = source.readString();
        this.resumen = source.readString();
        this.desc = source.readString();
    }

    protected Tarea(Parcel in) {
        this.id = in.readInt();
        this.estado = in.readString();
        this.categoria = in.readString();
        this.prioridad = in.readString();
        this.tecnico = in.readString();
        this.resumen = in.readString();
        this.desc = in.readString();
    }

    public static final Parcelable.Creator<Tarea> CREATOR = new Parcelable.Creator<Tarea>() {
        @Override
        public Tarea createFromParcel(Parcel source) {
            return new Tarea(source);
        }

        @Override
        public Tarea[] newArray(int size) {
            return new Tarea[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarea)) return false;
        Tarea tarea = (Tarea) o;
        return id == tarea.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
