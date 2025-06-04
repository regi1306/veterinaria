package parcial.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import parcial.veterinaria.entities.AnimalEntity;
import parcial.veterinaria.entities.dto.AnimalDto;
import parcial.veterinaria.payload.MessageResponse;
import parcial.veterinaria.service.IAnimal;

import java.util.Optional;





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
    public ResponseEntity<?> getAnimalById(@PathVariable Long id) {
        Optional<AnimalEntity> animal = Optional.ofNullable(iAnimal.findById(id));

        if (animal.isPresent()) {
            return ResponseEntity.ok(animal.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("No se encontró el animal con ID " + id));
        }
    }


    @Transactional
    @PutMapping("/animales/{id}")
    public AnimalEntity updateAnimal(@PathVariable Long id, @RequestBody AnimalEntity animal) {
        return iAnimal.update(id, animal);
    }

    @Transactional
    @DeleteMapping("/animales/{id}")
    public ResponseEntity<MessageResponse> deleteAnimal(@PathVariable Long id) {
        Optional<AnimalEntity> animal = Optional.ofNullable(iAnimal.findById(id));

        if (animal.isPresent()) {
            iAnimal.delete(id);
            return ResponseEntity.ok(new MessageResponse("Animal eliminado correctamente"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("No se encontró un animal con ID " + id));
        }
    }





}






