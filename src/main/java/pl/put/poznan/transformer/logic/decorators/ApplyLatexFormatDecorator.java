package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplyLatexFormatDecorator extends TextDecorator  {

    public ApplyLatexFormatDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String processedText = super.transform(text);
        return applyLatexFormat(processedText);
    }

    private String applyLatexFormat(String text) {
        return text
                .replace("&", "\\&")
                .replace("$", "\\$");
    }

}
