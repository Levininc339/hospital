package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "historia_clinica")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Historia_clinica {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_persona", referencedColumnName = "id")
    private Persona fk_persona;
    @ManyToOne
    @JoinColumn(name = "fk_profesional", referencedColumnName = "id")
    private Persona fk_profesional;
    @ManyToOne
    @JoinColumn(name = "fk_diagnostico_r", referencedColumnName = "id")
    private Diagnostico fk_diagnostico_r;
    private Date fecha_creacion_historia;
    @ManyToOne
    @JoinColumn(name = "fk_centro_atencion_historia", referencedColumnName = "id")
    private Centros_atencion fk_centro_atencion_historia;
    private Boolean estado_sistema_historia;
}
