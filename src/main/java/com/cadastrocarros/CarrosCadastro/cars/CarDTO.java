package com.cadastrocarros.CarrosCadastro.cars;
import com.cadastrocarros.CarrosCadastro.cliente.ClienteModel;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarDTO {

    private Long id;
    private String marca;
    private String modelo;
    private String img;
    private Double price;
    private String chassi;
    private String cor;
    private String placa;
    private ClienteModel cliente;

}
