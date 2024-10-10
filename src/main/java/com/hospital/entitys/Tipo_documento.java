package com.hospital.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_documentos")
public class Tipo_documento {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String sigla;
    private String descripcion;

    public Tipo_documento() {
    }

    public Tipo_documento(int id, String sigla, String descripcion) {
        this.id = id;
        this.sigla = sigla;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
