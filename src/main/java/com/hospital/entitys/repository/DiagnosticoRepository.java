package com.hospital.entitys.repository;

import com.hospital.entitys.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico,Long> {

    @Query(value = "SELECT * FROM diagnosticos",nativeQuery = true)
    List<Diagnostico> listDiagnosticos();

    @Override
    List<Diagnostico> findAll();
}
