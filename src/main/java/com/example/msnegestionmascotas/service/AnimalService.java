package com.example.msnegestionmascotas.service;

import com.example.msnegestionmascotas.dto.AnimalRequest;
import com.example.msnegestionmascotas.dto.AnimalResponse;
import com.example.msnegestionmascotas.entity.Especie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnimalService {

    AnimalResponse crear(AnimalRequest request);

    Page<AnimalResponse> listar(Especie especie, Pageable pageable);

    AnimalResponse obtenerPorId(Long id);

    AnimalResponse actualizar(Long id, AnimalRequest request);

    void eliminar(Long id);
}