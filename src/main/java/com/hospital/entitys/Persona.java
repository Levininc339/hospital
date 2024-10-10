package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "personas") //persistence


@Getter //Lombok
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Persona { //objeto Java

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @JoinColumn(name = "fk_tipo_documentos",referencedColumnName = "id")
    @Column(name = "fk_tipo_documentos")
    private Long fk_tipo_documentos;

    @Column(name = "documento")
    private String documento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fk_tipo_personas")
    private Long fk_tipo_personas;

    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;

    @Column(name = "lugar_nacimiento")
    private String lugar_nacimiento;

    @Column(name = "estado sistema")
    private Boolean estado_sistema;

}
