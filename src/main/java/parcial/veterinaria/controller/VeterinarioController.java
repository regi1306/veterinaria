package parcial.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import parcial.veterinaria.entities.VeterinarioEntity;
import parcial.veterinaria.entities.dto.VeterinarioDto;
import parcial.veterinaria.service.IVeterinario;

import java.util.List;

@RestController
@RequestMapping("/process")

public class VeterinarioController {

    @Autowired
    private IVeterinario iveterinario;

    @Transactional (readOnly = true)
    @GetMapping("/veterinarios")
    public List<VeterinarioEntity> getVeterinarios() {
        return iveterinario.findAll();
    }

    @Transactional
    @PostMapping("/veterinarios")
    public VeterinarioEntity saveAnimal(@RequestBody VeterinarioEntity veterinario) {
        return iveterinario.save(veterinario);
    }
    @Transactional(readOnly = true)
    @GetMapping("/veterinarios/dto")
    public List<VeterinarioDto> obtenerVeterinariosDto() {
        return  iveterinario.obtenerVeterinariosDto();
    }

}
