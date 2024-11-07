package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_personas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Tipo_persona {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;
}
