package com.teambuganvilles.service;

import com.teambuganvilles.exceptions.DetalleVentaNotFoundException;
import com.teambuganvilles.repository.Detalle_VenRepository;
import com.teambuganvilles.model.Detalle_Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetalleVenService {
    @Autowired
    private Detalle_VenRepository detalleVenRepository;

    public Optional<Detalle_Venta> getDetalleVenta(final int id_dv) {
        return detalleVenRepository.findById(id_dv);
    }

    public Iterable<Detalle_Venta> getAllDetalleVenta() {
        return detalleVenRepository.findAll();
    }

    public void deleteDetalleVenta(final int id_dv) {
        detalleVenRepository.deleteById(id_dv);
    }

    public Detalle_Venta saveDetalleVenta(Detalle_Venta detalleVenta) {
        Detalle_Venta saveDetalleVenta = detalleVenRepository.save(detalleVenta);
        return saveDetalleVenta;
    }
    public Detalle_Venta createDetalleVenta(Detalle_Venta detalleVenta) {
        Detalle_Venta saveDetalleVenta = detalleVenRepository.save(detalleVenta);
        return saveDetalleVenta;
    }

    public Detalle_Venta updateDetalleVenta(int id_dv, Detalle_Venta newDetalleVen) throws DetalleVentaNotFoundException {
        Optional<Detalle_Venta> currentDetalleVenOptional = getDetalleVenta(id_dv);
        if (currentDetalleVenOptional.isPresent()) {
            Detalle_Venta currentDetalleVen = currentDetalleVenOptional.get();
            currentDetalleVen.setId_dv(newDetalleVen.getId_dv());
            currentDetalleVen.setId_venta(newDetalleVen.getId_venta());
            currentDetalleVen.setProducto(newDetalleVen.getProducto());
            currentDetalleVen.setCantidad(newDetalleVen.getCantidad());
            currentDetalleVen.setSubtotal(newDetalleVen.getSubtotal());
            saveDetalleVenta(currentDetalleVen);
            return currentDetalleVen;
        } else {
            throw new DetalleVentaNotFoundException(id_dv);
        }
    }
}
