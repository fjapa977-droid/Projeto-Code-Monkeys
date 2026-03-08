package org.example;

import java.util.HashMap;
import java.util.Map;

public class Cardapio {
    private Map<Integer, Produto> mapaProduto = new HashMap<>();
    //hashmap ao inves de matriz pq fica mais facil de achar o id do produto e atualizar

    public void adicionarProduto(Produto p)
    {
        mapaProduto.put(p.getId(), p);
    }

    Produto buscarProduto(int id)
    {
        return mapaProduto.get(id);
    }

    public void atualizarProduto(int id, double preco, String nome, String categoria )
    {
        Produto idEncontrado = buscarProduto(id);
        if(idEncontrado != null)
        {
            idEncontrado.setNome(nome);
            idEncontrado.setPreco(preco);
            idEncontrado.setCategoria(categoria);
        }
    }

    public void removerProduto(int id)
    {
        mapaProduto.remove(id);
    }

    public void exibirCardapio() {
        if (mapaProduto.isEmpty()) {
            System.out.println("O cardápio está vazio.");
        } else {
            // Percorre todos os valores do Map e imprime
            for (Produto p : mapaProduto.values()) {
                System.out.println("ID: " + p.getId() + " | " + p.getNome() + " - R$ " + p.getPreco() + "|" + p.getCategoria());
            }
        }
    }

    public void exibirProduto(int id)
    {
        if (mapaProduto.isEmpty())
        {
            System.out.println("Cardapio esta vazio");
        } else {
            Produto p = mapaProduto.get(id);
            System.out.printf("ID: %d | Nome: \"%s\" | Preço: R$ %.2f%n",
                    p.getId(), p.getNome(), p.getPreco());
        }
    }

    public void buscarPorCategoria(String categoria){
        for (Produto p : mapaProduto.values()){
            if (p.getCategoria().equalsIgnoreCase(categoria)){
                System.out.println(p);
            }
        }
    }

    public void buscarPorNome(String nome){
        for(Produto p : mapaProduto.values()){
            if(p.getNome().toLowerCase().contains(nome.toLowerCase())){
                System.out.println(p);
            }
        }
    }

    public Map<Integer, Produto> getMapaProduto() {
        return mapaProduto;
    }
}
