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
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "massa_dados")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MassaDadosEntity {
    @Id
    @Field("_id")
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
    private LocalDate dataPublicacao;;
}
