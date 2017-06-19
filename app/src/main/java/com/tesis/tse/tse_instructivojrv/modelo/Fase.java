package com.tesis.tse.tse_instructivojrv.modelo;

/**
 * Created by cArLos on 18/6/2017.
 */

public class Fase {
    private String nombre;
    private String nombre_tab;
    private int imagen;
    private int id;

    public String getNombre_tab() {
        return nombre_tab;
    }

    public void setNombre_tab(String nombre_tab) {
        this.nombre_tab = nombre_tab;
    }

    public Fase(String nombre, int imagen, int id, String nombre_tab) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.id = id;
        this.nombre_tab = nombre_tab;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
