package parcial.veterinaria.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consulta")

public class ConsultaEntity {
    @Id
    @Column(columnDefinition = "INT", name = "id_consulta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsulta;

    @Column(columnDefinition = "DATE")
    private LocalDate fecha_consulta;

    @Column(columnDefinition = "VARCHAR(255)")
    private String motivo;

    @Column(columnDefinition = "TEXT")
    private String diagnostico;

    @Column(columnDefinition = "VARCHAR(100)")
    private String tratamiento;

    @ManyToOne
    @JoinColumn(name = "id_veterinario", referencedColumnName = "id_veterinario")
    private VeterinarioEntity veterinario;

    @ManyToOne
    @JoinColumn(name = "id_animal", referencedColumnName = "id_animal")
    private AnimalEntity animal;


}
