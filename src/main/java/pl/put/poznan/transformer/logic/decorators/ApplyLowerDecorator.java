package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplyLowerDecorator extends TextDecorator {

    public ApplyLowerDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        return super.transform(text).toLowerCase();
    }
}
