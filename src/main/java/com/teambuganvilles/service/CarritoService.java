package com.teambuganvilles.service;

import com.teambuganvilles.exceptions.CarritoNotFoundException;
import com.teambuganvilles.model.Carrito;
import com.teambuganvilles.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    public Optional<Carrito> getCarritos(final int cliente) {

        return carritoRepository.findById(cliente);
    }

    public Iterable<Carrito> getAllCarritos() {
        return carritoRepository.findAll();
    }

    public void deleteCarrito(final int cliente) {
        carritoRepository.deleteById(cliente);
    }

    public Carrito saveCarrito(Carrito carrito) {
        Carrito savedCarrito = carritoRepository.save(carrito);
        return savedCarrito;
    }

    public Carrito updateCarrito(int cliente, Carrito newCarrito) throws CarritoNotFoundException {
        Optional<Carrito> currentCarritoOptional = getCarritos(cliente);
        if (currentCarritoOptional.isPresent()) {
            Carrito currentCarrito = currentCarritoOptional.get();
            currentCarrito.setProducto(newCarrito.getProducto());
            currentCarrito.setCantidad(newCarrito.getCantidad());
            currentCarrito.setPrecio(newCarrito.getPrecio());
            currentCarrito.setTotal(newCarrito.getTotal());
            currentCarrito.setCliente(newCarrito.getCliente());
            saveCarrito(currentCarrito);
            return currentCarrito;
        } else {
            throw new CarritoNotFoundException(cliente);
        }
    }
}
