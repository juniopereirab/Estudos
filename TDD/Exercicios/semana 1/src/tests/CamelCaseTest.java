import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CamelCaseTest {

    private CamelCase c;
    private List<String> expected;
    @Before
    public void initialize(){
        c = new CamelCase();
    }

    @Test
    public void oneWord() {
        expected = Arrays.asList("nome");
        assertEquals(expected, c.converterCamelCase("nome"));
    }

    @Test
    public void upperWord(){
        expected = Arrays.asList("nome");
        assertEquals(expected, c.converterCamelCase("Nome"));
    }

    @Test
    public void twoWord(){
        expected = Arrays.asList("nome", "composto");
        assertEquals(expected, c.converterCamelCase("nomeComposto"));
    }

    @Test
    public void twoUpperWords(){
        expected = Arrays.asList("nome", "composto");
        assertEquals(expected, c.converterCamelCase("NomeComposto"));
    }

    @Test
    public void allUpperWord(){
        expected = Arrays.asList("CPF");
        assertEquals(expected, c.converterCamelCase("CPF"));
    }

    @Test
    public void twoWordsWithUpperWord(){
        expected = Arrays.asList("numero", "CPF");
        assertEquals(expected, c.converterCamelCase("numeroCPF"));
    }

    @Test
    public void threeWordsWithUpperWord() {
        expected = Arrays.asList("numero", "CPF", "contribuinte");
        assertEquals(expected, c.converterCamelCase("numeroCPFContribuinte"));
    }

    @Test
    public void wordsWithNumber() {
        expected = Arrays.asList("recupera", "10", "primeiros");
        assertEquals(expected, c.converterCamelCase("recupera10Primeiros"));
    }

    @Test(expected = StartNumberException.class)
    public void startWithNumber () {
        expected = Arrays.asList("10", "primeiros");
        assertEquals(expected, c.converterCamelCase("10Primeiros"));
    }

    @Test(expected = SpecialCharException.class)
    public void specialCharInnerString () {
        expected = Arrays.asList("nome#", "composto");
        assertEquals(expected, c.converterCamelCase("nome#Composto"));
    }
}