package org.example.controller;


import org.example.model.Pais;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
public class PaisController {
    private final PaisController paisController;

    public PaisController(PaisController paisController) {
        this.paisController = paisController;
    }
    @
    public ResponseEntity<Pais>
}
