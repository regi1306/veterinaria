package parcial.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.veterinaria.entities.ConsultaEntity;

import java.util.List;
@Repository

public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {


}
