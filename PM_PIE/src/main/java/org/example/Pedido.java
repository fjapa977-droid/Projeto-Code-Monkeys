package org.example;

import java.util.List;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private Clientes cliente;

    private Map<Integer,ItemPedido> itens;

    public Pedido(Clientes cliente){
        this.cliente = cliente;
        itens = new HashMap<>();
    }

    public void adicionarItem(Produto produto, int quantidade){

        ItemPedido item = itens.get(produto.getId());

        if (item != null)
        {
            item.aumentarQuantidade(quantidade);
        }
        else {
            itens.put(produto.getId(), new ItemPedido(produto,quantidade));
        }
    }

    public void removerItem(int idProduto){
        itens.remove(idProduto);
    }

    public double calcularTotal(){

        double total = 0;

        for(ItemPedido item : itens.values()){
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
                for (ItemPedido p : itens.values()) {
                    System.out.printf("%s - R$ %.2f | Quantidade %d | Total: %.2f\n",
                            p.getProduto().getNome(),
                            p.getProduto().getPreco(),
                            p.getQuantidade(),
                            p.getProduto().getPreco() * p.getQuantidade());
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

        for(ItemPedido item : itens.values()){

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

