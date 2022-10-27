package Pessoa;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa() {
        this(" ", 0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setidade(int idade) {
        this.idade = idade;
    }

    public boolean DeMaior() {
        boolean deMaior = false;
        if (idade >= 18) {
            deMaior = true;
        }
        return deMaior;
    }

    @Override
    public String toString() {
        String mensagem = String.format("%s é a idade dela é %d", nome, idade);
        return mensagem;
    }
}