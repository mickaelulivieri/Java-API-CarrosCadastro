package com.cadastrocarros.CarrosCadastro.cars;

import com.cadastrocarros.CarrosCadastro.cliente.ClienteModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "tb_carros")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "marca")
    String marca;

    @Column(name = "modelo")
    String modelo;

    @Column(name = "img_carro")
    String img;

    @Column(name = "preco")
    Double price;

    @Column(name = "chassi", unique = true)
    String chassi;


    @Column(name = "placa", unique = true)
    String placa;

    @ManyToOne
    @JoinColumn(name = "fk_cliente_id")
    private ClienteModel cliente;

}