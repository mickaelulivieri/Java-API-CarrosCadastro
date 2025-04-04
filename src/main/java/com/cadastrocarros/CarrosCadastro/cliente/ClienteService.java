package com.cadastrocarros.CarrosCadastro.cliente;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClientRepository clientRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClientRepository clientRepository, ClienteMapper clienteMapper) {
        this.clientRepository = clientRepository;
        this.clienteMapper = clienteMapper;
    }

    // Listar todos os clientes
    public List<ClienteDTO> listarClientes() {
        List<ClienteModel> clientes = clientRepository.findAll();
        return clientes.stream()
                .map(clienteMapper::map)
                .collect(Collectors.toList());
    }

    // Listar cliente por ID
    public ClienteDTO listarPorId(Long id) {
        return clientRepository.findById(id)
                .map(clienteMapper::map)
                .orElse(null); // já simplificado com orElse
    }

    // Criar um cliente
    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        ClienteModel clienteModel = clienteMapper.map(clienteDTO);
        ClienteModel salvo = clientRepository.save(clienteModel);
        return clienteMapper.map(salvo);
    }

    // Deletar cliente
    public void deletarCliente(Long id) {
        clientRepository.deleteById(id);
    }

    // Atualizar cliente
    public ClienteDTO alterarCliente(Long id, ClienteDTO clienteDTO) {
        Optional<ClienteModel> clienteOptional = clientRepository.findById(id);
        if (clienteOptional.isPresent()) {
            ClienteModel clienteExistente = clienteOptional.get();
            clienteExistente.setNome(clienteDTO.getNome());
            clienteExistente.setIdade(clienteDTO.getIdade());
            clienteExistente.setCpf(clienteDTO.getCpf());

            ClienteModel atualizado = clientRepository.save(clienteExistente);
            return clienteMapper.map(atualizado);
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }
}