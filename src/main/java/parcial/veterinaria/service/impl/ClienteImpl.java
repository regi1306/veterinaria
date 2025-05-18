package parcial.veterinaria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial.veterinaria.entities.ClienteEntity;
import parcial.veterinaria.repository.ClienteRepository;
import parcial.veterinaria.service.ICliente;

import java.util.List;
@Service
public class ClienteImpl implements ICliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

}
