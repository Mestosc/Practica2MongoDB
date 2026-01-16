package org.example;

import org.example.services.PaisService;
import org.example.services.PresidenteService;
import org.example.model.Pais;
import org.example.model.Presidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

@Service
public class Secuencia {
    private final PresidenteService presidenteService;
    private final PaisService paisService;
    @Autowired
    public Secuencia(PresidenteService presidenteService, PaisService paisService) {
        this.presidenteService = presidenteService;
        this.paisService = paisService;
    }
    public void ejecutarSecuencia() {
        Presidente[] presidentes = importarDesdeJSONPresidente("presidentes.json");
        for (Presidente presidente : presidentes) {
            presidenteService.anadirPresidente(presidente);
        }
        Pais[] paises = importarDesdeJSONPais("paises.json");
        for (Pais pais : paises) {
            paisService.anadirPais(pais);
        }
        paises[0].setNome("Republica Propia");
        paisService.anadirPais(paises[0]);
        paisService.eliminarPais(paises[1].getId());
        presidenteService.eliminarPresidente(presidentes[2].getId());
    }
    public Pais[] importarDesdeJSONPais(String archivoJSON) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(archivoJSON), Pais[].class);
        } catch (IOException e) {
            System.err.println("Error al importar el JSON: " + e.getMessage());
            return new Pais[0];
        }
    }
    public Presidente[] importarDesdeJSONPresidente(String archivoJSON) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(archivoJSON), Presidente[].class);
        } catch (IOException e) {
            System.err.println("Error al importar el JSON: " + e.getMessage());
            return new Presidente[0];
        }
    }
}
