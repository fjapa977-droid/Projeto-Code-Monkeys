package org.example;

import java.util.Scanner;

public class Main {
//criei esses metodos pra nao ter que ficar repetindo o parse -feh
    static int lerInt(Scanner sc){


        while(true){
            try {
                return Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("digite um umero inteiro");
            }
        }
    }
    static double lerDouble(Scanner sc){
        while (true){
            try {
                return Double.parseDouble(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("digite um numero quebraado: ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();
        Cardapio cardapio = new Cardapio();
        carregarEstoque(cardapio,estoque);
        System.out.println("\tSistema iniciado");

        menuProdutos(sc, cardapio);
        sc.close();
    }

    //tirei flagdowhile porraa nem no 1 semestre a gente fez isso - feh
    static void menuProdutos(Scanner sc, Cardapio cardapio) {
        int opcao;// sem o parse pq sa colocasse letra dava erro ISSO AQUI NAO É BERENISE
        do {
            //nao sei pq tava dando \n fdp
            System.out.println("""
                    1-adicionar produto
                    2-remover produto
                    3-atualizar produto
                    4-exibir cardapio
                    5-sair"
                    """);
            opcao = lerInt(sc);

            switch (opcao){
                case 1 -> adicionarProduto(sc, cardapio);
                case 2 -> removerProduto(sc, cardapio);
                case 3 -> atualizarProduto(sc, cardapio);
                case 4 -> cardapio.exibirCardapio();
                case 5 -> System.out.println("Saindo...");

                default -> System.out.println("escreve direito porra");
            }
        }while (opcao != 5);
    }
    static void adicionarProduto(Scanner sc, Cardapio cardapio){
        System.out.println("Digite o id: ");
        int id = lerInt(sc);

        System.out.println("Nome: ");
        String nome = sc.nextLine().trim();

        System.out.println("preco: ");
        double preco = lerDouble(sc);

        System.out.println("categoria:");
        String categoria = sc.nextLine().trim();

        cardapio.adicionarProduto(new Produto(id,nome,preco,categoria));
    }

    static void removerProduto(Scanner sc, Cardapio cardapio){
        cardapio.exibirCardapio();
        System.out.println("Digite o id do produti");

        try{
            int id = lerInt(sc);
            cardapio.removerProduto(id);
            System.out.println("produto removido");
        }catch (Exception e){
            System.out.println("entrada invalida");
        }
    }

    static void atualizarProduto(Scanner sc, Cardapio cardapio){
        cardapio.exibirCardapio();

        System.out.println("digite o id: ");
        int id = lerInt(sc);

        System.out.println("novo nome");
        String nome = sc.nextLine().trim();

        System.out.println("novo preco");
        double preco = lerDouble(sc);

        System.out.println("nova categoria");
        String categoria = sc.nextLine().trim();

        cardapio.atualizarProduto(id,preco,nome,categoria);
        cardapio.exibirProduto(id);
    }

    static void carregarEstoque(Cardapio cardapio, Estoque estoque)
    {
        for (Produto p: estoque.getProdutos().values())
        {
            cardapio.adicionarProduto(p);
        }

    }
}

