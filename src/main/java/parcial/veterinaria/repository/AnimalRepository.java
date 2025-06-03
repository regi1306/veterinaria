package parcial.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import parcial.veterinaria.entities.AnimalEntity;
import parcial.veterinaria.entities.dto.AnimalDto;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {

    @Query("SELECT new parcial.veterinaria.entities.dto.AnimalDto(" +
            "a.nombreMascota, a.especie, a.raza, c.nombre) " +
            "FROM AnimalEntity a JOIN a.cliente c")
    List<AnimalDto> obtenerAnimalesConDueños();

}

