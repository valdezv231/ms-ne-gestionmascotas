package com.example.msnegestionmascotas.mapper;

import com.example.msnegestionmascotas.dto.request.AnimalRequest;
import com.example.msnegestionmascotas.dto.response.AnimalResponse;
import com.example.msnegestionmascotas.entity.Animal;
import com.example.msnegestionmascotas.enums.EstadoAnimal;

import java.time.LocalDate;

public class AnimalMapper {

    public static Animal toEntity(AnimalRequest request){
        return Animal.builder()
                .nombre(request.nombre())
                .especie(request.especie())
                .edad(request.edad())
                .peso(request.peso())
                .estado(EstadoAnimal.DISPONIBLE)
                .fechaIngreso(LocalDate.now())
                .deleted(false)
                .build();
    }

    public static AnimalResponse toResponse(Animal animal){
        return new AnimalResponse(
                animal.getId(),
                animal.getNombre(),
                animal.getEspecie().name(),
                animal.getEdad(),
                animal.getPeso(),
                animal.getEstado().name(),
                animal.getFechaIngreso()
        );
    }
}
