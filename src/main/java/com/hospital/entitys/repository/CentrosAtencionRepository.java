package com.hospital.entitys.repository;

import com.hospital.entitys.Centros_atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CentrosAtencionRepository extends JpaRepository<Centros_atencion,Long> {

    @Query(value = "SELECT * FROM centros_atencion",nativeQuery = true)
    List<Centros_atencion> listCentros();

    @Query
    List<Centros_atencion> findAll();

}
