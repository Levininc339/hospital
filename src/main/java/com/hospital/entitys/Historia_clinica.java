package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "historia_clinica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Historia_clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long fk_persona;
    private Long fk_profesional;
    private Long fk_diagnostico_r;
    private Date fecha_creacion_historia;
    private Long fk_centro_atencion_historia;
    private Boolean estado_sistema_historia;
    private Long fk_diagnostico;
    private Date fecha_creacion;
    private Long fk_centro_atencion;
    private Boolean estado_sistema;
}
