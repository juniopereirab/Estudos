import java.util.HashMap;
import java.util.Map;

public class Tradutor {

    private Map<String, String> translations = new HashMap<>();
    public boolean estaVazio() {
        return translations.isEmpty();
    }

    public void adicionaTraducao(String word, String translation) {
        if(translations.containsKey(word)){
            translation = traduzir(word) + ", " + translation;
        }
        translations.put(word, translation);
    }

    public String traduzir(String word) {
        return translations.get(word);
    }

    public String traduzirFrase(String sentence) {
        String [] words = sentence.split(" ");
        String translatedSentence = "";
        for(String word : words) {
            String translation = firstTranslation(word);
            translatedSentence += " " + translation;
        }
        return translatedSentence.trim();
    }

    private String firstTranslation(String word) {
        String translation = traduzir(word);
        if(translation.contains(",")) {
            translation = translation.substring(0, translation.indexOf(","));
        }
        return translation;
    }
}
