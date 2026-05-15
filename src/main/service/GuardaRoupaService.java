package service;

import model.GuardaRoupa;
import model.Roupa;
import model.Visual;

public class GuardaRoupaService {

    private GuardaRoupa guardaRoupa;

    public GuardaRoupaService(
            GuardaRoupa guardaRoupa
    ) {

        this.guardaRoupa = guardaRoupa;
    }

    public void cadastrarRoupa(
            String nome,
            String categoria,
            String cor
    ) {

        Roupa roupa =
                new Roupa(nome, categoria, cor);

        guardaRoupa.adicionarRoupa(roupa);
    }

    public Visual criarVisual(String nome) {
        return new Visual(nome);
    }

    public void adicionarVisual(
            Visual visual
    ) {

        guardaRoupa.adicionarVisual(visual);
    }
}