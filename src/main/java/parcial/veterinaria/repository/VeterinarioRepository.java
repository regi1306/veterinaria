package parcial.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import parcial.veterinaria.entities.VeterinarioEntity;
import parcial.veterinaria.entities.dto.VeterinarioDto;


import java.util.List;
@Repository
public interface VeterinarioRepository extends JpaRepository<VeterinarioEntity, Long> {

    @Query("SELECT new parcial.veterinaria.entities.dto.VeterinarioDto(v.nombre, v.especialidad, v.horario_atencion) FROM VeterinarioEntity v")
    List<VeterinarioDto> obtenerVeterinariosDto();
}
