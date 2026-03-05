package org.example;

public class Ingredientes {
    private int id;
    private String nome;
    private int quantidade;
    private double peso;

    public Ingredientes(int id, String nome, int quantidade, double peso){
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.peso = peso;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public double getPeso(){
        return peso;
    }

    public void setQuantidade(int quantidade){
       this.quantidade = quantidade;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }


}