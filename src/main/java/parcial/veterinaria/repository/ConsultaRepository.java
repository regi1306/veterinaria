
package parcial.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import parcial.veterinaria.entities.ConsultaEntity;

import java.util.List;
@Repository

public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {

    @Query("SELECT p FROM ConsultaEntity p WHERE  p.motivo = :motivo")
    List<ConsultaEntity> findByMotivo(@Param("motivo") String motivo);

}

