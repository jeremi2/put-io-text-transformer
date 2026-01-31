package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplyMarkdownToLatexDecorator extends TextDecorator {
    public ApplyMarkdownToLatexDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String result = super.transform(text);
        if (result == null || result.isEmpty()) return result;

        if (result.contains("- ")) {
            result = result.replace("- ", "\\item ");
            result = "\\begin{itemize}\n" + result + "\n\\end{itemize}";
        }

        return result;
    }
}