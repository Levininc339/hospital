package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "enfermedades")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Enfermedades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion_enfermedad")
    private String descripcion_enfermedad;

    @Column(name = "fk_tratamiento")
    private Long fk_tratamiento;
}
