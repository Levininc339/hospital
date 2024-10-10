package com.hospital.entitys.repository;

import com.hospital.entitys.Detalle_medicamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetalleMedicamentosRepository extends JpaRepository<Detalle_medicamentos,Long> {

    @Query(value = "SELECT * FROM detalle_medicamentos",nativeQuery = true)
    List<Detalle_medicamentos> listDetalle();

    @Override
    List<Detalle_medicamentos> findAll();
}
