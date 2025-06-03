package parcial.veterinaria.service;

import parcial.veterinaria.entities.AnimalEntity;
import java.util.List;

public interface IAnimal {
    List<AnimalEntity> findAll();

    AnimalEntity save(AnimalEntity animal);
}
