package com.example.msnegestionmascotas.controller;

import com.example.msnegestionmascotas.dto.AnimalRequest;
import com.example.msnegestionmascotas.dto.AnimalResponse;
import com.example.msnegestionmascotas.entity.Especie;
import com.example.msnegestionmascotas.service.AnimalServiceImpl;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animales")
@Validated
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalResponse crear(@Valid @RequestBody AnimalRequest request) {
        return service.crear(request);
    }

    @GetMapping
    public Page<AnimalResponse> listar(
            @RequestParam(required = false) Especie especie,
            @PageableDefault(size = 30, sort = "id") Pageable pageable
    ){
        return service.listar(especie, pageable);
    }

    @GetMapping("/{id}")
    public AnimalResponse obtener(@PathVariable Long id){
        return service.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public AnimalResponse actualizar(
            @PathVariable Long id,
            @Valid @RequestBody AnimalRequest request
    ){
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
