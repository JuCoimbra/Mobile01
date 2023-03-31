package br.com.senaicimatec.agualife;

public class Atleta {
    private int idade;
    private double peso;
    private String nome;

    public Atleta(int idade, double peso, String nome){
        this.idade = idade;
        this.peso = peso;
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }

    public double getPeso(){
        return peso;
    }

    public String getNome(){
        return nome;
    }
}