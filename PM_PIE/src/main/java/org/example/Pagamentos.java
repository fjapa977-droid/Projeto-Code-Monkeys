package org.example;

import java.util.List;

public class Pagamentos extends Carrinho{
    private String pagamento;
    private double desconto;

    public Pagamentos(String pagamento, List<Object> numPedido) {
        super(numPedido);
        this.pagamento = pagamento;
    }

}
