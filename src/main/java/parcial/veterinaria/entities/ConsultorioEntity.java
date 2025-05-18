package parcial.veterinaria.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consultorio")
public class ConsultorioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consultorio", columnDefinition = "INT")
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)")
    private String nombre;

    @Column(columnDefinition = "VARCHAR(150)")
    private String direccion;

    @Column(columnDefinition = "VARCHAR(100)")
    private String correo;

    @Column(columnDefinition = "VARCHAR(15)")
    private String telefono;

    @Column(name = "horario_atencion", columnDefinition = "VARCHAR(100)")
    private String horario_atencion;
}
