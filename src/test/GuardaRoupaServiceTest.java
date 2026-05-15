import model.GuardaRoupa;
import model.Visual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.GuardaRoupaService;

public class GuardaRoupaServiceTest {

    private GuardaRoupa guardaRoupa;

    private GuardaRoupaService servico;

    @BeforeEach
    public void configurar() {

        guardaRoupa = new GuardaRoupa();

        servico = new GuardaRoupaService(
                guardaRoupa
        );
    }

    @Test
    public void deveCadastrarRoupaComSucesso() {

        servico.cadastrarRoupa(
                "Camiseta",
                "Superior",
                "Preta"
        );

        Assertions.assertEquals(
                1,
                guardaRoupa.getRoupas().size()
        );
    }

    @Test
    public void deveCriarVisualComSucesso() {

        Visual visual =
                servico.criarVisual(
                        "Look Trabalho"
                );

        Assertions.assertEquals(
                "Look Trabalho",
                visual.getNome()
        );
    }

    @Test
    public void deveAdicionarVisualAoGuardaRoupa() {

        Visual visual =
                servico.criarVisual(
                        "Look Festa"
                );

        servico.adicionarVisual(visual);

        Assertions.assertEquals(
                1,
                guardaRoupa.getVisuais().size()
        );
    }

    @Test
    public void deveCadastrarVariasRoupas() {

        servico.cadastrarRoupa(
                "Camisa",
                "Superior",
                "Branca"
        );

        servico.cadastrarRoupa(
                "Calça",
                "Inferior",
                "Preta"
        );

        servico.cadastrarRoupa(
                "Tênis",
                "Calçado",
                "Branco"
        );

        Assertions.assertEquals(
                3,
                guardaRoupa.getRoupas().size()
        );
    }
}