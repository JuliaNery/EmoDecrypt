package com.ancient.emodecrypt.controller;

import com.ancient.emodecrypt.request.MassaDadosRequest;
import com.ancient.emodecrypt.service.MassaDadosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/MassaDados")
public class MassaDadosController {

    @Autowired
    private MassaDadosService massaDadosService;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid MassaDadosRequest massaDadosRequest,  UriComponentsBuilder uriBuilder) {
        var massaDadosResponse = massaDadosService.create(massaDadosRequest);
        var uri = uriBuilder.path("{id}").buildAndExpand(massaDadosResponse.id()).toUri();
        return ResponseEntity.created(uri).body(massaDadosResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        try{
            return ResponseEntity.ok().body(massaDadosService.findById(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping
    public ResponseEntity getAll(){
        try{
            return ResponseEntity.ok().body(massaDadosService.findAll());
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }
}
