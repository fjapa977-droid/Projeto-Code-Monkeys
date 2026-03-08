package org.example;

public class Pix implements MetodoPagamento{

    @Override
    public double calcular(double valorTotal)
    {
        return valorTotal - (valorTotal * 0.0145);
    }

}
