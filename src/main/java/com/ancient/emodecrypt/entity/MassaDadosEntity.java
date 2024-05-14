package com.ancient.emodecrypt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "massa_dados")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MassaDadosEntity {
    @Id
    private String id;
    private String nome;
    private String comentario;
    private List<String> palavrasChaves;
    private List<String> emocaoTransmitida;
    private Integer nivelSatisfacao;
    private Integer qtdCurtidas;
    private String plataformaOrigem;
    private String tipoMassa;
    private String empresa;
    private LocalDate dataCriacao;
    private LocalDate dataPublicacao;
}
