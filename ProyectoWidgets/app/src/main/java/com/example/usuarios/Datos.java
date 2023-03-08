package com.example.usuarios;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Datos implements Serializable {

    private String nombre;

    private String fecha;

    private String email;

    private String spinner;

    private List<String> aficiones;

    private String recomendacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpinner() {
        return spinner;
    }

    public void setSpinner(String spinner) {
        this.spinner = spinner;
    }

    public List<String> getAficiones() {
        return aficiones;
    }

    public void setAficiones(List<String> aficiones) {
        this.aficiones = aficiones;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
}
