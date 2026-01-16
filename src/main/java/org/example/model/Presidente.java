package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Presidente")
public class Presidente {

    @Id
    private String id;
    private String nome;
    private int edade;
    private String partido;

    public Presidente(String id, String nome, int edade, String partido) {
        this.id = id;
        this.nome = nome;
        this.edade = edade;
        this.partido = partido;
    }

    public Presidente(int edade, String partido, String nome) {
        this.edade = edade;
        this.partido = partido;
        this.nome = nome;
    }

    public Presidente() {}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEdade() {
        return edade;
    }

    public void setEdade(int edade) {
        this.edade = edade;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    @Override
    public String toString() {
        return "Presidente{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", edade=" + edade +
                ", partido='" + partido + '\'' +
                '}';
    }
}
