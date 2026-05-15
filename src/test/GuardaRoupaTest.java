import model.GuardaRoupa;
import model.Roupa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GuardaRoupaTest {

    private GuardaRoupa guardaRoupa;

    @BeforeEach
    public void configurar() {

        guardaRoupa = new GuardaRoupa();
    }

    @Test
    public void deveAdicionarRoupaComSucesso() {

        Roupa roupa =
                new Roupa(
                        "Camiseta",
                        "Superior",
                        "Preta"
                );

        guardaRoupa.adicionarRoupa(roupa);

        Assertions.assertEquals(
                1,
                guardaRoupa.getRoupas().size()
        );
    }

    @Test
    public void deveRemoverRoupaComSucesso() {

        Roupa roupa =
                new Roupa(
                        "Jaqueta",
                        "Casaco",
                        "Azul"
                );

        guardaRoupa.adicionarRoupa(roupa);

        guardaRoupa.removerRoupa("Jaqueta");

        Assertions.assertTrue(
                guardaRoupa.getRoupas().isEmpty()
        );
    }

    @Test
    public void deveManterRoupaQuandoNomeNaoExistir() {

        Roupa roupa =
                new Roupa(
                        "Tênis",
                        "Calçado",
                        "Branco"
                );

        guardaRoupa.adicionarRoupa(roupa);

        guardaRoupa.removerRoupa("Boné");

        Assertions.assertEquals(
                1,
                guardaRoupa.getRoupas().size()
        );
    }

    @Test
    public void deveIniciarComListaVazia() {

        Assertions.assertTrue(
                guardaRoupa.getRoupas().isEmpty()
        );
    }

    @Test
    public void deveSalvarEstadoCorretamente() {

        guardaRoupa.adicionarRoupa(
                new Roupa(
                        "Camisa",
                        "Superior",
                        "Branca"
                )
        );

        Assertions.assertNotNull(
                guardaRoupa.salvarEstado()
        );
    }
}