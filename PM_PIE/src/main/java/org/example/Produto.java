package org.example;

import java.util.HashMap;
import java.util.Map;

public abstract class Produto {
    private int id ;
    private String nome;
    private double preco;
    private String categoria;
    private boolean disponibilidade;

    private Map<Integer, Integer> ingredientes = new HashMap<>();

    public Produto(int id, String nome, double preco, String categoria){

        if(preco < 0){
            throw new IllegalArgumentException("Preço inválido");
        }

        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.disponibilidade = true;
    }

    public void adicionaringrediente(int idIngrediente, int quantidade){
        ingredientes.put(idIngrediente, quantidade);
    }

    public Map<Integer, Integer> getIngredientes(){
        return ingredientes;
    }

    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade){
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString(){
        return "Produto{" +
                "id = " + id +
                ", nome = " + nome +
                ", preço = " + preco +
                ", categoria =" + categoria +
                ", disponivel =" + disponibilidade +
                '}';
    }

}
