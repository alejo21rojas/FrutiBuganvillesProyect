package com.teambuganvilles.controllers;


import com.teambuganvilles.exceptions.CarritoNotFoundException;
import com.teambuganvilles.model.Carrito;
import com.teambuganvilles.service.CarritoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
public class CarritoController
{
    @Autowired
    private CarritoService carritoService;


    @PostMapping("/carrito")
    public Carrito createCarrito(@RequestBody Carrito carrito) {
        return carritoService.saveCarrito(carrito);
    }

    @GetMapping("/carrito/{cliente}")
    public Carrito getItemCarrito(@PathVariable("cliente") final int cliente) throws CarritoNotFoundException {
        Optional<Carrito> carrito = carritoService.getCarritos(cliente);
        if (carrito.isPresent()) {
            return carrito.get();
        } else {
            throw new CarritoNotFoundException(cliente);
        }
    }

    @GetMapping("/carritos")
    public Iterable<Carrito> getAllCarrito() {
        return carritoService.getAllCarritos();
    }


    @PutMapping("/carrito/{cliente}")
    public Carrito updateCarrito(@PathVariable("cliente") final String cliente, @RequestBody Carrito newCarrito) throws CarritoNotFoundException{
        return carritoService.updateCarrito(Integer.parseInt(cliente), newCarrito);
    }

    @DeleteMapping("/carrito/{cliente}")
    public void deleteCarrito(@PathVariable("cliente") final int cliente) {
        carritoService.deleteCarrito(cliente);
    }
}
