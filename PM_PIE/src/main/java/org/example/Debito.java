package org.example;

public class Debito implements MetodoPagamento {

    @Override
    public double calcular(double valorTotal) {
        return valorTotal - (valorTotal * 0.025);
    }
}