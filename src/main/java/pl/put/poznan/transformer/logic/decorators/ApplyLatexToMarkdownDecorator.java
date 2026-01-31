package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplyLatexToMarkdownDecorator extends TextDecorator {
    public ApplyLatexToMarkdownDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String result = super.transform(text);
        if (result == null) return null;

        result = result.replaceAll("\\\\begin\\{itemize\\}\\s*", "");
        result = result.replaceAll("\\s*\\\\end\\{itemize\\}", "");
        result = result.replaceAll("\\\\item\\s+", "- ");

        return result;
    }
}