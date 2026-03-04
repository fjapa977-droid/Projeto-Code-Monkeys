package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int flagDoWhile = 1;
        Scanner sc = new Scanner(System.in);
        Cardapio cardapio = new Cardapio();
        System.out.printf("\tSistema iniciado \n");
        do{
            int opcao;
            printf("\t1-adicionar produto\n\t2-remover produto\n\t3-atualizar produto\n\t4-exibir cardapio\n\t5-sair");
            String entradaDeDados = sc.nextLine();

            switch (opcao){




                System.out.printf("Digite o id do produto: \n");
                entradaDeDados = sc.nextLine();
                int idMain = Integer.parseInt(entradaDeDados);
                //id manual por enquanto

                System.out.printf("Digite o nome do produto: \n");
                entradaDeDados = sc.nextLine();
                String nomeMain = entradaDeDados.trim();
                //nome produto

                System.out.printf("Digite um preço: \n");
                entradaDeDados = sc.nextLine();
                double precoMain = Double.parseDouble(entradaDeDados);
                //preco


                cardapio.adicionarProduto(new Produtos(idMain, nomeMain, precoMain)); //cria novo id no hash

                System.out.printf("Continuar adicionando?\n\t1-sim\n\t2-nao\n");
                entradaDeDados = sc.nextLine();
                int pegaDado = Integer.parseInt(entradaDeDados);

                if(pegaDado == 2) flagDoWhile = pegaDado;
            }while (flagDoWhile == 1);

        cardapio.exibirCardapio();
    }
}