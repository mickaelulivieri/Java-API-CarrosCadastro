package com.cadastrocarros.CarrosCadastro.cliente;

import com.cadastrocarros.CarrosCadastro.cars.CarModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClientRepository clientRepository;

    public ClienteService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // metodo listar clientes
    public List<ClienteModel> listarCliente(){
        return clientRepository.findAll();
    }

    // listar cliente por ID
    public Optional<ClienteModel> listarPorId(Long id){
        return clientRepository.findById(id);
    }

    //criar um carro
    public ClienteModel criarCliente(ClienteModel cliente){
        return clientRepository.save(cliente);
    }
}
