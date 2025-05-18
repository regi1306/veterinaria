package parcial.veterinaria.service;

import parcial.veterinaria.entities.ClienteEntity;

import java.util.List;

public interface ICliente {

    List<ClienteEntity> findAll();

    ClienteEntity save(ClienteEntity cliente);
}
