package org.example.controller;

import org.example.model.Presidente;
import org.example.services.PresidenteService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Component
public class MetodosPresidente {
    private final PresidenteService presidenteService;

    public MetodosPresidente(PresidenteService presidenteService) {
        this.presidenteService = presidenteService;
    }

    public Presidente anadirPresidente(Presidente presidente) {
        presidenteService.anadirPresidente(presidente);
        return presidente;
    }
    public void eliminarPresidente(Presidente presidente) {
        presidenteService.eliminarPresidente(presidente);
    }
    public void eliminarPresidente(String id) {
        presidenteService.eliminarPresidente(id);
    }
    public Optional<Presidente> obtenerPresidente(String id) {
        return presidenteService.obtenerPresidente(id);
    }
}
