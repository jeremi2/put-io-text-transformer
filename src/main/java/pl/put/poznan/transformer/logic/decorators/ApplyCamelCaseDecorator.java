package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplyCamelCaseDecorator extends TextDecorator{
    public ApplyCamelCaseDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String processedText = super.transform(text);
        return applyCamelCase(processedText);
    }

    private String applyCamelCase(String text) {
        String[] words = splitToWords(text);
        StringBuilder sb = new StringBuilder();

        if (words.length > 0) {
            sb.append(words[0]);
            for (int i = 1; i < words.length; i++) {
                sb.append(Character.toUpperCase(words[i].charAt(0)));
                sb.append(words[i].substring(1));
            }
        }
        return sb.toString();
    }
}
