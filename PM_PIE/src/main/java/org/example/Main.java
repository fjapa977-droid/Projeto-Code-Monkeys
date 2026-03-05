package org.example;

import java.util.*;



public class Main {
    public static void main(String[] args) {
        int flagDoWhile = 1;
        Scanner sc = new Scanner(System.in);
        Cardapio cardapio = new Cardapio();
        System.out.printf("\tSistema iniciado \n");
        do {

            System.out.printf("\t1-adicionar produto\n\t2-remover produto\n\t3-atualizar produto\n\t4-exibir cardapio\n\t5-sair");
            String entradaDeDados = sc.nextLine();
            int opcao = Integer.parseInt(entradaDeDados);
            switch (opcao) {
                case 1:
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
                    break;
                case 2:
                    cardapio.exibirCardapio();
                    System.out.printf("\nSelecione o item para remover pelo id\n\tPara voltar ao menu digite \"Sair\"");
                    try {
                        entradaDeDados = sc.nextLine();
                        idMain = Integer.parseInt(entradaDeDados);
                        //mudar para if normal essa coisa
                        String sair = entradaDeDados.trim().toLowerCase() == "sair" :break ?throw new e;
                    } catch (NumberFormatException e) {
                        System.out.printf("Erro valor digitado incorreto");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    flagDoWhile = opcao;
                    break;
                default:
                    System.out.printf("Opcao invalida");
                    break;
            } while (flagDoWhile == 1) ;

            cardapio.exibirCardapio();
        }
    }

        static void menu()
        {
            System.out.println("Seja bem-vido ao sistema/n");
            System.out.println("1.Cadastrar produto");
            System.out.println("2.Mostrar produto");
            System.out.println("3.Tirar produto da lista");
            System.out.println("4.Sair");
        }

        static void MostrarProdutos (Map<Integer,Produtos> produto)
        {
            System.out.println("Menu\n");
            for (Map.Entry<Integer,Produtos> entry : produto.entrySet())
            {
                Integer id = entry.getKey();
                Produtos item = entry.getValue();
                System.out.println("ID " + id + " Produto: " + item.getNomeProduto());
            }
        }
}