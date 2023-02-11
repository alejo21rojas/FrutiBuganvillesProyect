package com.teambuganvilles.model;

import javax.persistence.*;

@Entity
@Table(name="productos")
public class Productos {
    @Id
    private String producto;
    private float precio;
    private int cantidad;
    private String descripcion;
    private String urlimg;

    public Productos() {
    }
    public Productos(String producto, float precio, int cantidad, String descripcion, String urlimg) {
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.urlimg = urlimg;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "producto='" + producto + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", descripcion='" + descripcion + '\'' +
                ", urlimg='" + urlimg + '\'' +
                '}';
    }
}
