package org.example;

public class Dinheiro implements MetodoPagamento {

    @Override
    public double calcular(double valorTotal) {
        return valorTotal;
    }
}