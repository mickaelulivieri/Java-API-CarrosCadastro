package com.cadastrocarros.CarrosCadastro.cliente;

import com.cadastrocarros.CarrosCadastro.cars.CarModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "nome")
    String nome;

    @Column(name = "idade")
    int idade;

    @Column(name = "cpf")
    String cpf;

    @Column(name = "carro")
    CarModel car;


}
