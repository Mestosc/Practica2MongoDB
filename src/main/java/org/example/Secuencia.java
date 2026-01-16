package org.example;

import org.example.controller.MetodosPresidente;
import org.example.controller.PaisController;
import org.example.model.Pais;
import org.example.model.Presidente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

@Service
public class Secuencia {
    MetodosPresidente metodosPresidente;
    PaisController paisController;
    @Autowired
    public Secuencia(MetodosPresidente metodosPresidente, PaisController paisController) {
        this.metodosPresidente = metodosPresidente;
        this.paisController = paisController;
    }
    public void ejecutarSecuencia() {
        Presidente[] presidentes = importarDesdeJSONPresidente("presidentes.json");
        for (Presidente presidente : presidentes) {
            metodosPresidente.anadirPresidente(presidente);
        }
        Pais[] paises = importarDesdeJSONPais("paises.json");
        for (Pais pais : paises) {
            paisController.anadirPais(pais);
        }

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
