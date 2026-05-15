package model;

public class Roupa {

    private String nome;
    private String categoria;
    private String cor;

    public Roupa(String nome, String categoria, String cor) {
        this.nome = nome;
        this.categoria = categoria;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {

        return "Roupa: " + nome +
                " | Categoria: " + categoria +
                " | Cor: " + cor;
    }
}