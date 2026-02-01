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
        if (result == null || result.isEmpty()) return result;

        boolean isEnumerate = result.contains("enumerate");

        result = result.replace("\\begin{itemize}", "")
                .replace("\\end{itemize}", "")
                .replace("\\begin{enumerate}", "")
                .replace("\\end{enumerate}", "");

        String[] items = result.split("\\\\item");
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty()) {
                if (sb.length() > 0) sb.append("\n");
                if (isEnumerate) {
                    sb.append(count++).append(". ").append(trimmedItem);
                } else {
                    sb.append("- ").append(trimmedItem);
                }
            }
        }
        return sb.toString();
    }
}