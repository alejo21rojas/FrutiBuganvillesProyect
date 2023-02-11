package com.teambuganvilles.model;

import javax.persistence.*;

@Entity
@Table(name="domicilio")
public class Domicilio {
    @Id
    private int id_dom;
    private String estado;
    private String direccion;
    private int id_venta; //se agrego id venta modificar
    public Domicilio(){
    }
    public Domicilio(int id_dom, String estado, String direccion, int id_venta) {
        this.id_dom = id_dom;
        this.estado = estado;
        this.direccion = direccion;
        this.id_venta = id_venta;
    }

    public int getId_dom() {
        return id_dom;
    }

    public void setId_dom(int id_dom) {
        this.id_dom = id_dom;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "id_dom=" + id_dom +
                ", estado='" + estado + '\'' +
                ", direccion='" + direccion + '\'' +
                ", id_venta=" + id_venta +
                '}';
    }
}
