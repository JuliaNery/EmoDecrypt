package com.ancient.emodecrypt.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class MassaDadosEmocaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private EmocoesEntity emocoes;
    @ManyToOne(fetch = FetchType.LAZY)
    private MassaDadosEntity massaDados;
}
