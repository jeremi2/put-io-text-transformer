package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplyCapitalizeDecorator extends TextDecorator {

    public ApplyCapitalizeDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String processedText = super.transform(text);
        return applyCapitalize(processedText);
    }

    private String applyCapitalize(String text) {
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0)));
                if (w.length() > 1) {
                    sb.append(w.substring(1));
                }
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
