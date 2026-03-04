package lanchoneteSistemaTeste2;

public class ItemPedido {

    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto(){
        return produto;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void aumentarQuantidade(int qtd){
        if(qtd <= 0){
            throw new IllegalArgumentException("Quantidade inválida");
        }
        this.quantidade += qtd;
    }

    public double calcularSubtotal(){
        return produto.getPreco() * quantidade;
    }
}
