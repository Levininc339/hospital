package com.hospital.entitys.repository;

import com.hospital.entitys.Diagnostico_enfermedades;
import com.hospital.entitys.Tipo_persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiagnosticoEnfermedadesRepository extends JpaRepository<Diagnostico_enfermedades, Long> {

    @Query(value = "SELECT * FROM diagnostico_enfermedades",nativeQuery = true)
    List<Diagnostico_enfermedades> listDiagEnf();

    @Query(value = "SELECT * FROM diagnostico_enfermedades WHERE id=:id",nativeQuery = true)
    Diagnostico_enfermedades searchDiagEnfermedades(@Param(value = "id") Long id);
}
