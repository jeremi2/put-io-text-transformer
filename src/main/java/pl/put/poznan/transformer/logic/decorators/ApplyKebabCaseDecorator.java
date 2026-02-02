package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplyKebabCaseDecorator extends TextDecorator{
    public ApplyKebabCaseDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String processedText = super.transform(text);
        return applyKebabCase(processedText);
    }

    private String applyKebabCase(String text) {
        String[] words = splitToWords(text);
        return String.join("-", words);
    }
}