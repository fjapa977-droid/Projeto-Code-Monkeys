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

    //esto e uma exemplo de como vai funcionar esta parte

    /*public class(double valorPago,double valorTotal)
    {
        if (valorPago > valorTotal)
        {
            System.out.println("!!Pagamento realizado com sucesso!!");
        }
        else
        {
            System.out.println("Valor incorreto");
        }
    }*/

}
