package parcial.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import parcial.veterinaria.entities.ClienteEntity;
import parcial.veterinaria.service.ICliente;

import java.util.List;
@RestController
@RequestMapping("/process")

public class ClienteController {

    @Autowired
    private ICliente icliente;

    @Transactional(readOnly = true)
    @GetMapping("/clientes")
    public List<ClienteEntity> getClientes() {
        return icliente.findAll();
    }

    @Transactional
    @PostMapping("/clientes")
    public ClienteEntity saveCliente(@RequestBody ClienteEntity cliente) {
        return icliente.save(cliente);
    }
}