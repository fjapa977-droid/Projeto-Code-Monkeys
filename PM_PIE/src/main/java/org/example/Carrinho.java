package org.example;

import java.util.List;

public class Carrinho extends Produtos{
    private List<Object> numPedido;
    private Double soma;
    public Carrinho(List<Object> numPedido, List<List<Object>> listaMistaMock) {
        super(listaMistaMock);
        this.numPedido = numPedido;

        CalcularTotal(listaMistaMock);
        AdicionaraAoPedido(numPedido, listaMistaMock);
    }

    private void CalcularTotal(List<List<Object>> listaMistaMock)
    {
        double somaTotal = 0.0;
        for(List<Object> i : listaMistaMock)
        {
            Object valor = i.get(2);
            if(valor instanceof Number)
            {
                somaTotal += ((Number) valor).doubleValue();
            }
        }
        setSoma(somaTotal);
    }
    private void AdicionaraAoPedido(List<Object> numPedido, List<List<Object>> listaMistaMock)
    {
        numPedido.add(listaMistaMock.get(0));//e pra no final retornar 29.5
        numPedido.add(getSoma());
    }
    public List<Object> getNumPedido() {
        return numPedido;
    }

    public Double getSoma() {
        return soma;
    }

    public void setSoma(Double soma) {
        this.soma = soma;
    }
}
