package com.cadastrocarros.CarrosCadastro.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {


    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<CarModel> listarCarros(){
        return carRepository.findAll();
    }


}
