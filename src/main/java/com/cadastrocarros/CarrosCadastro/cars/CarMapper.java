package com.cadastrocarros.CarrosCadastro.cars;

import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    //mapeando o DTO

    // DTO → Model
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
        carModel.setCliente(carDTO.getCliente());
        return carModel;
    }

    // Model → DTO
    public CarDTO map(CarModel carModel) {
        CarDTO car = new CarDTO();
        car.setId(carModel.getId()); // ← Esse aqui estava faltando!
        car.setMarca(carModel.getMarca());
        car.setModelo(carModel.getModelo());
        car.setImg(carModel.getImg());
        car.setPrice(carModel.getPrice());
        car.setChassi(carModel.getChassi());
        car.setCor(carModel.getCor());
        car.setPlaca(carModel.getPlaca());
        car.setCliente(carModel.getCliente());
        return car;
    }

    }
