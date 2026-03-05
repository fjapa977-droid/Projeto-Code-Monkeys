package org.example;

import java.util.List;
import java.util.ArrayList;

public class Pedido {

    private List<ItemPedido> itens;

    private Pedido(){
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
}
