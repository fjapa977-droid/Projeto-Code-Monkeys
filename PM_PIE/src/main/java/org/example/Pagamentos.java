package org.example;

import java.util.List;

public class Pagamentos extends Carrinho{
    private String pagamento;
    private double desconto;

    public Pagamentos(String pagamento, List<Object> numPedido, List<List<Object>> listaMistaMock) {
        super(numPedido, listaMistaMock);
        this.pagamento = pagamento;
    }

    private void diferencaPagamento(String pagamento, List<Object> numPedido)
    {
        //amanha arrumo
    }
}
