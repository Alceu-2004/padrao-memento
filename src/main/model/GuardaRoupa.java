package model;

import memento.GuardaRoupaMemento;

import java.util.ArrayList;
import java.util.List;

public class GuardaRoupa {

    private List<Roupa> roupas;
    private List<Visual> visuais;

    public GuardaRoupa() {
        roupas = new ArrayList<>();
        visuais = new ArrayList<>();
    }

    public void adicionarRoupa(Roupa roupa) {
        roupas.add(roupa);
    }

    public void removerRoupa(String nome) {

        roupas.removeIf(
                roupa -> roupa.getNome()
                        .equalsIgnoreCase(nome)
        );
    }

    public void adicionarVisual(Visual visual) {
        visuais.add(visual);
    }

    public List<Roupa> getRoupas() {
        return roupas;
    }

    public List<Visual> getVisuais() {
        return visuais;
    }

    public GuardaRoupaMemento salvarEstado() {

        return new GuardaRoupaMemento(
                new ArrayList<>(roupas),
                new ArrayList<>(visuais)
        );
    }

    public void restaurarEstado(
            GuardaRoupaMemento memento
    ) {

        roupas = memento.getRoupasSalvas();
        visuais = memento.getVisuaisSalvos();
    }

    public void exibirGuardaRoupa() {

        System.out.println("\n===== ROUPAS =====");

        if (roupas.isEmpty()) {
            System.out.println(
                    "Nenhuma roupa cadastrada."
            );
        }

        for (Roupa roupa : roupas) {
            System.out.println(roupa);
        }

        System.out.println("\n===== VISUAIS =====");

        if (visuais.isEmpty()) {
            System.out.println(
                    "Nenhum visual criado."
            );
        }

        for (Visual visual : visuais) {
            System.out.println(visual);
        }
    }
}