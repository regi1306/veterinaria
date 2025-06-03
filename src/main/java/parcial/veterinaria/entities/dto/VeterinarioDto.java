package parcial.veterinaria.entities.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class VeterinarioDto {
    private String nombre;
    private String especialidad;
    private String horario_atencion;

    public VeterinarioDto(String nombre, String especialidad, String horario_atencion) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horario_atencion = horario_atencion;
    }

}

