package com.ancient.emodecrypt.controller;

import com.ancient.emodecrypt.entity.MassaDadosEntity;
import com.ancient.emodecrypt.repository.MassaDadosRepository;
import com.ancient.emodecrypt.request.MassaDadosRequest;
import com.ancient.emodecrypt.service.MassaDadosService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("MassaDados")
public class MassaDadosController {
    @Autowired
    private MassaDadosService massaDadosService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody MassaDadosRequest massaDadosRequest,  UriComponentsBuilder uriBuilder){
        var massaDados = MassaDadosEntity.builder()
                                        .nome(massaDadosRequest.nome())
                                        .comentario(massaDadosRequest.comentario())
                                        .qtdCurtidas(massaDadosRequest.qtdCurtidas())
                                        .build();
        //massaDadosRepository.save(massaDados);

        var uri = uriBuilder.path("{id}").buildAndExpand(massaDados.getId()).toUri();

        return ResponseEntity.ok().build();
    }
}
