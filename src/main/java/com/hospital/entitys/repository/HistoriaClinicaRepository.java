package com.hospital.entitys.repository;

import com.hospital.entitys.Historia_clinica;
import com.hospital.entitys.Tipo_persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoriaClinicaRepository extends JpaRepository<Historia_clinica, Long> {

    @Query(value = "SELECT * FROM historia_clinica",nativeQuery = true)
    List<Historia_clinica> listHistoria();

    @Query(value = "SELECT * FROM historia_clinica WHERE id=:id",nativeQuery = true)
    Historia_clinica searchHistoriaClinica(@Param(value = "id") Long id);

}
