package org.example;

import java.util.List;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private Clientes cliente;

    private List<ItemPedido> itens;

    public Pedido(Clientes cliente){
        this.cliente = cliente;
        itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade){
        for(ItemPedido item : itens){
            if(item.getProduto().getId() == produto.getId()){
                item.aumentarQuantidade(quantidade);
                return;
            }
        }
        ItemPedido novoItem = new ItemPedido(produto, quantidade);
        itens.add(novoItem);
    }

    public void removerItem(int idProduto){
        itens.removeIf(item -> item.getProduto().getId() == idProduto);
    }

    public double calcularTotal(){

        double total = 0;

        for(ItemPedido item : itens){
            total += item.calcularSubtotal();
        }

        return total;
    }
    public void mostrarPedido() {
        if (itens.isEmpty())
        {
            System.out.println("Lista de itens vazia");
            return;
        }
        for(ItemPedido item : itens)
        {
            System.out.println(item);
        }
    }
    public void adicionarProdutoPedido(int id, int quantidade, Map<Integer, Produto> cardapio)
    {
        /*if (cardapio.isEmpty())
        {
            System.out.println("Cardapio esta vazio");
        } else {*/
            adicionarItem(cardapio.get(id), quantidade);
        //}
    }

    public Clientes getCliente(){
        return cliente;
    }

    public void atualizarEstoque(Estoque estoque){

        for(ItemPedido item : itens){

            Produto produto = item.getProduto();
            int quantidadeProduto = item.getQuantidade();

            for(Map.Entry<Integer,Integer> ing : produto.getIngredientes().entrySet()){

                int idIngrediente = ing.getKey();
                int quantidadeUsada = ing.getValue() * quantidadeProduto;

                estoque.darBaixa(idIngrediente, quantidadeUsada);
            }
        }
    }

}

