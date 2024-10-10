package com.hospital.entitys.repository;

import com.hospital.entitys.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    @Query(value = "SELECT * FROM medicamentos", nativeQuery = true)
    List<Medicamento> listMedicamentos();

    @Override
    List<Medicamento> findAll();

}
