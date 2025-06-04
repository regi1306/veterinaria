package parcial.veterinaria.entities.dto;

import lombok.Data;

@Data
public class AnimalRequestDto {
    private String nombreMascota;
    private String especie;
    private String raza;
    private int edad;
    private float peso;
    private String condicionesMedicas;
    private Long idCliente;
}

