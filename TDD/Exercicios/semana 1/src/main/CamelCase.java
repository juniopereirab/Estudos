import org.jetbrains.annotations.NotNull;

import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

// Relatório Ciclo 1

/*
    private CamelCase c;
    @Test
    public void oneWord() {
        assertEquals("nome", c.converterCamelCase("nome"));
    }

    public String converterCamelCase(String word){
        return word;
    }
 */

// Relatório Ciclo 2

/*
    @Test
    public void upperWord(){
        assertEquals("nome", c.converterCamelCase("Nome"));
    }

    public String converterCamelCase(String word){
        if(Character.isUpperCase(word.charAt(0))){
            String new_word = word.replace(word.charAt(0), Character.toLowerCase(word.charAt(0)));
            return new_word;
        }

        return word;
    }
 */

// Relatório Ciclo 3

/*
    private CamelCase c;
    private List<String> expected;
    @Test
    public void twoWord(){
        expected = Arrays.asList("nome", "composto");
        assertEquals(expected, c.converterCamelCase("nomeComposto"));
    }

    public List<String> converterCamelCase(@NotNull String word) {
        List<String> result = new ArrayList<String>();
        String new_word = "";
        for(int i = 0; i < word.length(); i++){

            if(Character.isUpperCase(word.charAt(i))){
                if(new_word != "") {
                    result.add(new_word);
                    new_word = "";
                }
            }
            new_word = new_word + Character.toLowerCase(word.charAt(i));
        }
        result.add(new_word);
        return result;
    }
 */

// Relatório Ciclo 4

/*
    @Test
    public void allUpperWord(){
        expected = Arrays.asList("CPF");
        assertEquals(expected, c.converterCamelCase("CPF"));
    }

    public List<String> converterCamelCase(@NotNull String word) {
        List<String> words;
        words = breakWord(word);
        return words;
    }

    public static String lowerWord(String word) {
        if(word.matches("^[A-Z][a-z].*"))
            word = word.substring(0,1).toLowerCase()+word.substring(1);

        return word;
    }

    public static List<String> breakWord(String text) {
        String words [] = text.split("(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])");
        for(int i = 0; i < words.length; i++){
            words[i] = lowerWord(words[i]);
        }
        List<String> list = Arrays.asList(words);
        return list;
    }
 */

// Relatorio Ciclo 5

/*
    @Test(expected = StartNumberException.class)
    public void startWithNumber () {
        expected = Arrays.asList("10", "primeiros");
        assertEquals(expected, c.converterCamelCase("10Primeiros"));
    }

    public List<String> converterCamelCase(@NotNull String word) {
        if(word.matches("^[0-9].*"))
            throw new StartNumberException("Invalido, nao pode comecar com numeros");

        List<String> words;
        words = breakWord(word);
        return words;
    }
 */

// Relatorio Ciclo 6

/*
    @Test
    public void specialCharInnerString () {
        expected = Arrays.asList("nome#", "composto");
        assertEquals(expected, c.converterCamelCase("nome#Composto"));
    }

    public List<String> converterCamelCase(@NotNull String word) {
        if(word.matches("^[0-9].*"))
            throw new StartNumberException("Invalido, nao pode comecar com numeros");

        if(word.matches("(\\W)*"))
            throw new SpecialCharException("Invalido, nao pode ter caracteres especiais");

        List<String> words = new ArrayList<String>();
        words = breakWord(word);
        return words;
    }
 */


public class CamelCase {
    public List<String> converterCamelCase(@NotNull String word) {
        if(word.matches("^[0-9].*"))
            throw new StartNumberException("Invalido, nao pode comecar com numeros");

        if(word.matches("(\\W)*"))
            throw new SpecialCharException("Invalido, nao pode ter caracteres especiais");

        List<String> words = new ArrayList<String>();
        words = breakWord(word);
        return words;
    }

    public static String lowerWord(String word) {
        if(word.matches("^[A-Z][a-z].*"))
            word = word.substring(0,1).toLowerCase()+word.substring(1);

        return word;
    }

    public static List<String> breakWord(String text) {
        String words [] = text.split("(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])");
        for(int i = 0; i < words.length; i++){
            words[i] = lowerWord(words[i]);
        }
        List<String> list = Arrays.asList(words);
        return list;
    }
}