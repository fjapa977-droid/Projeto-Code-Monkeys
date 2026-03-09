package org.example;

public class Pagamentos {

    public void maquininhaTaxa(Pedido pedido, MetodoPagamento metodo)
    {
        double valorPago = pedido.calcularTotal();

        double valorFinal = metodo.calcular(valorPago);

        System.out.println("Valor pago: " + valorPago);
        System.out.println("Metodo de pagamento: " +  metodo.getClass().getSimpleName());
        System.out.printf("Valor final %.2f\n", valorFinal);
    }

}
