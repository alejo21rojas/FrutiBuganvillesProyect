package com.teambuganvilles.service;

import com.teambuganvilles.exceptions.DomicilioNotFoundException;
import com.teambuganvilles.repository.DomicilioRepository;
import com.teambuganvilles.model.Domicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DomicilioService {
    @Autowired
    private DomicilioRepository domicilioRepository;

    public Optional<Domicilio> getDomicilio(final int id_dom) {
        return domicilioRepository.findById(id_dom);
    }

    public Iterable<Domicilio> getAllDomicilio() {
        return domicilioRepository.findAll();
    }

    public void deleteDomicilio(final int id_dom) {
        domicilioRepository.deleteById(id_dom);
    }

    public Domicilio saveDomicilio(Domicilio domicilio) {
        Domicilio savedDomicilio = domicilioRepository.save(domicilio);
        return savedDomicilio;
    }
    public Domicilio createDomicilio(Domicilio domicilio) {
        Domicilio savedDomicilio = domicilioRepository.save(domicilio);
        return savedDomicilio;
    }

    public Domicilio updateDomicilio(int id_dom, Domicilio newDomicilio) throws DomicilioNotFoundException {
        Optional<Domicilio> currentDomicilioOptional = getDomicilio(id_dom);
        if (currentDomicilioOptional.isPresent()) {
            Domicilio currentDomicilio = currentDomicilioOptional.get();
            currentDomicilio.setId_dom(newDomicilio.getId_dom());
            currentDomicilio.setDireccion(newDomicilio.getDireccion());
            currentDomicilio.setEstado(newDomicilio.getEstado());
            currentDomicilio.setId_venta(newDomicilio.getId_venta());
            saveDomicilio(currentDomicilio);
            return currentDomicilio;
        } else {
            throw new DomicilioNotFoundException(id_dom);
        }
    }
}
