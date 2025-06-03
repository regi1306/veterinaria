package parcial.veterinaria.service;

import parcial.veterinaria.entities.VeterinarioEntity;


import parcial.veterinaria.entities.dto.VeterinarioDto;

import java.util.List;


public interface IVeterinario {
    List<VeterinarioEntity> findAll();


    VeterinarioEntity save(VeterinarioEntity veterinario);
    List<VeterinarioDto> obtenerVeterinariosDto();
}



