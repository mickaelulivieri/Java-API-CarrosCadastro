package com.cadastrocarros.CarrosCadastro.cars;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    // injetando a dependencia
    private CarRepository carRepository;
    private CarMapper carMapper;

    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
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
    public CarDTO criarCarro(CarDTO carroDTO){
        CarModel car = new CarMapper().map(carroDTO);
        car = carRepository.save(car);
        return carMapper.map(car);
    }

    //deletar carro por id
    public void deletarCarro(Long id){
         carRepository.deleteById(id);
    }

    public CarModel atualizarCarro(Long id, CarModel carroAtualizado){
        if (carRepository.existsById(id)){
            carroAtualizado.setId(id);
            return carRepository.save(carroAtualizado);
        }
        return null;
    }
}