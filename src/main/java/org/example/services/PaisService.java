package org.example.services;

import org.example.model.Pais;
import org.example.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaisService {
    private final PaisRepository repository;

    @Autowired
    public PaisService(PaisRepository repository) {
        this.repository = repository;
    }
    public void anadirPais(Pais pais) {
        repository.save(pais);
    }
    public void eliminarPais(Pais pais) {
        repository.delete(pais);
    }
    public void eliminarPais(String id) {
        repository.findById(id).ifPresent(repository::delete);
    }
    public Optional<Pais> obtenerPais(String id) {
        return repository.findById(id);
    }
}
