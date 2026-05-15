package memento;

import model.Roupa;
import model.Visual;

import java.util.List;

public class GuardaRoupaMemento {

    private final List<Roupa> roupasSalvas;
    private final List<Visual> visuaisSalvos;

    public GuardaRoupaMemento(
            List<Roupa> roupasSalvas,
            List<Visual> visuaisSalvos
    ) {

        this.roupasSalvas = roupasSalvas;
        this.visuaisSalvos = visuaisSalvos;
    }

    public List<Roupa> getRoupasSalvas() {
        return roupasSalvas;
    }

    public List<Visual> getVisuaisSalvos() {
        return visuaisSalvos;
    }
}