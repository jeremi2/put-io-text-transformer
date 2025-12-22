package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplyUpperDecorator extends TextDecorator {

    public ApplyUpperDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        return super.transform(text).toUpperCase();
    }
}
