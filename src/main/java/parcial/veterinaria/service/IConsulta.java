package parcial.veterinaria.service;

import parcial.veterinaria.entities.ConsultaEntity;


import java.util.List;

public interface IConsulta {

    List<ConsultaEntity> findAll();

    List<ConsultaEntity> findByMotivo(String motivo);

    ConsultaEntity save(ConsultaEntity consulta);
}

