package parcial.veterinaria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial.veterinaria.entities.AnimalEntity;
import parcial.veterinaria.repository.AnimalRepository;
import parcial.veterinaria.service.IAnimal;

import java.util.List;

@Service
public class AnimalImpl implements IAnimal {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<AnimalEntity> findAll() {
        return animalRepository.findAll();
    }

    @Override
    public AnimalEntity save(AnimalEntity animal) {
        return animalRepository.save(animal);
    }
}
