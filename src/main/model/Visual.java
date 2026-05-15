package model;

import java.util.ArrayList;
import java.util.List;

public class Visual {

    private String nome;
    private List<Roupa> roupas;

    public Visual(String nome) {
        this.nome = nome;
        this.roupas = new ArrayList<>();
    }

    public void adicionarRoupa(Roupa roupa) {
        roupas.add(roupa);
    }

    public String getNome() {
        return nome;
    }

    public List<Roupa> getRoupas() {
        return roupas;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("\nVisual: ")
                .append(nome)
                .append("\n");

        for (Roupa roupa : roupas) {
            builder.append("- ")
                    .append(roupa)
                    .append("\n");
        }

        return builder.toString();
    }
}