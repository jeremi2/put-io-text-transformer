package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplyInversionDecorator extends TextDecorator {

    public ApplyInversionDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String processedText = super.transform(text);
        return applyInversion(processedText);
    }

    private String applyInversion(String text) {
        char[] characters = text.toCharArray();
        char[] result = new char[characters.length];
        for (int i = 0; i < characters.length; i++) {
            char letter = characters[characters.length - 1 - i];
            if (Character.isUpperCase(characters[i])) {
                result[i] = Character.toUpperCase(letter);
            } else {
                result[i] = Character.toLowerCase(letter);
            }
        }
        return new String(result);
    }
}