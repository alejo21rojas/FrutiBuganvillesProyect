package com.teambuganvilles.model;

import javax.persistence.*;

@Entity
@Table(name="ventas")
public class Ventas {
    @Id
    private int id_venta;
    @Column(name="fecha")
    private String date;
    private float total;
    private String cliente;

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "id_venta=" + id_venta +
                ", date='" + date + '\'' +
                ", total=" + total +
                ", cliente='" + cliente + '\'' +
                '}';
    }
}
