package com.hospital.entitys.repository;

import com.hospital.entitys.Persona;
import com.hospital.entitys.Tipo_persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoPersonaRepository extends JpaRepository<Tipo_persona, Long> {

    @Query(value = "SELECT * FROM tipo_personas",nativeQuery = true)
    List<Tipo_persona> listTipoPersons();

    @Query(value = "SELECT * FROM tipo_personas WHERE id=:id",nativeQuery = true)
    Tipo_persona searchTipoPerson(@Param(value = "id") Long id);
}
