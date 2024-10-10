package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "diagnosticos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion_diagnostico")
    private String descripcion_diagnostico;

    @Column(name = "fk_enfermedades_diag")
    private Long fk_enfermedades_diag;

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @Column(name = "fecha_actualizacion")
    private Date fecha_actualizacion;
}
