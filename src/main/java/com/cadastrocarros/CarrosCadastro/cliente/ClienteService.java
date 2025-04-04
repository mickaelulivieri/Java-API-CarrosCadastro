package com.cadastrocarros.CarrosCadastro.cliente;
import com.cadastrocarros.CarrosCadastro.cars.CarModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClientRepository clientRepository;

    public ClienteService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    // listar clientes
    public List<ClienteModel> listarCliente(){
        return clientRepository.findAll();
    }

    // listar cliente por ID
    public Optional<ClienteModel> listarPorId(Long id){
        return clientRepository.findById(id);
    }

    //criar um cliente
    public ClienteModel criarCliente(ClienteModel cliente){
        return clientRepository.save(cliente);
    }

    // deletar um cliente
    public void deletarCliente(Long id){
        clientRepository.deleteById(id);
    }

    // alterar um cliente
    public ClienteModel alterarCliente(Long id, ClienteModel novoCliente){
        Optional<ClienteModel> cliente = clientRepository.findById(id);
        if (cliente.isPresent()){
            ClienteModel clienteExistente = cliente.get();
            clienteExistente.setNome(novoCliente.getNome());
            clienteExistente.setIdade(novoCliente.getIdade());
            clienteExistente.setCpf(novoCliente.getCpf());

            return clientRepository.save(clienteExistente);
        } else{
            throw new RuntimeException("Cliente nao encontrado");
        }
    }
}