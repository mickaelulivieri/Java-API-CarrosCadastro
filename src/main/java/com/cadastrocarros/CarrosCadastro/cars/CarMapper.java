package com.cadastrocarros.CarrosCadastro.cars;

import com.cadastrocarros.CarrosCadastro.cliente.ClienteDTO;
import com.cadastrocarros.CarrosCadastro.cliente.ClienteMapper;
import com.cadastrocarros.CarrosCadastro.cliente.ClienteModel;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    private final ClienteMapper clienteMapper;

    public CarMapper(@Lazy ClienteMapper clienteMapper) {
        this.clienteMapper = clienteMapper;
    }

    public CarModel map(CarDTO carDTO) {
        CarModel carModel = new CarModel();
        carModel.setId(carDTO.getId());
        carModel.setMarca(carDTO.getMarca());
        carModel.setModelo(carDTO.getModelo());
        carModel.setImg(carDTO.getImg());
        carModel.setPrice(carDTO.getPrice());
        carModel.setChassi(carDTO.getChassi());
        carModel.setCor(carDTO.getCor());
        carModel.setPlaca(carDTO.getPlaca());

        if (carDTO.getCliente() != null) {
            carModel.setCliente(mapClienteSemCarros(carDTO.getCliente()));
        }

        return carModel;
    }

    public CarDTO map(CarModel carModel) {
        CarDTO car = new CarDTO();
        car.setId(carModel.getId());
        car.setMarca(carModel.getMarca());
        car.setModelo(carModel.getModelo());
        car.setImg(carModel.getImg());
        car.setPrice(carModel.getPrice());
        car.setChassi(carModel.getChassi());
        car.setCor(carModel.getCor());
        car.setPlaca(carModel.getPlaca());

        if (carModel.getCliente() != null) {
            car.setCliente(mapClienteSemCarros(carModel.getCliente()));
        }

        return car;
    }

    // 🔁 Cliente sem lista de carros (evita ciclo)
    private ClienteDTO mapClienteSemCarros(ClienteModel clienteModel) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(clienteModel.getId());
        dto.setNome(clienteModel.getNome());
        dto.setIdade(clienteModel.getIdade());
        dto.setCpf(clienteModel.getCpf());
        return dto;
    }

    private ClienteModel mapClienteSemCarros(ClienteDTO clienteDTO) {
        ClienteModel model = new ClienteModel();
        model.setId(clienteDTO.getId());
        model.setNome(clienteDTO.getNome());
        model.setIdade(clienteDTO.getIdade());
        model.setCpf(clienteDTO.getCpf());
        return model;
    }
}