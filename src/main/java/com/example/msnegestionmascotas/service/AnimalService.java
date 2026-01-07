package com.example.msnegestionmascotas.service;

import com.example.msnegestionmascotas.dto.request.AnimalRequest;
import com.example.msnegestionmascotas.dto.response.AnimalResponse;
import com.example.msnegestionmascotas.entity.Animal;
import com.example.msnegestionmascotas.enums.EspecieAnimal;
import com.example.msnegestionmascotas.exception.ResourceNotFoundException;
import com.example.msnegestionmascotas.mapper.AnimalMapper;
import com.example.msnegestionmascotas.repository.AnimalRepository;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository repository;

    public AnimalResponse crear(AnimalRequest request){
        Animal animal = AnimalMapper.toEntity(request);
        return AnimalMapper.toResponse(repository.save(animal));
    }

    public Page<AnimalResponse> listar(EspecieAnimal especie, Pageable pageable){
        Page<Animal> page = (especie == null) ?
                repository.findAllByDeletedFalse(pageable) :
                repository.findByEspecieAndDeletedFalse(especie, pageable);
        return page.map(AnimalMapper::toResponse);
    }

    public AnimalResponse obtenerPorId(Long id){
        Animal animal = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("ANIMAL_NO_ENCONTRADO",
                        "El animal con id " + id + " no existe"));
        return AnimalMapper.toResponse(animal);
    }

    public AnimalResponse actualizar(Long id, AnimalRequest request){
        Animal animal = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("ANIMAL_NO_ENCONTRADO",
                        "El animal con id " + id + " no existe"));
        animal.setNombre(request.nombre());
        animal.setEdad(request.edad());
        animal.setPeso(request.peso());
        return AnimalMapper.toResponse(repository.save(animal));
    }

    public void eliminar(Long id) {
        Animal animal = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ANIMAL_NO_ENCONTRADO",
                        "El animal con id " + id + " no existe"
                ));

        animal.setDeleted(true);
        repository.save(animal);
    }
}
