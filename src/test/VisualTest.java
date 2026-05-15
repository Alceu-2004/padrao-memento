import model.Roupa;
import model.Visual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisualTest {

    private Visual visual;

    @BeforeEach
    public void configurar() {

        visual = new Visual("Look Casual");
    }

    @Test
    public void deveCriarVisualComSucesso() {

        Assertions.assertEquals(
                "Look Casual",
                visual.getNome()
        );
    }

    @Test
    public void deveAdicionarRoupaAoVisual() {

        Roupa roupa =
                new Roupa(
                        "Camiseta",
                        "Superior",
                        "Branca"
                );

        visual.adicionarRoupa(roupa);

        Assertions.assertEquals(
                1,
                visual.getRoupas().size()
        );
    }

    @Test
    public void deveIniciarVisualSemRoupas() {

        Assertions.assertTrue(
                visual.getRoupas().isEmpty()
        );
    }

    @Test
    public void deveAdicionarMultiplasRoupas() {

        visual.adicionarRoupa(
                new Roupa(
                        "Jaqueta",
                        "Casaco",
                        "Preta"
                )
        );

        visual.adicionarRoupa(
                new Roupa(
                        "Calça",
                        "Inferior",
                        "Azul"
                )
        );

        visual.adicionarRoupa(
                new Roupa(
                        "Tênis",
                        "Calçado",
                        "Branco"
                )
        );

        Assertions.assertEquals(
                3,
                visual.getRoupas().size()
        );
    }

    @Test
    public void deveGerarTextoDoVisualCorretamente() {

        visual.adicionarRoupa(
                new Roupa(
                        "Camisa",
                        "Superior",
                        "Verde"
                )
        );

        String texto = visual.toString();

        Assertions.assertTrue(
                texto.contains("Look Casual")
        );

        Assertions.assertTrue(
                texto.contains("Camisa")
        );
    }
}