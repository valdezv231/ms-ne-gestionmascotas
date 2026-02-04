package com.example.msnegestionmascotas.mapper;

import com.example.msnegestionmascotas.dto.AnimalRequest;
import com.example.msnegestionmascotas.dto.AnimalResponse;
import com.example.msnegestionmascotas.entity.AnimalEntity;
import com.example.msnegestionmascotas.entity.Estado;

import java.time.LocalDate;

public class AnimalMapper {

    private AnimalMapper() {}

    public static AnimalEntity toEntity(AnimalRequest request) {
        return AnimalEntity.builder()
                .nombre(request.nombre())
                .especie(request.especie())
                .edad(request.edad())
                .peso(request.peso())
                .estado(Estado.DISPONIBLE)
                .fechaIngreso(LocalDate.now())
                .deleted(false)
                .build();
    }

    public static AnimalResponse toResponse(AnimalEntity entity) {
        return new AnimalResponse(
                entity.getId(),
                entity.getNombre(),
                entity.getEspecie().name(),
                entity.getEdad(),
                entity.getPeso(),
                entity.getEstado().name(),
                entity.getFechaIngreso()
        );
    }
}
