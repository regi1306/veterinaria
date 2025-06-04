package parcial.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import parcial.veterinaria.entities.AnimalEntity;
import parcial.veterinaria.entities.dto.AnimalDto;
import parcial.veterinaria.service.IAnimal;
import org.springframework.http.ResponseEntity;
import parcial.veterinaria.entities.dto.MessageResponse;



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

    @Transactional(readOnly = true)
    @GetMapping("/animales/dto")
    public List<AnimalDto> getAnimalesConDueños() {
        return iAnimal.obtenerAnimalesConDueños();
    }

    @Transactional(readOnly = true)
    @GetMapping("/animales/{id}")
    public AnimalEntity getAnimalById(@PathVariable Long id) {
        return iAnimal.findById(id);
    }


    @Transactional
    @PutMapping("/animales/{id}")
    public AnimalEntity updateAnimal(@PathVariable Long id, @RequestBody AnimalEntity animal) {
        return iAnimal.update(id, animal);
    }

    @Transactional
    @DeleteMapping("/animales/{id}")
    public ResponseEntity<MessageResponse> deleteAnimal(@PathVariable Long id) {
        iAnimal.delete(id);
        MessageResponse response = new MessageResponse("Animal eliminado correctamente");
        return ResponseEntity.ok(response);
    }

}






