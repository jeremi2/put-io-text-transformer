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

        if (result.matches("(?s).*?\\d+\\.\\s+.*")) {
            result = result.replaceAll("\\d+\\.\\s+", "\\\\item ");
            return "\\begin{enumerate}\n" + result.trim() + "\n\\end{enumerate}";
        }
        else if (result.contains("- ")) {
            result = result.replace("- ", "\\item ");
            return "\\begin{itemize}\n" + result.trim() + "\n\\end{itemize}";
        }

        return result;
    }
}