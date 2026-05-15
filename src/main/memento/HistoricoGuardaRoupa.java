package memento;

import java.util.Stack;

public class HistoricoGuardaRoupa {

    private Stack<GuardaRoupaMemento> historico;

    public HistoricoGuardaRoupa() {
        historico = new Stack<>();
    }

    public void salvarSnapshot(
            GuardaRoupaMemento memento
    ) {

        historico.push(memento);
    }

    public GuardaRoupaMemento desfazer() {

        if (historico.isEmpty()) {
            return null;
        }

        return historico.pop();
    }

    public int quantidadeSnapshots() {
        return historico.size();
    }
}