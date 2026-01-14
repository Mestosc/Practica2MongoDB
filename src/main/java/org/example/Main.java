package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class Main {
    private final Secuencia secuencia;

    public Main(Secuencia secuencia) {
        this.secuencia = secuencia;
    }
    @PostConstruct
    public void ejecutarSecuencia() {
        secuencia.ejecutarSecuencia();
        System.exit(200);
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}