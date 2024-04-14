package com.ancient.emodecrypt.repository;

import com.ancient.emodecrypt.entity.MassaDadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MassaDadosRepository extends JpaRepository<MassaDadosEntity, Long> {
}
