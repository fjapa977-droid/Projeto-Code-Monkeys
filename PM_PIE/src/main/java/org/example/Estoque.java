package org.example;
//feh

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<Integer, Ingredientes> ingredientes = new HashMap<>();
    private Map<Integer,Produto> produtos;
    public Estoque ()
    {
        produtos = new HashMap<>();

        produtos.put(1, new Produto(1, "X-Salada", 18.90, "Hamburguer"));
        produtos.put(2, new Produto(2, "X-Bacon", 22.50, "Hamburguer"));
        produtos.put(3, new Produto(3, "Coca-Cola", 6.00, "Bebida"));
    }

    public Map<Integer, Produto> getProdutos() {
        return produtos;
    }

    public void adicionarIngredientes(int id, int quantidade, String nome, double peso){
        Ingredientes novo = new Ingredientes(id,nome,quantidade,peso);
        ingredientes.put(id, novo);
    }

    public Ingredientes buscarIngrediente(int id){
        return ingredientes.get(id);
    }

    public void removerIngredientes(int id){
        ingredientes.remove(id);
    }

    public void atualizarQuantidade(int id, int novaQuantidade){
        Ingredientes ingrediente = ingredientes.get(id);
        if(ingrediente != null){
            ingrediente.setQuantidade(novaQuantidade);
        }
    }

    public void darBaixa(int id, int quantidade){
        Ingredientes ingrediente = ingredientes.get(id);

        if(ingrediente != null){
            int novaQuantidade = ingrediente.getQuantidade() - quantidade;

            if(novaQuantidade < 0){
                System.out.println("Estoque insuficiente seu bosta");
                return;
            }
            ingrediente.setQuantidade(novaQuantidade);
        }
    }

    public void mostrarEstoque(){
        for(Ingredientes ing : ingredientes.values()){
            System.out.println(
                    ing.getId() + " - " +
                    ing.getNome() +
                    " / quantidade: " + ing.getQuantidade() +
                    " / peso: " + ing.getPeso()
            );
        }
    }
}