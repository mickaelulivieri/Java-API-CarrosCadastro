package com.cadastrocarros.CarrosCadastro.cliente;

import com.cadastrocarros.CarrosCadastro.cars.CarDTO;
import com.cadastrocarros.CarrosCadastro.cars.CarMapper;
import com.cadastrocarros.CarrosCadastro.cars.CarModel;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    private final CarMapper carMapper;

    public ClienteMapper(@Lazy CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    public ClienteDTO map(ClienteModel clienteModel) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clienteModel.getId());
        clienteDTO.setNome(clienteModel.getNome());
        clienteDTO.setIdade(clienteModel.getIdade());
        clienteDTO.setCpf(clienteModel.getCpf());

        if (clienteModel.getCarList() != null) {
            clienteDTO.setCarList(
                    clienteModel.getCarList().stream()
                            .map(this::mapCarModelSemCliente)  // ⚠️ evita ciclo
                            .collect(Collectors.toList())
            );
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
                            .map(this::mapCarDtoSemCliente)  // ⚠️ evita ciclo
                            .collect(Collectors.toList())
            );
        }

        return clienteModel;
    }

    // 🔁 Métodos auxiliares para evitar loop:
    private CarDTO mapCarModelSemCliente(CarModel carModel) {
        CarDTO dto = new CarDTO();
        dto.setId(carModel.getId());
        dto.setMarca(carModel.getMarca());
        dto.setModelo(carModel.getModelo());
        dto.setImg(carModel.getImg());
        dto.setPrice(carModel.getPrice());
        dto.setChassi(carModel.getChassi());
        dto.setCor(carModel.getCor());
        dto.setPlaca(carModel.getPlaca());
        return dto; // sem cliente
    }

    private CarModel mapCarDtoSemCliente(CarDTO carDTO) {
        CarModel model = new CarModel();
        model.setId(carDTO.getId());
        model.setMarca(carDTO.getMarca());
        model.setModelo(carDTO.getModelo());
        model.setImg(carDTO.getImg());
        model.setPrice(carDTO.getPrice());
        model.setChassi(carDTO.getChassi());
        model.setCor(carDTO.getCor());
        model.setPlaca(carDTO.getPlaca());
        return model; // sem cliente
    }
}