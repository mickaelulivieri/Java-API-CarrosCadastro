package com.cadastrocarros.CarrosCadastro.cliente;

import com.cadastrocarros.CarrosCadastro.cars.CarModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // listar os clientes
    @GetMapping("/listar")
    public ResponseEntity<List<ClienteModel>> listarClientes(){
        List<ClienteModel> cliente = clienteService.listarCliente();
        return ResponseEntity.ok(cliente);
    }

    // listar por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        Optional<ClienteModel> cliente = clienteService.listarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    // criar um cliente
    @PostMapping("/criar")
    public ClienteModel criarCliente(@RequestBody ClienteModel cliente){
        return clienteService.criarCliente(cliente);
    }

    // deletar um cliente
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCarro(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.ok()
                .body("Cliente deletado");
    }

    //
}