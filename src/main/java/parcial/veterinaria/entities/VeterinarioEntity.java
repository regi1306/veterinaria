package parcial.veterinaria.entities;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "veterinario")

public class VeterinarioEntity {
    @Id
    @Column(columnDefinition  = "INT", name = "id_veterinario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVeterinario;

    @Column(columnDefinition = "VARCHAR(100)")
    private String nombre;

    @Column(columnDefinition = "VARCHAR(50)")
    private String especialidad;

    @Column(columnDefinition = "VARCHAR(20)")
    private String numero_licencia;

    @Column(columnDefinition = "VARCHAR(9)")
    private String telefono;

    @Column(columnDefinition = "VARCHAR(100)")
    private String horario_atencion;


}











