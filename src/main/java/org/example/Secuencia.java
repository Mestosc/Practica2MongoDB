package org.example;

import org.example.controller.MetodosPresidente;
import org.example.controller.PaisController;
import org.example.model.Pais;
import org.example.model.Presidente;
import org.example.model.TipoPais;
import org.example.services.PaisService;
import org.example.services.PresidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        Presidente presidente = metodosPresidente.anadirPresidente(new Presidente(12,"JEKL","OSLE"));
        Pais[] paises = importarDesdeJSONPais("paises.json");
        for (Pais pais : paises) {
            paisController.anadirPais(pais);
        }
        metodosPresidente.obtenerPresidente(presidente.getId()).ifPresent(System.out::println);
        presidente.setEdade(18);
        metodosPresidente.anadirPresidente(presidente);
        Pais pais = paisController.anadirPais(new Pais("España", TipoPais.monarquiaParlamentaria,presidente.getId(), (java.util.ArrayList<String>) List.of("MEL","lsd","JKEL"))).getBody();
        if (pais!=null) pais.setOrganizacion(TipoPais.democracia);
        paisController.anadirPais(pais);
        if (pais!=null) {
            Pais p = paisController.obtenerPais(pais.getId()).getBody();
            if (p!=null) System.out.println(p);
            paisController.eliminarPais(pais);
        }
        metodosPresidente.eliminarPresidente(presidente);

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
}
