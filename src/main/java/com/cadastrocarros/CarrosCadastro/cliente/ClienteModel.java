package com.cadastrocarros.CarrosCadastro.cliente;

import com.cadastrocarros.CarrosCadastro.cars.CarModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(name = "cpf")
    private String cpf;

    @OneToMany(mappedBy = "cliente")
    private List<CarModel> carList;


}
