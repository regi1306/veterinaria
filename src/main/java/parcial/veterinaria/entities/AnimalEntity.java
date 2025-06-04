package parcial.veterinaria.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animal")
public class AnimalEntity {

    @Id
    @Column(name = "id_animal", columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnimal;

    @Column(name = "nombreMascota", columnDefinition = "VARCHAR(50)")
    private String nombreMascota;

    @Column(name = "especie", columnDefinition = "VARCHAR(50)")
    private String especie;

    @Column(name = "raza", columnDefinition = "VARCHAR(50)")
    private String raza;

    @Column(name = "edad", columnDefinition = "INT")
    private int edad;

    @Column(name = "peso", columnDefinition = "FLOAT")
    private float peso;

    @Column(name = "condicionesMedicas", columnDefinition = "TEXT")
    private String condicionesMedicas;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private ClienteEntity cliente;
}

