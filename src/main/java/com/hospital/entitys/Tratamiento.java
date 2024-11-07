package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tratamientos")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tratamiento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "fk_medicamento", referencedColumnName = "id")
    private Medicamento fk_medicamento;

}
