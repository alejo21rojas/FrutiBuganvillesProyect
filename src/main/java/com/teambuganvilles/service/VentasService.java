package com.teambuganvilles.service;


import com.teambuganvilles.exceptions.VentasNotFoundException;
import com.teambuganvilles.repository.VentasRepository;
import com.teambuganvilles.model.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VentasService {
    @Autowired
    private VentasRepository ventasRepository;

    public Optional<Ventas> getVentas(final int id_venta) {

        return ventasRepository.findById(id_venta);
    }

    public Iterable<Ventas> getAllVentas() {
        return ventasRepository.findAll();
    }

    public void deleteVenta(final int id_venta) {
        ventasRepository.deleteById(id_venta);
    }

    public Ventas saveVenta(Ventas venta) {
        Ventas savedVenta =ventasRepository.save(venta);
        return savedVenta;
    }

    public Ventas updateVenta(int id_venta, Ventas newVenta) throws VentasNotFoundException {
        Optional<Ventas> currentVentaOptional = getVentas(id_venta);
        if (currentVentaOptional.isPresent()) {
            Ventas currentVentas = currentVentaOptional.get();
            currentVentas.setId_venta(newVenta.getId_venta());
            currentVentas.setTotal(newVenta.getTotal());
            currentVentas.setDate(newVenta.getDate());
            currentVentas.setCliente(newVenta.getCliente());
            saveVenta(currentVentas);
            return currentVentas;
        } else {
            throw new VentasNotFoundException(id_venta);
        }
    }
}
