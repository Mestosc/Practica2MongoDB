package org.example.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Pais;
import org.example.services.PaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pais")
public class PaisController {
    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }
    @Operation(summary = "Añadir un nuevo pais")
    @PostMapping("/anadirPais")
    public ResponseEntity<Pais> anadirPais(@RequestBody Pais pais) {
        paisService.anadirPais(pais);
        return paisService.obtenerPais(pais.getId()).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.internalServerError().build());
    }
    @DeleteMapping("/eliminarPais")
    @Operation(summary = "Eliminar un pais")
    public ResponseEntity<Pais> eliminarPais(@RequestBody Pais pais) {
        return paisService.obtenerPais(pais.getId()).map(pais1 -> {paisService.eliminarPais(pais1);return ResponseEntity.ok(pais1);}).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @GetMapping("/obtenerPais")
    public ResponseEntity<Pais> obtenerPais(String id) {
        return paisService.obtenerPais(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
