package com.cadastrocarros.CarrosCadastro.cars;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CarController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Primeira rota concluida";
    }
}
