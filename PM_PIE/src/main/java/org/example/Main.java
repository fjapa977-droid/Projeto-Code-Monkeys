package org.example;

import java.util.*;

public class Main {
    static int lerInt(Scanner sc){
        while(true){
            try {
                return Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("digite um número inteiro");
            }
        }
    }
    static double lerDouble(Scanner sc){
        while (true){
            try {
                return Double.parseDouble(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite algum preço ");
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
        double totalCaixa = 0;
        Caixa caixa = new Caixa();
        //aqui ta criando so um cliente
        int idCLiente = (int)(Math.random()*10000);
        Clientes cliente = new Clientes("cliente-" +idCLiente,"",0,idCLiente);
        Map<Integer,Pedido> pedido = new HashMap<>();
        carregarEstoque(cardapio,estoque);
        System.out.println("\tSistema iniciado");

        menuInicial(sc, cardapio, pedido, estoque, caixa, totalCaixa, cliente);
        sc.close();
    }
    static void menuInicial(Scanner sc, Cardapio cardapio, Map<Integer,Pedido> pedido, Estoque estoque, Caixa caixa, double totalCaixa, Clientes cliente){
        int opcao;
        do {
            System.out.println(
                    """
                            1-abrir caixa
                            2-cardapio
                            3-fazer pedido
                            4-valor total dos caixas
                            5-estoque
                            6-fechar caixa
                            7- Mostrar os pedidos
                            8-finalizar programa
                            """
            );
            opcao = lerInt(sc);
            switch (opcao) {
                case 1: abrirCaixa(sc, caixa);break;
                case 2:
                    if(lerCaixa(caixa)) {
                        menuProdutos(sc, cardapio);
                    } break;
                case 3:
                    if(lerCaixa(caixa))
                    {
                        fazerPedido(sc, cardapio, pedido, estoque,cliente);
                    } break;
                case 4:
                    if (lerCaixa(caixa))
                    {
                        verCaixaAtual(pedido, totalCaixa);
                    } break;
                case 5: menuEstoque(sc, estoque);break;

                case 6:
                    if(lerCaixa(caixa))
                    {
                        double faturamento = calcularCaixa(pedido, totalCaixa);
                        caixa.fecharCaixa(faturamento);

                    } break;
                case 7: MostrarPedidos(pedido); break;
                case 8: System.out.println("Finalizando..."); break;
                default: System.out.println("Selecione uma opcao valida"); break;
            }
        }while(opcao!=8);
    }

    static void menuProdutos(Scanner sc, Cardapio cardapio) {
        int opcao;
        do {
            System.out.println("""
                    1-adicionar produto
                    2-remover produto
                    3-atualizar produto
                    4-exibir cardapio
                    5-buscar produto
                    6-sair"
                    """);
            opcao = lerInt(sc);

            switch (opcao){
                case 1 -> adicionarProduto(sc, cardapio);
                case 2 -> removerProduto(sc, cardapio);
                case 3 -> atualizarProduto(sc, cardapio);
                case 4 -> cardapio.exibirCardapio();
                case 5 -> buscarProduto(sc, cardapio);
                case 6 -> System.out.println("Saindo...");

                default -> System.out.println("Opçao invalida!");
            }
        }while (opcao != 6);
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
        System.out.println("Digite o id do produto");

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
        int opcao = lerInt(sc);
            if (opcao == 1){
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
            }else if(opcao == 2){
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
            }else {
                System.out.println("Opçao invalida");
            }

    }

    static void carregarEstoque(Cardapio cardapio, Estoque estoque)
    {
        for (Produto p: estoque.getProdutos().values())
        {
            cardapio.adicionarProduto(p);
        }
    }
    static void fazerPedido(Scanner sc, Cardapio cardapio, Map<Integer,Pedido> pedidos, Estoque estoque,Clientes cliente)
    {
        int opcao;
        Pedido pedido = new Pedido(new Clientes(cliente.getNomeCliente(),cliente.getEndereco(),cliente.getTelefone(),cliente.getIdCliente()));
        do{
            System.out.println("""
                    1-adicionar produto
                    2-remover produto do pedido
                    3-finalizar pedido
                    """);
            opcao = lerInt(sc);

            switch (opcao){
                case 1 ->{
                    cardapio.exibirCardapio();


                    System.out.println("digite o id do produto: ");
                    int id = lerInt(sc);

                    System.out.println("digite a quantidade: ");
                    int qtd = lerInt(sc);

                    Produto produto = cardapio.getMapaProduto().get(id);
                    if(produto == null){
                        System.out.println("produto nao existe");
                        break;
                    }

                    pedido.adicionarProdutoPedido(id,qtd, cardapio.getMapaProduto());
                    pedido.mostrarPedido();
                }

                case 2 -> {
                    pedido.mostrarPedido();

                    System.out.println("digite o id do produto pra remover");
                    int id = lerInt(sc);

                    pedido.removerItem(id);

                    pedido.mostrarPedido();
                }

                case 3 -> {
                    System.out.println("fechando pedido");
                    pedidos.put(pedidos.size()+1,pedido);
                }
                default -> System.out.println("opçao invalida");
            }
        }while (opcao != 3);
        pedido.atualizarEstoque(estoque);

        Pagamentos pagamentos = new Pagamentos();
        System.out.println("""
                Escolha o metodo de pagamento
                1- pix
                2- credito
                3- debito
                4- dinheiro
                """);

        int opcaoPagamento = lerInt(sc);

        MetodoPagamento metodo = null;

        switch (opcaoPagamento){
            case 1 -> metodo = new Pix();
            case 2 -> metodo = new Credito();
            case 3 -> metodo = new Debito();
            case 4 -> metodo = new Dinheiro();
            default -> System.out.println("metodo invalido");
        }

        if(metodo != null){
            pagamentos.maquininhaTaxa(pedido, metodo);
        }
    }

    static void buscarProduto(Scanner sc, Cardapio cardapio){
        System.out.println("""
                Buscar produto por:
                1-Nome
                2-Categoria
                """);
        int opcao = lerInt(sc);

        if(opcao == 1){
            System.out.println("Digite o nome do produto");
            String nome = sc.nextLine();

            cardapio.buscarPorNome(nome);
        } else if (opcao == 2) {
            System.out.println("Digite a categoria");
            String categoria = sc.nextLine();

            cardapio.buscarPorCategoria(categoria);
        }else {
            System.out.println("Opção invalida");
        }
    }

    static void MostrarPedidos(Map<Integer,Pedido> pedidos)
    {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado");
            return;
        }

        for (Pedido p : pedidos.values()) {
            p.mostrarPedido(); // chama o metodo do pedido
            System.out.println("-------------------");
        }
    }

    static void menuEstoque(Scanner sc, Estoque estoque){
        int opcao;
        do{
            System.out.println("""
                1-adicionar ingrediente
                2-buscar ingrediente
                3-remover ingrediente
                4-atualizar quantidade
                5-mostrar estoque
                6-voltar
                """);

            opcao = lerInt(sc);

            switch (opcao){

                case 1 ->{
                    System.out.println("id: ");
                    int id = lerInt(sc);

                    System.out.println("nome: ");
                    String nome = sc.nextLine();

                    System.out.println("quantidade: ");
                    int qtd = lerInt(sc);

                    System.out.println("peso: ");
                    double peso = lerDouble(sc);

                    estoque.adicionarIngredientes(id,qtd,nome,peso);
                }

                case 2 ->{
                    System.out.println("id: ");
                    int id = lerInt(sc);

                    Ingredientes ing = estoque.buscarIngrediente(id);

                    if(ing != null)
                        System.out.println(ing.getNome());
                    else
                        System.out.println("Ingrediente nao encontrado");
                }

                case 3 ->{
                    System.out.println("id: ");
                    int id = lerInt(sc);

                    estoque.removerIngredientes(id);
                }

                case 4 -> {
                    System.out.println("id: ");
                    int id = lerInt(sc);

                    System.out.println("nova quantidade: ");
                    int qtd = lerInt(sc);

                    estoque.atualizarQuantidade(id,qtd);
                }

                case 5 -> estoque.mostrarEstoque();
            }
        }while(opcao != 6);
    }
    static void abrirCaixa(Scanner sc, Caixa caixa)
    {
        System.out.println("Digite o valor inicial do caixa");
        double valorInicial = lerDouble(sc);
        caixa.abrir(valorInicial);
    }

    static double calcularCaixa(Map<Integer,Pedido> pedido, double totalCaixa)
    {
        totalCaixa = pedido.values().stream().mapToDouble(Pedido::calcularTotal).sum();
        return totalCaixa;
    }
    static void verCaixaAtual(Map<Integer,Pedido> pedido, double totalCaixa)
    {
        System.out.println("Caixa atual no valor de R$" + calcularCaixa(pedido, totalCaixa));
    }
}

