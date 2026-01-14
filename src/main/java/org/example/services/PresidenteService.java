package org.example.services;

import org.example.model.Presidente;
import org.example.repository.PresidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PresidenteService {
    private final PresidenteRepository presidenteRepository;
    @Autowired
    public PresidenteService(PresidenteRepository presidenteRepository) {
        this.presidenteRepository = presidenteRepository;
    }
    public Optional<Presidente> obtenerPresidente(String id) {
        return presidenteRepository.findById(id);
    }
    public void anadirPresidente(Presidente presidente) {
        presidenteRepository.save(presidente);
    }
    public void eliminarPresidente(String id) {
        presidenteRepository.findById(id).ifPresent(presidenteRepository::delete);
    }
    public void eliminarPresidente(Presidente presidente) {
        presidenteRepository.delete(presidente);
    }
}
