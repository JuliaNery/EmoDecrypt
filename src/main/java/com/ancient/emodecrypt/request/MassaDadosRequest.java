package com.ancient.emodecrypt.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.List;

public record MassaDadosRequest

        (
        @NotBlank(message = "{massa.nome.notBlank}")
        String nome,
        @NotBlank(message = "{massa.comentario.notBlank}")
        String comentario,
        Integer qtdCurtidas,
        @NotBlank(message = "{massa.origem.notBlank}")
        String plataformaOrigem,
        @NotBlank(message = "{massa.tipo.notBlank}")
        String tipoMassa,
        @NotBlank(message = "{massa.empresa.notBlank}")
        String empresa,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @NotNull(message = "{massa.publicacao.notBlank}")
        @PastOrPresent(message = "{massa.publicacao.pastOrPresent}")
        LocalDate dataPublicacao
        )
{


}
