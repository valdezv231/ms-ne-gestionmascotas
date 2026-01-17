package com.example.msnegestionmascotas.mapper;

import com.example.msnegestionmascotas.dto.request.AnimalRequest;
import com.example.msnegestionmascotas.dto.response.AnimalResponse;
import com.example.msnegestionmascotas.entity.AnimalEntity;
import com.example.msnegestionmascotas.enums.EstadoAnimal;

import java.time.LocalDate;

public class AnimalMapper {

    private AnimalMapper() {}

    public static AnimalEntity toEntity(AnimalRequest request) {
        return AnimalEntity.builder()
                .nombre(request.nombre())
                .especie(request.especie())
                .edad(request.edad())
                .peso(request.peso())
                .estado(EstadoAnimal.DISPONIBLE)
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
