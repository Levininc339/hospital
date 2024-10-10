package com.hospital.entitys.repository;

import com.hospital.entitys.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona,Long> {

    @Query(value = "SELECT * FROM personas",nativeQuery = true)
    List<Persona> listPersons();

    @Override
    List<Persona> findAll();
}
