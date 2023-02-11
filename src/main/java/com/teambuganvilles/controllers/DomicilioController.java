package com.teambuganvilles.controllers;

import com.teambuganvilles.exceptions.DomicilioNotFoundException;
import com.teambuganvilles.model.Domicilio;
import com.teambuganvilles.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DomicilioController
{
    @Autowired
    private DomicilioService domicilioService;

    /**
     * Create - Add a new domicilio
     *
     * @param domicilio An object domicilio
     * @return The domimicilio object saved
     */
    @PostMapping("/domicilio")
    public Domicilio createDomicilio(@RequestBody Domicilio domicilio) {
        return domicilioService.saveDomicilio(domicilio);
    }

    /**
     * Read - Get one domicilio
     *
     * @param id_dom The id_dom of the domicilio
     * @return An Domicilio object full filled
     */
    @GetMapping("/domicilio/{id_dom}")
    public Domicilio getDomicilio(@PathVariable("id_dom") final int id_dom) throws DomicilioNotFoundException {
        Optional<Domicilio> domicilio = domicilioService.getDomicilio(id_dom);
        if (domicilio.isPresent()) {
            return domicilio.get();
        } else {
            throw new DomicilioNotFoundException(id_dom);
        }
    }

    /**
     * Read - Get all domicilios
     *
     * @return - An Iterable object of Domicilio full filled
     */
    @GetMapping("/domicilios")
    public Iterable<Domicilio> getAllDomicilios() {
        return domicilioService.getAllDomicilio();
    }

    /**
     * Update - Update an existing domicilio
     *
     * @param id_dom      - The id of the newDomicilio to update
     * @param newDomicilio - The newDomicilio object updated
     * @return - The newDomicilio updated
     */
    @PutMapping("/domicilio/{id_dom}")
    public Domicilio updateDomicilio(@PathVariable("id_dom") final int id_dom, @RequestBody Domicilio newDomicilio) throws DomicilioNotFoundException {
        return domicilioService.updateDomicilio(id_dom, newDomicilio);
    }

    /**
     * Delete - Delete an domicilio
     *
     * @param id_dom - The id of the domicilio to delete
     */
    @DeleteMapping("/domicilio/{id_dom}")
    public void deleteDomicilio(@PathVariable("id_dom") final int id_dom) {
        domicilioService.deleteDomicilio(id_dom);
    }
}
