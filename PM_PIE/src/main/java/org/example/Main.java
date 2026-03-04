package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Object>> listaMista = List.of(List.of(0, "teste", 29.50));
        Produtos teste = new Produtos(listaMista);

        System.out.println(teste.getListaMistaMock());

      chama Cliente e Carrinho auto completa com pedidos sem interacao com usuario
            //tava testando
    }
}