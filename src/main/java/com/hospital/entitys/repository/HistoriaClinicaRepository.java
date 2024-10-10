package com.hospital.entitys.repository;

import com.hospital.entitys.Historia_clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoriaClinicaRepository extends JpaRepository<Historia_clinica, Long> {

    @Query(value = "SELECT * FROM historia_clinica",nativeQuery = true)
    List<Historia_clinica> listHistoria();

    @Override
    List<Historia_clinica> findAll();

}
