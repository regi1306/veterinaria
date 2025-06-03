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
    @Column(columnDefinition = "INT", name = "id_animal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnimal;

    @Column(columnDefinition = "VARCHAR(50)")
    private String nombre_mascota;

    @Column(columnDefinition = "VARCHAR(50)")
    private String especie;

    @Column(columnDefinition = "VARCHAR(50)")
    private String raza;

    @Column(columnDefinition = "INT")
    private int edad;

    @Column(columnDefinition = "FLOAT")
    private float peso;

    @Column(columnDefinition = "TEXT", name = "condiciones_medicas")
    private String condiciones_medicas;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private ClienteEntity cliente;


}


