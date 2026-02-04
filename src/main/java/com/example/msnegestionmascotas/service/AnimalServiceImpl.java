package com.example.msnegestionmascotas.service;

import com.example.msnegestionmascotas.dto.AnimalRequest;
import com.example.msnegestionmascotas.dto.AnimalResponse;
import com.example.msnegestionmascotas.entity.AnimalEntity;
import com.example.msnegestionmascotas.entity.Especie;
import com.example.msnegestionmascotas.exception.ResourceNotFoundException;
import com.example.msnegestionmascotas.mapper.AnimalMapper;
import com.example.msnegestionmascotas.repository.AnimalRepository;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl  implements  AnimalService{

    private final AnimalRepository repository;

    public AnimalResponse crear(AnimalRequest request){
        AnimalEntity animal = AnimalMapper.toEntity(request);
        return AnimalMapper.toResponse(repository.save(animal));
    }

    public Page<AnimalResponse> listar(Especie especie, Pageable pageable){
        Page<AnimalEntity> page = (especie == null) ?
                repository.findAllByDeletedFalse(pageable) :
                repository.findByEspecieAndDeletedFalse(especie, pageable);
        return page.map(AnimalMapper::toResponse);
    }

    public AnimalResponse obtenerPorId(Long id){
        AnimalEntity animalEntity = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("ANIMAL_NO_ENCONTRADO",
                        "El animal con id " + id + " no existe"));
        return AnimalMapper.toResponse(animalEntity);
    }

    public AnimalResponse actualizar(Long id, AnimalRequest request){
        AnimalEntity animalEntity = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("ANIMAL_NO_ENCONTRADO",
                        "El animal con id " + id + " no existe"));
        animalEntity.setNombre(request.nombre());
        animalEntity.setEdad(request.edad());
        animalEntity.setPeso(request.peso());
        return AnimalMapper.toResponse(repository.save(animalEntity));
    }

    public void eliminar(Long id) {
        AnimalEntity animalEntity = repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ANIMAL_NO_ENCONTRADO",
                        "El animal con id " + id + " no existe"
                ));

        animalEntity.setDeleted(true);
        repository.save(animalEntity);
    }
}

