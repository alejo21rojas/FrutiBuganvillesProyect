package com.teambuganvilles.service;


import com.teambuganvilles.exceptions.ProductosNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.teambuganvilles.repository.ProductosRepository;
import com.teambuganvilles.model.Productos;




@Service
public class ProductoService {
    @Autowired
    private ProductosRepository productosRepository;

    public Optional<Productos> getProducto(final String producto) {
        return productosRepository.findById(producto);
    }

    public Iterable<Productos> getAllProductos() {
        return productosRepository.findAll();
    }

    public void deleteProductos(final String producto) {
        productosRepository.deleteById(producto);
    }

    public Productos saveProducto(Productos producto) {
        Productos savedProducto = productosRepository.save(producto);
        return savedProducto;
    }
    public Productos createProducto(Productos producto) {
        Productos savedProducto = productosRepository.save(producto);
        return savedProducto;
    }

    public Productos updateProducto(String producto, Productos newproducto) throws ProductosNotFoundException {
        Optional<Productos> currentProductoOptional = getProducto(producto);
        if (currentProductoOptional.isPresent()) {
            Productos currentProducto = currentProductoOptional.get();
            currentProducto.setProducto(newproducto.getProducto());
            currentProducto.setCantidad(newproducto.getCantidad());
            currentProducto.setPrecio(newproducto.getPrecio());
            currentProducto.setDescripcion(newproducto.getDescripcion());
            currentProducto.setUrlimg(newproducto.getUrlimg());
            saveProducto(currentProducto);
            return currentProducto;
        } else {
            throw new ProductosNotFoundException(producto);
        }
    }
}
