package com.tesis.tse.tse_instructivojrv.modelo;

/**
 * Created by cArLos on 25/6/2017.
 */

public class Detalle {
    private int id;
    private String texto;
    private int imagen;
    private int orden;

    public Detalle(int id, String texto, int imagen, int orden) {
        this.id = id;
        this.texto = texto;
        this.imagen = imagen;
        this.orden = orden;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
}
