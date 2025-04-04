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
    public List<CarDTO> listarCarros(){
        return carService.listarCarros();
    }

    // listar todos os carros por ID
    @GetMapping("/listar/{id}")
    public CarDTO listarCarroPorId(@PathVariable Long id){
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
    public CarDTO alterarCarroPorId(@PathVariable Long id, @RequestBody CarDTO carro){
        return carService.atualizarCarro(id, carro);
    }

}