package com.teambuganvilles.model;

import javax.persistence.*;

@Entity
@Table(name="detalle_venta")

public class Detalle_Venta {
    @Id
    private int id_dv;
    private String producto;
    private int id_venta;
    private float subtotal;
    private int cantidad;

    public Detalle_Venta(){
    }
    public Detalle_Venta(int id_dv, String producto, int id_venta, float subtotal, int cantidad) {
        this.id_dv = id_dv;
        this.producto = producto;
        this.id_venta = id_venta;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
    }

    public int getId_dv() {
        return id_dv;
    }

    public void setId_dv(int id_dv) {
        this.id_dv = id_dv;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Detalle_Venta{" +
                "id_dv=" + id_dv +
                ", producto='" + producto + '\'' +
                ", id_venta=" + id_venta +
                ", subtotal=" + subtotal +
                ", cantidad=" + cantidad +
                '}';
    }
}
