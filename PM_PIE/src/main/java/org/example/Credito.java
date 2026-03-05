package org.example;

public class Credito implements MetodoPagamento{

        @Override
        public double calcular(double valorTotal) {
            return valorTotal - (valorTotal * 0.04);
        }

}
