package parcial.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.veterinaria.entities.ConsultorioEntity;

@Repository
public interface ConsultorioRepository extends JpaRepository<ConsultorioEntity, Long> {

}