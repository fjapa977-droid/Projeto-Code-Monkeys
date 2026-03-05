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

        menuProdutos(sc, cardapio, flagDoWhile);
    }

    //tirei da main principal e fiz um metodo, mais provavel q isso tire nota do que ajude
    static void menuProdutos(Scanner sc, Cardapio cardapio, int flagDoWhile)
    {

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


                    cardapio.adicionarProduto(new Produto(idMain, nomeMain, precoMain)); //cria novo id no hash
                    break;
                case 2:
                    cardapio.exibirCardapio();
                    System.out.printf("\nSelecione o item para remover pelo id\n\tPara voltar ao menu digite \"Sair\"");
                    entradaDeDados = sc.nextLine();
                    String sair = entradaDeDados.trim().toLowerCase();
                    if(sair.equals("sair")){
                        break;
                    }
                    try {
                        idMain = Integer.parseInt(entradaDeDados);
                        cardapio.removerProduto(idMain);
                        System.out.printf("\nProduto removido com sucesso");
                    } catch (NumberFormatException e) {
                        System.out.printf("Erro: digite um numero inteiro ou Sair");
                    }
                    break;
                case 3:
                    cardapio.exibirCardapio();
                    System.out.printf("\nSelecione o item para atualizar pelo id\n\tPara voltar ao menu digite \"Sair\"");
                    entradaDeDados = sc.nextLine();
                    sair = entradaDeDados.trim().toLowerCase();
                    if(sair.equals("sair")){
                        break;
                    } try {
                    idMain = Integer.parseInt(entradaDeDados);

                    System.out.printf("Digite o nome do produto: \n");
                    entradaDeDados = sc.nextLine();
                    nomeMain = entradaDeDados.trim();

                    System.out.printf("Digite o preco do produto(use . ex: 5.99): \nR$");
                    entradaDeDados = sc.nextLine();
                    precoMain = Double.parseDouble(entradaDeDados);

                    cardapio.atualizarProduto(idMain, precoMain, nomeMain);
                    System.out.println("Atualizacao feita com sucesso");
                    cardapio.exibirProduto(idMain);
                }
                catch (NumberFormatException e){
                    System.out.printf("Erro no tipo de dado");
                }//catch
                        //aqui embaixo tem um texte de metodos de pagamento e
                        pagamento.maquininhaTaxa(120,metodo = new Pix());
                    break;
                case 4:
                    if(cardapio == null){
                        System.out.println("Cardapio esta vazio");
                        break;
                    } else {
                        cardapio.exibirCardapio();
                    }
                    break;
                case 5:
                    flagDoWhile = opcao;
                    break;
                default:
                    System.out.printf("Opcao invalida");
                    break;
            }
        }while (flagDoWhile == 1);

        cardapio.exibirCardapio();
    }
}
            cardapio.exibirCardapio();
        } while(opcao != 5  );
    }

