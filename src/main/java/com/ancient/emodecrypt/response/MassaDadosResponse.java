package com.ancient.emodecrypt.response;

import com.ancient.emodecrypt.entity.MassaDadosEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

public record MassaDadosResponse(
        String id,
        String nome,
        String comentario,
        List<String> palavrasChaves,
        List<String> emocaoTransmitida,
        Integer nivelSatisfacao,
        Integer qtdCurtidas,
        String plataformaOrigem,
        String tipoMassa,
        String empresa,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataCriacao,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataPublicacao
) {
    public MassaDadosResponse(MassaDadosEntity massaDados) {
        this(massaDados.getId(), massaDados.getNome(), massaDados.getComentario(), massaDados.getPalavrasChaves(),
                massaDados.getEmocaoTransmitida(), massaDados.getNivelSatisfacao(), massaDados.getQtdCurtidas(), massaDados.getPlataformaOrigem(),
                massaDados.getTipoMassa(), massaDados.getEmpresa(), massaDados.getDataCriacao(), massaDados.getDataPublicacao());
    }
}
