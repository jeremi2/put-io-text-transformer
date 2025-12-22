package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplyIntoShortcutDecorator extends TextDecorator {

    public ApplyIntoShortcutDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String processedText = super.transform(text);
        return applyIntoShortcut(processedText);
    }

    private String applyIntoShortcut(String text) {
        text=text.replace("na przykład", "np.");
        text=text.replace("między innymi", "m.in.");
        text=text.replace("i tym podobne", "itp.");
        text=text.replace("i tak dalej", "itd.");
        text=text.replace("profesor", "prof.");
        text=text.replace("doktor", "dr");
        text=text.replace("magister", "mgr");
        text=text.replace("inżynier", "inż.");
        text=text.replace("Na przykład", "np.");
        text=text.replace("Między innymi", "m.in.");
        text=text.replace("I tym podobne", "itp.");
        text=text.replace("I tak dalej", "itd.");
        text=text.replace("Profesor", "prof.");
        text=text.replace("Doktor", "dr");
        text=text.replace("Magister", "mgr");
        text=text.replace("Inżynier", "inż.");

        return text;
    }
}
