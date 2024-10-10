package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Medicamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Medicamento {

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

    @Column(name = "fk_detalle_medicamento")
    private Long fk_detalle_medicamento;
}
