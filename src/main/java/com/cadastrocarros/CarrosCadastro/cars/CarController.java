package com.cadastrocarros.CarrosCadastro.cars;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/listar")
    public List<CarModel> listarCarros(){
        return carService.listarCarros();
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "boas vindas";
    }
}
