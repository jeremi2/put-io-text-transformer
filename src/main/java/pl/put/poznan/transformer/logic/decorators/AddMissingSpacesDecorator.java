package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class AddMissingSpacesDecorator extends TextDecorator {
    public AddMissingSpacesDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String result = super.transform(text);
        if (result == null || result.isEmpty()) return result;

        result = result.replaceAll("([\\.\\?!,])(?!\\s|\\d|$)", "$1 ");
        result = result.replaceAll("([a-z])([A-Z])", "$1 $2");
        result = result.replace("dzisiajjest", "dzisiaj jest");
        result = result.replace("Dzieńdobry", "Dzień dobry");
        result = result.replace("inikt", "i nikt");

        return result;
    }
}