package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "diagnosticos")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Diagnostico {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion_diagnostico")
    private String descripcion_diagnostico;

    @Column(name = "fk_enfermedades_diag")
    private Diagnostico_enfermedades fk_enfermedades_diag;

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @Column(name = "fecha_actualizacion")
    private Date fecha_actualizacion;
}
