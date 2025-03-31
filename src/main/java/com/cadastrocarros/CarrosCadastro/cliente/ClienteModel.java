package com.cadastrocarros.CarrosCadastro.cliente;

import com.cadastrocarros.CarrosCadastro.cars.CarModel;

public class ClienteModel {

    String nome;

    int idade;

    String cpf;

    CarModel car;

    public ClienteModel(String nome, CarModel car, String cpf, int idade) {
        this.nome = nome;
        this.car = car;
        this.cpf = cpf;
        this.idade = idade;
    }

    public ClienteModel() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CarModel getCar() {
        return car;
    }

    public void setCar(CarModel car) {
        this.car = car;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
