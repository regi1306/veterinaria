package parcial.veterinaria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.veterinaria.entities.ClienteEntity;


import java.util.List;
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
