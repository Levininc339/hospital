package com.hospital.entitys.repository;

import com.hospital.entitys.Diagnostico_enfermedades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiagnosticoEnfermedadesRepository extends JpaRepository<Diagnostico_enfermedades, Long> {

    @Query(value = "SELECT * FROM diagnostico_enfermedades",nativeQuery = true)
    List<Diagnostico_enfermedades> listDiagEnf();

    @Override
    List<Diagnostico_enfermedades> findAll();
}
