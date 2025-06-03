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
    @Column(name = "id_cliente", columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(name = "nombre", columnDefinition = "VARCHAR(100)")
    private String nombre;

    @Column(name = "telefono", columnDefinition = "VARCHAR(9)")
    private String telefono;

    @Column(name = "correo", columnDefinition = "VARCHAR(100)")
    private String correo;

    @Column(name = "direccion", columnDefinition = "VARCHAR(150)")
    private String direccion;
}
