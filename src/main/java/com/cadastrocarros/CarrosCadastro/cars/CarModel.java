package com.cadastrocarros.CarrosCadastro.cars;

import com.cadastrocarros.CarrosCadastro.cliente.ClienteModel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CarModel {

    Long id;

    String marca;

    String modelo;

    String img;

    Double price;

    String chassi;

    ClienteModel cliente;

    String placa;


}