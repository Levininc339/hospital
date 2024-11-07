package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "personas") //persistence
@Getter //Lombok
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Persona {
    private static final long serialVersionUID = 1L;//objeto Java

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "nombres")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "fk_tipo_documentos", referencedColumnName = "id")
    private Tipo_documento fk_tipo_documentos;

    @Column(name = "documento")
    private String documento;

    @Column(name = "direccion")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "fk_tipo_personas", referencedColumnName = "id")
    private Tipo_persona fk_tipo_personas;

    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;

    @Column(name = "lugar_nacimiento")
    private String lugar_nacimiento;

    @Column(name = "estado_sistema")
    private Boolean estado_sistema;

}
