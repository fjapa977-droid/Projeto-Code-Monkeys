package org.example;
//feh

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<Integer,Produto> Produto;

    public Estoque()
    {
        Produto = new HashMap<>();
        Produto.put(1,new Produto(1, "X-Salada", 18.90));
        Produto.put(2,new Produto(2, "X-Bacon", 22.50));
        Produto.put(3,new Produto(3, "X-Tudo", 28.75));
        Produto.put(4,new Produto(4, "Batata Frita Média", 12.99));
        Produto.put(5,new Produto(5, "Refrigerante Lata", 6.50));
    }

    public Estoque(Map<Integer, Produto> Produto) {
        this.Produto = Produto;
    }

    public Map<Integer, Produto> getProduto() {
        return Produto;
    }

    public void setProduto(Map<Integer, Produto> Produto) {
        this.Produto = Produto;
    }
}
