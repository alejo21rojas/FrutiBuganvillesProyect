package com.teambuganvilles.controllers;

import com.teambuganvilles.exceptions.DetalleVentaNotFoundException;
import com.teambuganvilles.model.Detalle_Venta;
import com.teambuganvilles.service.DetalleVenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Detalle_VenController {
    @Autowired
    private DetalleVenService detalleVenService;
    /**
     * Create - Add a new detalleVent
     *
     * @param detalleVenta An object detalleVenta
     * @return The detalleVenta object saved
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/detalleVenta")
    public Detalle_Venta createDetalleVen(@RequestBody Detalle_Venta detalleVenta) {
        return detalleVenService.saveDetalleVenta(detalleVenta);
    }

    /**
     * Read - Get one detalleVenta
     *
     * @param id_dv The id_dv of the detalleVenta
     * @return An Detalle_Venta object full filled
     */
    @GetMapping("/detalleVenta/{id_dv}")
    public Detalle_Venta getDetalleVenta(@PathVariable("id_dv") final int id_dv) throws DetalleVentaNotFoundException {
        Optional<Detalle_Venta> detalleVenta = detalleVenService.getDetalleVenta(id_dv);
        if (detalleVenta.isPresent()) {
            return detalleVenta.get();
        } else {
            throw new DetalleVentaNotFoundException(id_dv);
        }
    }

    /**
     * Read - Get all detalleVentas
     *
     * @return - An Iterable object of Detalle_Venta full filled
     */
    @GetMapping("/detalleVentas")
    public Iterable<Detalle_Venta> getAllDetalleVentas() {
        return detalleVenService.getAllDetalleVenta();
    }

    /**
     * Update - Update an existing detalleVenta
     *
     * @param id_dv      - The id of the newDetalleVenta to update
     * @param newDetalleVenta - The newDetalleVenta object updated
     * @return - The newDetalleVenta updated
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/detalleVenta/{id_dv}")
    public Detalle_Venta updateDetalleVenta(@PathVariable("id_dv") final int id_dv, @RequestBody Detalle_Venta newDetalleVenta) throws DetalleVentaNotFoundException {
        return detalleVenService.updateDetalleVenta(id_dv, newDetalleVenta);
    }

    /**
     * Delete - Delete an detalleVenta
     *
     * @param id_dv - The id of the detalleVenta to delete
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/detalleVenta/{id_dv}")
    public void deleteDetalleVenta(@PathVariable("id_dv") final int id_dv) {
        detalleVenService.deleteDetalleVenta(id_dv);
    }
}
