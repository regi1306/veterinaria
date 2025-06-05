package parcial.veterinaria.entities.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ConsultaDto {
    private LocalDate fecha_consulta;
    private String motivo;
    private String diagnostico;
    private String tratamiento;
    private String nombre;
    private String nombreMascota;

    public ConsultaDto(LocalDate fecha_consulta, String motivo, String diagnostico, String tratamiento, String nombre, String nombreMascota) {
        this.fecha_consulta = fecha_consulta;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.nombre = nombre;
        this.nombreMascota = nombreMascota;
    }
}

