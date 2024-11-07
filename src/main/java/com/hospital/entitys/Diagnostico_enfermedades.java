package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "diagnostico_enfermedades")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Diagnostico_enfermedades implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_enfermedades", referencedColumnName = "id")
    private Enfermedades fk_enfermedades;
}
