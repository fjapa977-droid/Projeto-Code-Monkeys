package org.example;

import java.util.List;

public class Pagamentos {

    public void maquininhaTaxa(double valorpago,MetodoPagamento metodo)
    {
        double valorFinal = metodo.calcular(valorpago);
        System.out.println("Valor pago: " + valorpago);
        System.out.println("Metodo de pagamento: " +  metodo.getClass().getSimpleName());
        System.out.println("Valor final " + valorFinal);
    }

}
