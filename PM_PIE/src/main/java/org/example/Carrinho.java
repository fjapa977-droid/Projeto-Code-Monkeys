package org.example;

import java.util.List;
/*
* Inves de fazer listas aqui nas funcoes fazer a lista na main com um cardapio
* assim nao precisa ficar iterando td vez, e so buscar por id com os getters
* muito masi facil desta maneira
* ou seja
* classes sem listas de objetos so com os dados e a main vai ter uma variavel
* que vai conter os dados certos
* errei fui mlk de nao ter pensado nisso a 3 dias atras
* */
public class Carrinho extends Produtos{
    private List<Object> numPedido; //vai voltar a ser um int pq nao necessariamente precisa armazenar td
    private Double soma;
    private static int globalCounter = 0; //vai ser o numPedido
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
        numPedido.add(listaMistaMock.get(0));//melhorar essa logica
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
