package com.tesis.tse.tse_instructivojrv.modelo;

/**
 * Created by cArLos on 11/6/2017.
 */

public class Actividad {
    private String nombre_fase;
    private String titulo;
    private String descripcion;
    private int imagen;
    private int orden;
    private int id;
    private boolean detalle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Actividad(String nombre_fase, String titulo, String descripcion, int imagen, int orden, boolean detalle,int id) {
        this.nombre_fase = nombre_fase;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.orden = orden;
        this.detalle = detalle;
        this.id = id;
    }

    public String getNombre_fase() {
        return nombre_fase;
    }

    public void setNombre_fase(String nombre_fase) {
        this.nombre_fase = nombre_fase;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public boolean isDetalle() {
        return detalle;
    }

    public void setDetalle(boolean detalle) {
        this.detalle = detalle;
    }
}
