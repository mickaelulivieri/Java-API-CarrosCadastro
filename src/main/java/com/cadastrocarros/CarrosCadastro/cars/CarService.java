package com.cadastrocarros.CarrosCadastro.cars;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    // injetando a dependencia
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    //metodos

    //listar carros
    public List<CarDTO> listarCarros() {
        List<CarModel> car = carRepository.findAll();
        return car.stream()
                .map(carMapper::map)
                .collect(Collectors.toList());
    }

    //listar carro por ID
    public CarDTO listarPorId(Long id){
        Optional<CarModel> car = carRepository.findById(id);
        return car.map(carMapper::map).orElse(null);
    }

    //criar um carro
    public CarDTO criarCarro(CarDTO carroDTO){
        CarModel car = carMapper.map(carroDTO);
        car = carRepository.save(car);
        return carMapper.map(car);
    }

    //deletar carro por id
    public void deletarCarro(Long id){
         carRepository.deleteById(id);
    }

    public CarDTO atualizarCarro(Long id, CarDTO carDTO) {
        Optional<CarModel> carroExistente = carRepository.findById(id);
        if (carroExistente.isPresent()) {

            CarModel carroAtualizado = carMapper.map(carDTO);
            carroAtualizado.setId(id);
            CarModel carroNovo = carRepository.save(carroAtualizado);
            return carMapper.map(carroNovo);
        }

        return null;
    }

    public List<CarDTO> buscarCarrosPorClienteId(Long clienteId) {
        List<CarModel> carros = carRepository.findByClienteId(clienteId);
        return carros.stream()
                .map(carMapper::map)
                .collect(Collectors.toList());
    }


}