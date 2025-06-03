package parcial.veterinaria.service;

import parcial.veterinaria.entities.AnimalEntity;
import parcial.veterinaria.entities.dto.AnimalDto;

import java.util.List;

public interface IAnimal {
    List<AnimalEntity> findAll();
    AnimalEntity save(AnimalEntity animal);
    List<AnimalDto> obtenerAnimalesConDueños();
}


