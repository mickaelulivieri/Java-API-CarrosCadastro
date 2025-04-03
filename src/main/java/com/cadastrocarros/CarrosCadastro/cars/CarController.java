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
    public CarDTO criarCarroo(@RequestBody CarDTO carroDto){
        return carService.criarCarro(carroDto);
    }

    // deletar um carro
    @DeleteMapping("/deletar/{id}")
    public void deletarCarro(@PathVariable Long id){
        carService.deletarCarro(id);
    }

    @PatchMapping("/alterar/{id}")
    public CarModel alterarCarroPorId(@PathVariable Long id, @RequestBody CarModel carro){
        return carService.atualizarCarro(id, carro);
    }

}