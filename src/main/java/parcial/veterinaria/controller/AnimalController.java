package parcial.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import parcial.veterinaria.entities.AnimalEntity;
import parcial.veterinaria.entities.dto.AnimalDto;
import parcial.veterinaria.service.IAnimal;

import java.util.List;

@RestController
@RequestMapping("/process")
public class AnimalController {


    @Autowired
    private IAnimal iAnimal;

    @Transactional(readOnly = true)
    @GetMapping("/animales")
    public List<AnimalEntity> getAnimales() {
        return iAnimal.findAll();
    }

    @Transactional
    @PostMapping("/animales")
    public AnimalEntity saveAnimal(@RequestBody AnimalEntity animal) {
        return iAnimal.save(animal);
    }

    // 🔽 Nuevo endpoint con el DTO
    @Transactional(readOnly = true)
    @GetMapping("/animales/dto")
    public List<AnimalDto> getAnimalesConDueños() {
        return iAnimal.obtenerAnimalesConDueños();
    }
}




