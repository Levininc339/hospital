package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enfermedades")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Enfermedades {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion_enfermedad")
    private String descripcion_enfermedad;

    @Column(name = "fk_tratamiento")
    private Tratamiento fk_tratamiento;
}
