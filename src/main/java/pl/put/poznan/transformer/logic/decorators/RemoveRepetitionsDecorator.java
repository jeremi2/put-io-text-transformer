package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class RemoveRepetitionsDecorator extends TextDecorator {

    public RemoveRepetitionsDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String processedText = super.transform(text);
        return removeRepetitions(processedText);
    }

    private String removeRepetitions(String text) {
        String[] words=text.split(" ");
        if (words.length==0) return text;

        StringBuilder sb=new StringBuilder();
        sb.append(words[0]);

        for (int i=1; i<words.length; i++) {

            if (!words[i].equalsIgnoreCase(words[i-1])) {
                sb.append(" ").append(words[i]);
            }
        }
        return sb.toString();
    }
}