import memento.HistoricoGuardaRoupa;
import model.GuardaRoupa;
import model.Roupa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HistoricoGuardaRoupaTest {

    private GuardaRoupa guardaRoupa;

    private HistoricoGuardaRoupa historico;

    @BeforeEach
    public void configurar() {

        guardaRoupa = new GuardaRoupa();

        historico = new HistoricoGuardaRoupa();
    }

    @Test
    public void deveSalvarSnapshotComSucesso() {

        historico.salvarSnapshot(
                guardaRoupa.salvarEstado()
        );

        Assertions.assertEquals(
                1,
                historico.quantidadeSnapshots()
        );
    }

    @Test
    public void deveRestaurarEstadoAnterior() {

        guardaRoupa.adicionarRoupa(
                new Roupa(
                        "Camisa",
                        "Superior",
                        "Azul"
                )
        );

        historico.salvarSnapshot(
                guardaRoupa.salvarEstado()
        );

        guardaRoupa.adicionarRoupa(
                new Roupa(
                        "Tênis",
                        "Calçado",
                        "Preto"
                )
        );

        guardaRoupa.restaurarEstado(
                historico.desfazer()
        );

        Assertions.assertEquals(
                1,
                guardaRoupa.getRoupas().size()
        );
    }

    @Test
    public void deveRetornarNullQuandoHistoricoEstiverVazio() {

        Assertions.assertNull(
                historico.desfazer()
        );
    }

    @Test
    public void deveContarSnapshotsCorretamente() {

        historico.salvarSnapshot(
                guardaRoupa.salvarEstado()
        );

        historico.salvarSnapshot(
                guardaRoupa.salvarEstado()
        );

        historico.salvarSnapshot(
                guardaRoupa.salvarEstado()
        );

        Assertions.assertEquals(
                3,
                historico.quantidadeSnapshots()
        );
    }

    @Test
    public void deveRemoverSnapshotAoDesfazer() {

        historico.salvarSnapshot(
                guardaRoupa.salvarEstado()
        );

        historico.desfazer();

        Assertions.assertEquals(
                0,
                historico.quantidadeSnapshots()
        );
    }
}