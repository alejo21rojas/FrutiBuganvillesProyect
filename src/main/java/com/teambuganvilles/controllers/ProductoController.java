package com.teambuganvilles.controllers;

import com.teambuganvilles.exceptions.ProductosNotFoundException;
import com.teambuganvilles.model.Productos;
import com.teambuganvilles.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    /**
     * Create - Add a new producto
     *
     * @param producto An object producto
     * @return The producto object saved
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/producto")
    public Productos createProducto(@RequestBody Productos producto) {
        return productoService.saveProducto(producto);
    }

    /**
     * Read - Get one producto
     *
     * @param producto The producto of the producto
     * @return An Producto object full filled
     */
    @GetMapping("/producto/{producto}")
    public Productos getProducto(@PathVariable("producto") final String producto) throws ProductosNotFoundException {
        Optional<Productos> productos = productoService.getProducto(producto);
        if (productos.isPresent()) {
            return productos.get();
        } else {
            throw new ProductosNotFoundException(producto);
        }
    }

    /**
     * Read - Get all productos
     *
     * @return - An Iterable object of Productos full filled
     */
    @GetMapping("/productos")
    public Iterable<Productos> getAllProductos() {
        return productoService.getAllProductos();
    }

    /**
     * Update - Update an existing producto
     *
     * @param producto      - The id of the newProducto to update
     * @param newProducto - The newProducto object updated
     * @return - The newProducto updated
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/producto/{producto}")
    public Productos updateProducto(@PathVariable("producto") final String producto, @RequestBody Productos newProducto) throws ProductosNotFoundException {
        return productoService.updateProducto(producto, newProducto);
    }



    /**
     * Delete - Delete an producto
     *
     * @param producto - The id of the producto to delete
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/producto/{producto}")
    public void deleteProducto(@PathVariable("producto") final String producto) {
        productoService.deleteProductos(producto);
    }
}
