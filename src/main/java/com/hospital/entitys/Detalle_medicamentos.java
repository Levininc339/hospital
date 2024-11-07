package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_medicamentos")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Detalle_medicamentos {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "farmaceutica")
    private String farmaceutica;

    @Column(name = "via_administracion")
    private String via_administracion;
}
