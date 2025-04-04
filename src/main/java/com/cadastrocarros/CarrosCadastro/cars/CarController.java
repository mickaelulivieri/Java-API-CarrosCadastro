package com.cadastrocarros.CarrosCadastro.cars;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CarDTO>> listarCarros(){
        List<CarDTO> carro = carService.listarCarros();
        return ResponseEntity.ok(carro);

    }

    // listar todos os carros por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarCarroPorId(@PathVariable Long id){
        CarDTO carro = carService.listarPorId(id);

        if (carro != null){
            return ResponseEntity.ok(carro);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carro com o ID: " + id + " nao encontrado");
        }
    }

    // criar um carro
    @PostMapping("/criar")
    public ResponseEntity<String> criarCarro(@RequestBody CarDTO carroDto) {
        CarDTO carNovo = carService.criarCarro(carroDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Carro criado com sucesso: " + carNovo.getModelo());
    }

    // deletar um carro
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCarro(@PathVariable Long id) {

        if (carService.listarPorId(id) != null) {
            carService.deletarCarro(id);
            return ResponseEntity.ok("Carro deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carro nao encontrada");
        }
    }


    // alterar um carro
    @PatchMapping("/alterar/{id}")
    public ResponseEntity<?> alterarCarroPorId(@PathVariable Long id, @RequestBody CarDTO carro){
        CarDTO car = carService.atualizarCarro(id, carro);

        if (car != null){
            return ResponseEntity.ok(carro);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O carro com esse ID nao foi encontrado");
        }
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<CarDTO>> listarCarrosPorCliente(@PathVariable Long clienteId) {
        List<CarDTO> carros = carService.buscarCarrosPorClienteId(clienteId);

        if (carros.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(carros); //
        }

        return ResponseEntity.ok(carros);
    }


}