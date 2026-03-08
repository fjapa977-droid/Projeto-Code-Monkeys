package org.example;

public class Caixa {
    private double caixaInicial;
    private double caixaFinal;
    private boolean aberto;

    public Caixa()
    {
        this.aberto = false;
        this.caixaFinal = 0;
    }

    public void abrir(double valorInicial)
    {
        this.caixaInicial = valorInicial;
        this.aberto = true;
        System.out.println("Caixa aberto com R$" + this.caixaInicial);
    }

    public void fecharCaixa(double totalVendas)
    {
        double totalFinal = this.caixaInicial + totalVendas;
        System.out.println("Caixa iniciado com R$" + this.caixaInicial);
        System.out.println("Valor total das vendas R$" + totalVendas);
        System.out.println("Valor final do caixa R$" + totalFinal);
        this.aberto = false;
        totalVendas = 0;
        System.out.println("Caixa fechado com sucesso");
    }

    public boolean isAberto() {
        return aberto;
    }

    public double getCaixaInicial() {
        return caixaInicial;
    }
}
