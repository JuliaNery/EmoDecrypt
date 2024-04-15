package com.ancient.emodecrypt.entity;

import com.ancient.emodecrypt.request.MassaDadosRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MassaDadosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String comentario;
    private List<String> palavrasChaves;
    private Integer nivelSatisfacao;
    private Integer qtdCurtidas;
    private String plataformaOrigem;
    private String tipoMassa;
    private String empresa;
    private LocalDate dataCriacao;
    private LocalDate dataPublicacao;

}
