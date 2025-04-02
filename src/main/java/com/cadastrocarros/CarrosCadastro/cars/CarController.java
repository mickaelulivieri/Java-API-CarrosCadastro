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

    //  Listar todos os carros
    @GetMapping("/listar")
    public List<CarModel> listarCarros(){
        return carService.listarCarros();
    }

    // listar todos os carros por ID
    @GetMapping("/listar/{id}")
    public CarModel listarCarroPorId(@PathVariable Long id){
        return carService.listarPorId(id);
    }

    // criar um carro
    @PostMapping ("/criar")
    public CarModel criarCarroo(@RequestBody CarModel carro){
        return carService.criarCarro(carro);
    }

}
