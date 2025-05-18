package parcial.veterinaria.controller;

import parcial.veterinaria.entities.ConsultorioEntity;
import parcial.veterinaria.service.IConsultorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/process")
public class ConsultorioController {

    @Autowired
    private IConsultorio iConsultorio;

    @Transactional(readOnly = true)
    @GetMapping("/consultorios")
    public List<ConsultorioEntity> getConsultorios() {
        return iConsultorio.findAll();
    }

    @Transactional
    @PostMapping("/consultorios")
    public ConsultorioEntity saveConsultorio(@RequestBody ConsultorioEntity consultorio) {
        return iConsultorio.save(consultorio);
    }


}