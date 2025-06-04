package parcial.veterinaria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial.veterinaria.entities.AnimalEntity;
import parcial.veterinaria.entities.dto.AnimalDto;
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

    @Override
    public List<AnimalDto> obtenerAnimalesConDueños() {
        return animalRepository.obtenerAnimalesConDueños();
    }

    @Override
    public AnimalEntity findById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    @Override
    public AnimalEntity update(Long id, AnimalEntity animal) {
        AnimalEntity existente = animalRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombreMascota(animal.getNombreMascota());
            existente.setEspecie(animal.getEspecie());
            existente.setRaza(animal.getRaza());
            existente.setEdad(animal.getEdad());
            existente.setPeso(animal.getPeso());
            existente.setCondicionesMedicas(animal.getCondicionesMedicas());
            existente.setCliente(animal.getCliente());
            return animalRepository.save(existente);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        animalRepository.deleteById(id);
    }
}



