package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "tipo_documentos")
@Builder
public class Tipo_documento {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String sigla;
    private String descripcion;

    public Tipo_documento() {
    }

    public Tipo_documento(Long id, String sigla, String descripcion) {
        this.id = id;
        this.sigla = sigla;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
