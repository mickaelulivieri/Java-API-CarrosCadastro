package com.cadastrocarros.CarrosCadastro.cliente;

import com.cadastrocarros.CarrosCadastro.cars.CarDTO;
import com.cadastrocarros.CarrosCadastro.cars.CarMapper;
import com.cadastrocarros.CarrosCadastro.cars.CarModel;

import java.util.List;
import java.util.stream.Collectors;

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



}
