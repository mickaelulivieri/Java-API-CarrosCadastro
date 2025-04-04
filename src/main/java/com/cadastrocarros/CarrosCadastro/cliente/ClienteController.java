package com.cadastrocarros.CarrosCadastro.cliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Listar todos os clientes
    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    // Listar cliente por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<ClienteDTO> listarClientePorId(@PathVariable Long id) {
        ClienteDTO clienteDTO = clienteService.listarPorId(id);
        if (clienteDTO != null) {
            return ResponseEntity.ok(clienteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Criar um cliente
    @PostMapping("/criar")
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO novoCliente = clienteService.criarCliente(clienteDTO);
        return ResponseEntity.ok(novoCliente);
    }

    // Deletar cliente
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.ok("Cliente deletado com sucesso.");
    }

    // Atualizar cliente
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO atualizado = clienteService.alterarCliente(id, clienteDTO);
        return ResponseEntity.ok(atualizado);
    }
}