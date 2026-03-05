package org.example;
//feh

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<Integer,Produtos> produtos;

    public Estoque()
    {
        produtos = new HashMap<>();
        produtos.put(1,new Produtos(1, "X-Salada", 18.90));
        produtos.put(2,new Produtos(2, "X-Bacon", 22.50));
        produtos.put(3,new Produtos(3, "X-Tudo", 28.75));
        produtos.put(4,new Produtos(4, "Batata Frita Média", 12.99));
        produtos.put(5,new Produtos(5, "Refrigerante Lata", 6.50));
    }

    public Estoque(Map<Integer, Produtos> produtos) {
        this.produtos = produtos;
    }

    public Map<Integer, Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<Integer, Produtos> produtos) {
        this.produtos = produtos;
    }
}
