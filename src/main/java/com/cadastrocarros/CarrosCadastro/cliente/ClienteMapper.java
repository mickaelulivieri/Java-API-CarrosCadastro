package com.cadastrocarros.CarrosCadastro.cliente;

import com.cadastrocarros.CarrosCadastro.cars.CarDTO;
import com.cadastrocarros.CarrosCadastro.cars.CarMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    private final CarMapper carMapper;

    public ClienteMapper(CarMapper carMapper) {
        this.carMapper = carMapper;}

    public ClienteDTO map(ClienteModel clienteModel){
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId(clienteModel.getId());
        clienteDTO.setNome(clienteModel.getNome());
        clienteDTO.setIdade(clienteModel.getIdade());
        clienteDTO.setCpf(clienteModel.getCpf());

        if (clienteModel.getCarList() != null) {
            List<CarDTO> carDTOs = clienteModel.getCarList().stream()
                    .map(carMapper::map)
                    .collect(Collectors.toList());

            clienteDTO.setCarList(carDTOs);
        }

        return clienteDTO;
    }

    public ClienteModel map(ClienteDTO clienteDTO) {
        ClienteModel clienteModel = new ClienteModel();

        clienteModel.setId(clienteDTO.getId());
        clienteModel.setNome(clienteDTO.getNome());
        clienteModel.setIdade(clienteDTO.getIdade());
        clienteModel.setCpf(clienteDTO.getCpf());

        if (clienteDTO.getCarList() != null) {
            clienteModel.setCarList(
                    clienteDTO.getCarList().stream()
                            .map(carMapper::map)  // CarDTO → CarModel
                            .collect(Collectors.toList())
            );
        }

        return clienteModel;
    }
}
