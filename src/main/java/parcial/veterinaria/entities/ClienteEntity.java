package parcial.veterinaria.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")

public class ClienteEntity {
    @Id
    @Column(columnDefinition = "INT", name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(columnDefinition = "VARCHAR(100)")
    private String nombre;

    @Column(columnDefinition = "VARCHAR(9)")
    private String telefono;

    @Column(columnDefinition = "VARCHAR(100)")
    private String correo;

    @Column(columnDefinition = "VARCHAR(150)")
    private String direccion;

}
