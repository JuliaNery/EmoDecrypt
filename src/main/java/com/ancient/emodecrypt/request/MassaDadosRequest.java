package com.ancient.emodecrypt.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MassaDadosRequest

        (
        @NotBlank
        String nome,
        @NotBlank(message = "{massa.comentario.notBlank}")
        String comentario,
        @NotNull
        Integer qtdCurtidas,
        String plataformaOrigem,
        String tipoMassa,
        String empresa
        )
{


}
