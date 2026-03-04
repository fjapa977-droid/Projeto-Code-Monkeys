package lanchoneteSistemaTeste2;

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
           }
        }
        ItemPedido novoItem = new ItemPedido(produto, quantidade);
        itens.add(novoItem);
    }

    public double calcularTotal(){

        double total = 0;

        for(ItemPedido item : itens){
            total += item.calcularSubtotal();
        }

        return total;
    }
}
