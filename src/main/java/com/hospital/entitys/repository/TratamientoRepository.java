package com.hospital.entitys.repository;

import com.hospital.entitys.Tipo_persona;
import com.hospital.entitys.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

    @Query(value = "SELECT * FROM tratamientos",nativeQuery = true)
    List<Tratamiento> listTratamientos();

    @Query(value = "SELECT * FROM tratamientos WHERE id=:id",nativeQuery = true)
    Tratamiento searchTratamiento(@Param(value = "id") Long id);
}
