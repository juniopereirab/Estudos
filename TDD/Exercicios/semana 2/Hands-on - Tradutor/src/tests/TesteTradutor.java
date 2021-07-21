import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteTradutor {
    private Tradutor t;

    @Before
    public void initialize() {
        t = new Tradutor();
    }

    @Test
    public void tradutorSemPalavras() {
        assertTrue(t.estaVazio());
    }

    @Test
    public void umaTraducao() {
        t.adicionaTraducao("bom", "good");
        assertFalse(t.estaVazio());
        assertEquals("good", t.traduzir("bom"));
    }

    @Test
    public void duasTraducoes(){
        t.adicionaTraducao("bom", "good");
        t.adicionaTraducao("mal", "bad");
        assertEquals("good", t.traduzir("bom"));
        assertEquals("bad", t.traduzir("mal"));
    }

    @Test
    public void duasTraducoesMesmaPalavra() {
        t.adicionaTraducao("bom", "good");
        t.adicionaTraducao("bom", "nice");
        assertEquals("good, nice", t.traduzir("bom"));
    }

    @Test
    public void traduzirFrase() {
        t.adicionaTraducao("guerra", "war");
        t.adicionaTraducao("é", "is");
        t.adicionaTraducao("ruim", "bad");
        assertEquals("war is bad", t.traduzirFrase("guerra é ruim"));
    }

    @Test
    public void traduzirFraseComDuasTraducoesMesmaPalavra () {
        t.adicionaTraducao("paz", "peace");
        t.adicionaTraducao("bom", "good");
        t.adicionaTraducao("bom", "nice");
        t.adicionaTraducao("é", "is");
        assertEquals("peace is good", t.traduzirFrase("paz é bom"));
    }
}
