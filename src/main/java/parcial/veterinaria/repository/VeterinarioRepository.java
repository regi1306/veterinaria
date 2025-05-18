package parcial.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.veterinaria.entities.VeterinarioEntity;

import java.util.List;
@Repository
public interface VeterinarioRepository extends JpaRepository<VeterinarioEntity, Long> {

}
