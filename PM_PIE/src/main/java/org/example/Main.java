package org.example;

import java.util.*;



public class Main {
    public static void main(String[] args) {
        int flagDoWhile = 1;
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        Cardapio cardapio = new Cardapio();
        //aqui estao os metodos de pagamento e o pagamento onde tem a funcao para mostrar o valor
        Pagamentos pagamento = new Pagamentos();
        MetodoPagamento metodo;
        System.out.printf("\tSistema iniciado \n");

        do {

            menu();
            String entradaDeDados = sc.nextLine();
            opcao = Integer.parseInt(entradaDeDados);
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


                    cardapio.adicionarProduto(new Produto(idMain, nomeMain, precoMain)); //cria novo id no hash
                    break;
                case 2:
                    cardapio.exibirCardapio();
                    System.out.printf("\nSelecione o item para remover pelo id\n\tPara voltar ao menu digite \"Sair\"");
                    try {
                        entradaDeDados = sc.nextLine();
                        idMain = Integer.parseInt(entradaDeDados);
                        //mudar para if normal essa coisa
                        //String sair = entradaDeDados.trim().toLowerCase() == "sair" : break ?throw new;
                    } catch (NumberFormatException e) {
                        System.out.printf("Erro valor digitado incorreto");
                    }
                    break;
                case 3:
                        //aqui embaixo tem um texte de metodos de pagamento e
                        pagamento.maquininhaTaxa(120,metodo = new Pix());
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
        } while(opcao != 5  );
    }

        static void menu()
        {
            System.out.println("\t1-adicionar produto\n\t2-remover produto\n\t3-atualizar produto\n\t4-exibir cardapio\n\t5-sair");
        }

        static void MostrarProduto (Map<Integer,Produto> produto)
        {
            System.out.println("Menu\n");
            for (Map.Entry<Integer,Produto> entry : produto.entrySet())
            {
                Integer id = entry.getKey();
                Produto item = entry.getValue();
                System.out.println("ID " + id + " Produto: " + item.getNomeProduto());
            }
        }
}