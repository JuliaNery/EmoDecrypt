package com.ancient.emodecrypt.controller;

import com.ancient.emodecrypt.request.MassaDadosRequest;
import com.ancient.emodecrypt.service.MassaDadosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/MassaDados")
@CacheConfig(cacheNames = "massaDados")
@Tag(name = "massaDados")
public class MassaDadosController {

    @Autowired
    private MassaDadosService massaDadosService;

    @PostMapping
    @Cacheable
    @Operation(
            summary = "Cadastrar apenas uma massa de dados"
    )
    public ResponseEntity create(@RequestBody @Valid MassaDadosRequest massaDadosRequest,  UriComponentsBuilder uriBuilder) {

        var massaDadosResponse = massaDadosService.create(massaDadosRequest);
        var uri = uriBuilder.path("{id}").buildAndExpand(massaDadosResponse.id().toString()).toUri();
        return ResponseEntity.created(uri).body(massaDadosResponse);
    }

//    @PostMapping("/createall")
//    public ResponseEntity createAll(@RequestBody @Valid List<MassaDadosRequest> massaDadosRequestList, UriComponentsBuilder uriBuilder){
//        var responseList = massaDadosService.createAll(massaDadosRequestList);
//        if (responseList.isEmpty()) {
//            return ResponseEntity.badRequest().build();
//        }
//        var uri = uriBuilder.path("/massa-dados/{id}").buildAndExpand(responseList.get(0).id()).toUri();
//        return ResponseEntity.created(uri).body(responseList);
//    }
    @GetMapping("/{id}")
    @Cacheable
    @Operation(
            summary = "Buscar a Massa com base no id"
    )
    public ResponseEntity getById(@PathVariable ObjectId id){

            return ResponseEntity.ok().body(massaDadosService.findById(id));
    }

    @GetMapping
    @Operation(
            summary = "Buscar todas as massas"
    )
    public ResponseEntity getAll(){
        try{
            return ResponseEntity.ok().body(massaDadosService.findAll());
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/empresa/{nomeEmpresa}")
    @Operation(
            summary = "Buscar todas as massas de determinada empresa"
    )
    public ResponseEntity getByNomeEmpresa(@PathVariable String nomeEmpresa) {
        return ResponseEntity.ok(massaDadosService.getByNomeEmpresa(nomeEmpresa)) ;
    }
    @GetMapping("/mediasatisfacao{empresa}")
    @Operation(
            summary = "Buscar a media de satisfação por empresa"
    )
    public ResponseEntity getMediaSatisfacao(@PathVariable String empresa){

        return ResponseEntity.ok( massaDadosService.calcularMediaSatisfacao(empresa));
    }
}
