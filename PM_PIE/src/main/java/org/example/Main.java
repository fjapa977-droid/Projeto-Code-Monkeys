package org.example;

import java.util.*;

public class Main {
    static int lerInt(Scanner sc){
        while(true){
            try {
                return Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("digite um numero inteiro");
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
    static String lerString(Scanner sc)
    {
        String entrada = sc.nextLine();
        return (entrada != null) ? entrada.trim().toLowerCase() : "";
    }
    static boolean lerCaixa(Caixa caixa)
    {
        if(!caixa.isAberto())
        {
            System.out.println("Caixa fechado");
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();
        Cardapio cardapio = new Cardapio();
        Caixa caixa = new Caixa();
        Clientes cliente = new Clientes("cliente","",0,1);
        Map<Integer,Pedido> pedido = new HashMap<>();
        carregarEstoque(cardapio,estoque);
        System.out.println("\tSistema iniciado");

        menuInicial(sc, cardapio, pedido, estoque, caixa);
        sc.close();
    }
    static void menuInicial(Scanner sc, Cardapio cardapio, Map<Integer,Pedido> pedido, Estoque estoque, Caixa caixa){
        int opcao;
        do {
            System.out.println(
                    """
                            1-abrir caixa
                            2-menu de produtos
                            3-fazer pedido
                            4-finalizar um pedido
                            5-fechar caixa
                            6-finalizar programa
                            """
            );
            opcao = lerInt(sc);
            switch (opcao) {
                case 1:
                    if(lerCaixa(caixa)) {
                        abrirCaixa(sc, caixa);
                    } break;
                case 2:
                    if(lerCaixa(caixa)) {
                        menuProdutos(sc, cardapio);
                    } break;
                case 3:
                    if(lerCaixa(caixa))
                    {
                        fazerPedido(sc, cardapio, pedido, estoque);
                    } break;
                case 4:
                    if (lerCaixa(caixa))
                    {
                       // finalizarPedido(sc, caixa);
                    }break;
                case 5:
                    if(lerCaixa(caixa))
                    {
                        //caixa.fecharCaixa(pedido.calcularTotal());
                    } break;
                case 6: System.out.println("Finalizando..."); break;
                default: System.out.println("Selecione uma opcao valida"); break;
            }
        }while(opcao!=5);
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
                    -sair"
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
        System.out.println("""
                1-Atualizar produto
                2-Atualizar ingredientes
                """);
            if (lerInt(sc) == 1){
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
            }else {
                cardapio.exibirCardapio();

                System.out.println("Digite o id do produto:");
                int id = lerInt(sc);

                Produto produto = cardapio.buscarProduto(id);

                if(produto == null){
                    System.out.println("Produto não encontrado");
                    return;
                }

                System.out.println("Id do ingrediente:");
                int idIng = lerInt(sc);

                System.out.println("Quantidade usada:");
                int qtd = lerInt(sc);

                produto.adicionarIngrediente(idIng, qtd);
            }

    }

    static void carregarEstoque(Cardapio cardapio, Estoque estoque)
    {
        for (Produto p: estoque.getProdutos().values())
        {
            cardapio.adicionarProduto(p);
        }
    }
    static void fazerPedido(Scanner sc, Cardapio cardapio, Map<Integer,Pedido> pedidos, Estoque estoque)
    {
        Pedido pedido = new Pedido(new Clientes("cliente","",0,1));
        cardapio.exibirCardapio();
        System.out.println("Digite o id dos produtos do cardapio para adicionar ao pedido");
        String saida;
        do{
            //logica para identificar o maior id e nao permitir q o usuario digite um id maior que a lista atual
            int maior = cardapio.getMapaProduto().values().stream().mapToInt(v -> v.getId()).max().orElse(0);

            int id= lerInt(sc);
            while(id > maior || id < 0)
            {
                System.out.println("Digite um id valido");
                id = lerInt(sc);
            }
            System.out.println("Digite a quantidade do produto escolhido");
            int qtd = lerInt(sc);
            pedido.adicionarProdutoPedido(id,qtd, cardapio.getMapaProduto());
            pedido.mostrarPedido(qtd);
            System.out.println("Se concluir seu pedido digite \"sair\", se deseja continuar adicionando produtos ao pedido digite \"continuar\"");
            saida = lerString(sc);
        }while (!saida.equals("sair"));
        pedido.atualizarEstoque(estoque);
        pedidos.put(pedidos.size()+1, pedido);
    }
    static void abrirCaixa(Scanner sc, Caixa caixa)
    {
        System.out.println("Digite o valor inicial do caixa");
        double valorInicial = lerDouble(sc);
        caixa.abrir(valorInicial);
    }
}

