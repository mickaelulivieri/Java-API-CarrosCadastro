package com.cadastrocarros.CarrosCadastro.cars;

import com.cadastrocarros.CarrosCadastro.cliente.ClienteModel;

public class CarModel {

    String marca;

    String modelo;

    String img;

    Double price;

    String chassi;

    ClienteModel cliente;

    String placa;

    public CarModel(String marca, String placa, ClienteModel cliente, String chassi, Double price, String img, String modelo) {
        this.marca = marca;
        this.placa = placa;
        this.cliente = cliente;
        this.chassi = chassi;
        this.price = price;
        this.img = img;
        this.modelo = modelo;
    }

    public CarModel() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}