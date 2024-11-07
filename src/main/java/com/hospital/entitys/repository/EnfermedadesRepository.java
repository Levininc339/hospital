package com.hospital.entitys.repository;

import com.hospital.entitys.Enfermedades;
import com.hospital.entitys.Tipo_persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnfermedadesRepository extends JpaRepository<Enfermedades, Long> {

    @Query(value = "SELECT * FROM enfermedades",nativeQuery = true)
    List<Enfermedades> listEnfermedades();

    @Query(value = "SELECT * FROM enfermedades WHERE id=:id",nativeQuery = true)
    Enfermedades searchEnfermedades(@Param(value = "id") Long id);
}
