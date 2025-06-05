package parcial.veterinaria.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import parcial.veterinaria.entities.ConsultaEntity;
import parcial.veterinaria.entities.dto.ConsultaDto;
import parcial.veterinaria.service.IConsulta;

import java.util.List;
@RestController
@RequestMapping("/process")

public class ConsultaController {

    @Autowired
    private IConsulta iconsulta;

    @Transactional(readOnly = true)
    @GetMapping("/consultas")
    public List<ConsultaEntity> getConsulta() {
        return iconsulta.findAll();
    }

    @Transactional
    @PostMapping("/consultas")
    public ConsultaEntity saveConsulta(@RequestBody ConsultaEntity consulta) {
        return iconsulta.save(consulta);
    }

    @Transactional(readOnly = true)
    @GetMapping("/ConsultaMotivo/{motivo}")
    public List<ConsultaEntity> findConsultaByMotivo(@PathVariable("motivo") String motivo) {
        return iconsulta.findByMotivo(motivo);
    }

    @Transactional(readOnly = true)
    @GetMapping("/consultas/dto")
    public List<ConsultaDto> obtenerConsultasDto() {
        return iconsulta.obtenerConsultasDto();
    }


}
