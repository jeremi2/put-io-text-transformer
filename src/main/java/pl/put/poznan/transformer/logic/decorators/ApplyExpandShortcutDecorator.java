package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplyExpandShortcutDecorator extends TextDecorator {

    public ApplyExpandShortcutDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String processedText = super.transform(text);
        return applyExpandShortcut(processedText);
    }

    private String applyExpandShortcut(String text) {
        text = text.replace("Prof.", "Profesor");
        text = text.replace("prof.", "profesor");
        text = text.replace("Dr", "Doktor");
        text = text.replace("dr", "doktor");
        text = text.replace("Mgr", "Magister");
        text = text.replace("mgr", "magister");
        text = text.replace("Inż.", "Inżynier");
        text = text.replace("inż.", "inżynier");
        text = text.replace("Np.", "Na przykład");
        text = text.replace("np.", "na przykład");
        text = text.replace("Itd.", "I tym podobne");
        text = text.replace("itd.", "i tym podobne");
        text = text.replace("Itp.", "I tym podobne");
        text = text.replace("itp.", "i tym podobne");
        text = text.replace("M.in.", "Między innymi");
        text = text.replace("m.in.", "między innymi");
        return text;
    }
}
