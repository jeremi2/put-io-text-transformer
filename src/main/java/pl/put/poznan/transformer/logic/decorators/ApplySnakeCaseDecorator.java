package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplySnakeCaseDecorator extends TextDecorator {
    public ApplySnakeCaseDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String processedText = super.transform(text);
        return applySnakeCase(processedText);
    }

    private String applySnakeCase(String text) {
        String[] words = splitToWords(text);
        return String.join("_", words);
    }
}