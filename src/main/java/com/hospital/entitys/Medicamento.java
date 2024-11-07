package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Medicamentos")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class Medicamento {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @Column(name = "fecha_vencimiento")
    private Date fecha_vencimiento;

    @ManyToOne
    @JoinColumn(name = "fk_detalle_medicamento", referencedColumnName = "id")
    private Detalle_medicamentos fk_detalle_medicamento;
}
