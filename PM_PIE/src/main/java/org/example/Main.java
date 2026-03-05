package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        //aqui foi inizializado o escaner
        Scanner sc = new Scanner(System.in);
        //variavel usada dentro do switch
        int opcao = 0;

        //aqui e feita a estrutura para o usuario escolher a suas opcoes

        do {
            menu();
            opcao = sc.nextInt();
            switch (opcao)
            {
                case 1:
                    MostrarProdutos(estoque.getProdutos());

                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:

                    break;
            }
        }while (opcao != 4);

    }
    //funcao para mostrar o menu
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