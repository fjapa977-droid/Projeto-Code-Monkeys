package org.example;

import java.util.*;


//vcs vao ver asserts nao esquecer de tirar depois, somente para fase de testes, compilar com o comando java -ea Main
public class Main {
    public static void main(String[] args) {
        int flagDoWhile = 1;
        Scanner sc = new Scanner(System.in);
        Cardapio cardapio = new Cardapio();
        /*aqui estao os metodos de pagamento e o pagamento onde tem a funcao para mostrar o valor
        Pagamentos pagamento = new Pagamentos();
        MetodoPagamento metodo;*/
        System.out.print("\tSistema iniciado \n");

        menuProdutos(sc, cardapio, flagDoWhile);
    }

    //tirei da main principal e fiz um metodo, mais provavel q isso tire nota do que ajude
    static void menuProdutos(Scanner sc, Cardapio cardapio, int flagDoWhile)
    {

        do {

            System.out.print("\t1-adicionar produto\n\t2-remover produto\n\t3-atualizar produto\n\t4-exibir cardapio\n\t5-sair");
            String entradaDeDados = sc.nextLine();
            int opcao = Integer.parseInt(entradaDeDados);
            switch (opcao) {
                case 1:
                    System.out.print("Digite o id do produto: \n");
                    entradaDeDados = sc.nextLine();
                    int idMain = Integer.parseInt(entradaDeDados);
                    //id manual por enquanto

                    System.out.print("Digite o nome do produto: \n");
                    entradaDeDados = sc.nextLine();
                    String nomeMain = entradaDeDados.trim();
                    //nome produto

                    System.out.print("Digite um preço: \n");
                    entradaDeDados = sc.nextLine();
                    double precoMain = Double.parseDouble(entradaDeDados);
                    //preco


                    assert cardapio != null;
                    cardapio.adicionarProduto(new Produto(idMain, nomeMain, precoMain)); //cria novo id no hash
                    break;
                case 2:
                    assert cardapio != null;
                    cardapio.exibirCardapio();
                    System.out.print("\nSelecione o item para remover pelo id\n\tPara voltar ao menu digite \"Sair\"");
                    entradaDeDados = sc.nextLine();
                    String sair = entradaDeDados.trim().toLowerCase();
                    if(sair.equals("sair")){
                        break;
                    }
                    try {
                        idMain = Integer.parseInt(entradaDeDados);
                        cardapio.removerProduto(idMain);
                        System.out.print("\nProduto removido com sucesso");
                    } catch (NumberFormatException e) {
                        System.out.print("Erro: digite um numero inteiro ou Sair");
                    }
                    break;
                case 3:
                    assert cardapio != null;
                    cardapio.exibirCardapio();
                    System.out.print("\nSelecione o item para atualizar pelo id\n\tPara voltar ao menu digite \"Sair\"");
                    entradaDeDados = sc.nextLine();
                    sair = entradaDeDados.trim().toLowerCase();
                    if(sair.equals("sair")){
                        break;
                    } try {
                    idMain = Integer.parseInt(entradaDeDados);

                    System.out.print("Digite o nome do produto: \n");
                    entradaDeDados = sc.nextLine();
                    nomeMain = entradaDeDados.trim();

                    System.out.print("Digite o preco do produto(use . ex: 5.99): \nR$");
                    entradaDeDados = sc.nextLine();
                    precoMain = Double.parseDouble(entradaDeDados);

                    cardapio.atualizarProduto(idMain, precoMain, nomeMain);
                    System.out.println("Atualizacao feita com sucesso");
                    cardapio.exibirProduto(idMain);
                }
                catch (NumberFormatException e){
                    System.out.print("Erro no tipo de dado");
                }//catch

                    //isso me assustou achei q tinha fodido sua parte mas arrumei tudo acho q  n perdeu nd nao
                        //aqui embaixo tem um texte de metodos de pagamento e
                        //pagamento.maquininhaTaxa(120,metodo = new Pix());
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
                    System.out.print("Opcao invalida");
                    break;
            }
        }while (flagDoWhile == 1);

        assert cardapio != null;
        cardapio.exibirCardapio();
    }
}

