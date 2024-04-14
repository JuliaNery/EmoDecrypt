package com.ancient.emodecrypt.repository;

import com.ancient.emodecrypt.entity.EmocoesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmocoesRepository extends JpaRepository<EmocoesEntity, Long> {
    Boolean existsByNomeEmocao(String nome);


    List<EmocoesEntity> findByNomeEmocao(String emocoes);
}
