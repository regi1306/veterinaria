package parcial.veterinaria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial.veterinaria.entities.VeterinarioEntity;
import parcial.veterinaria.repository.VeterinarioRepository;
import parcial.veterinaria.service.IVeterinario;

import java.util.List;

@Service

public class VeterinarioImpl implements IVeterinario {
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Override
    public List<VeterinarioEntity> findAll() {
        return veterinarioRepository.findAll();
    }

    @Override
    public VeterinarioEntity save(VeterinarioEntity veterinario) {
        return veterinarioRepository.save(veterinario);
    }
}

