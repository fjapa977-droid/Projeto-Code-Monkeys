package org.example;

import java.util.HashMap;
import java.util.Map;

public class Cardapio {
    private Map<Integer, Produtos> mapaProdutos = new HashMap<>();
    //hashmap ao inves de matriz pq fica mais facil de achar o id do produto e atualizar

    public void adicionarProduto(Produtos p)
    {
        mapaProdutos.put(p.getId(), p);
    }

    Produtos buscarProduto(int id)
    {
        return mapaProdutos.get(id);
    }

    public void atualizarProduto(int id, double preco, String nomeProduto)
    {
        Produtos idEncontrado = buscarProduto(id);
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

    public void exibirCardapio() {
        if (mapaProdutos.isEmpty()) {
            System.out.println("O cardápio está vazio.");
        } else {
            // Percorre todos os valores do Map e imprime
            for (Produtos p : mapaProdutos.values()) {
                System.out.println("ID: " + p.getId() + " | " + p.getNomeProduto() + " - R$ " + p.getPreco());
            }
        }
    }

    public void exibirProduto(int id)
    {
        if (mapaProdutos.isEmpty())
        {
            System.out.println("Cardapio esta vazio");
        } else {
            Produtos p = mapaProdutos.get(id);
            System.out.printf("ID: %d | Nome: \"%s\" | Preço: R$ %.2f%n",
                    p.getId(), p.getNomeProduto(), p.getPreco());
        }
    }
}
