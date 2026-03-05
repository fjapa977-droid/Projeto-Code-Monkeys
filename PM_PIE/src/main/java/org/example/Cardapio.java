package org.example;

import java.util.HashMap;
import java.util.Map;

public class Cardapio {
    private Map<Integer, Produto> mapaProdutos = new HashMap<>();
    //hashmap ao inves de matriz pq fica mais facil de achar o id do produto e atualizar

    public void adicionarProduto(Produto p)
    {
        mapaProdutos.put(p.getId(), p);
    }

    private Produto buscarProduto(int id)
    {
        return mapaProdutos.get(id);
    }

    public void atualizarProduto(int id, double preco, String nomeProduto)
    {
        Produto idEncontrado = buscarProduto(id);
        if(idEncontrado != null)
        {
            idEncontrado.setNomeProduto(nomeProduto);
            idEncontrado.setPreco(preco);
        }
    }

    public void removerProduto(int id)
    {
        mapaProdutos.remove(id);
    }
}
