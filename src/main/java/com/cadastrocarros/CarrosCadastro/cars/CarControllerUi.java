package com.cadastrocarros.CarrosCadastro.cars;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/carros/ui")
public class CarControllerUi {

    private final CarService carService;

    public CarControllerUi(CarService carService) {
        this.carService = carService;
    }

    //  Listar todos os carros
    @GetMapping("/listar")
    public String listarCarros(Model model){
        List<CarDTO> carro = carService.listarCarros();
        model.addAttribute("carros", carro);
        return "ListarCarros";
    }
}
