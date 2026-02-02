package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplyPascalCaseDecorator extends TextDecorator{
    public ApplyPascalCaseDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String processedText = super.transform(text);
        return applyPascalCase(processedText);
    }

    private String applyPascalCase(String text) {
        String[] words = splitToWords(text);
        StringBuilder sb = new StringBuilder();

        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)));
            sb.append(w.substring(1));
        }
        return sb.toString();
    }
}