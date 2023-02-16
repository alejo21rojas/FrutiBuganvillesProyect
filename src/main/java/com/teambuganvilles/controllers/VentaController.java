package com.teambuganvilles.controllers;


import com.teambuganvilles.exceptions.VentasNotFoundException;
import com.teambuganvilles.model.Ventas;
import com.teambuganvilles.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
public class VentaController {
    @Autowired
    private VentasService ventasService;

    /**
     * Create - Add a new venta
     *
     * @param venta An object venta
     * @return The ventas object saved
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/venta")
    public Ventas createVenta(@RequestBody Ventas venta) {
        return ventasService.saveVenta(venta);
    }

    /**
     * Read - Get one venta
     *
     * @param id_venta The id of the venta
     * @return An Ventas object full filled
     */
    @GetMapping("/venta/{id_venta}")
    public Ventas getItem(@PathVariable("id_venta") final int id_venta) throws VentasNotFoundException {
        Optional<Ventas> venta = ventasService.getVentas(id_venta);
        if (venta.isPresent()) {
            return venta.get();
        } else {
            throw new VentasNotFoundException(id_venta);
        }
    }


    /**
     * Read - Get all ventas
     *
     * @return - An Iterable object of Ventas full filled
     */
    @GetMapping("/ventas")
    public Iterable<Ventas> getAllVenta() {
        return ventasService.getAllVentas();
    }

    /**
     * Update - Update an existing venta
     *
     * @param id_venta      - The id of the newVenta to update
     * @param newVenta - The newVenta object updated
     * @return - The newVenta updated
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/venta/{id_venta}")
    public Ventas updateVenta(@PathVariable("id_venta") final String id_venta, @RequestBody Ventas newVenta) throws VentasNotFoundException{
        return ventasService.updateVenta(Integer.parseInt(id_venta), newVenta);
    }

    /**
     * Delete - Delete an venta
     *
     * @param id_venta - The id of the venta to delete
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/venta/{id_venta}")
    public void deleteVenta(@PathVariable("id_venta") final int id_venta) {
        ventasService.deleteVenta(id_venta);
    }
}
