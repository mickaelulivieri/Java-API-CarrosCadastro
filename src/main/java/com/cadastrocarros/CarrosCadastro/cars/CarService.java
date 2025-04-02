package com.cadastrocarros.CarrosCadastro.cars;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    // injetando a dependencia
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    //metodos

    //listar carros
    public List<CarModel> listarCarros() {
        return carRepository.findAll();
    }

    //listar carro por ID
    public CarModel listarPorId(Long id){
        Optional<CarModel> carro = carRepository.findById(id);
        return carro.orElse(null);
    }

    //criar um carro
    public CarModel criarCarro(CarModel carro){
        return carRepository.save(carro);
    }
}