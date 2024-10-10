package com.hospital.entitys.repository;

import com.hospital.entitys.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

    @Query(value = "SELECT * FROM tratamientos",nativeQuery = true)
    List<Tratamiento> listTratamientos();

    @Override
    List<Tratamiento> findAll();
}
