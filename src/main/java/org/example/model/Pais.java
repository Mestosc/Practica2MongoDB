package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Pais")
public class Pais {
    @JsonIgnore
    @Id
    private String id;

    private String nome;
    private TipoPais organizacion;
    private ArrayList<String> partidos;
    private String id_presidente;

    public Pais(String id, String nome, TipoPais organizacion, ArrayList<String> partidos, String id_presidente) {
        this.id = id;
        this.nome = nome;
        this.organizacion = organizacion;
        this.partidos = partidos;
        this.id_presidente = id_presidente;
    }

    public Pais(String nome, TipoPais organizacion, String id_presidente, ArrayList<String> partidos) {
        this.nome = nome;
        this.organizacion = organizacion;
        this.id_presidente = id_presidente;
        this.partidos = partidos;
    }

    public Pais() {}

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

    public TipoPais getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(TipoPais organizacion) {
        this.organizacion = organizacion;
    }

    public ArrayList<String> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<String> partidos) {
        this.partidos = partidos;
    }

    public String getId_presidente() {
        return id_presidente;
    }

    public void setId_presidente(String id_presidente) {
        this.id_presidente = id_presidente;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", organizacion=" + organizacion +
                ", partidos=" + partidos +
                ", id_presidente='" + id_presidente + '\'' +
                '}';
    }
}
