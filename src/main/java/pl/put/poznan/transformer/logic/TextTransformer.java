package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.logic.decorators.*;

public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms) {
        this.transforms = transforms;
    }

    public String transform(String text) {
        Transformer transformer = new TextImpl();

        for (String transformation : transforms) {
            switch (transformation) {
                case "upper":
                    transformer = new ApplyUpperDecorator(transformer);
                    break;

                case "inverse":
                    transformer = new ApplyInversionDecorator(transformer);
                    break;

                case "repetition":
                    transformer = new RemoveRepetitionsDecorator(transformer);
                    break;

                case "lower":
                    transformer = new ApplyLowerDecorator(transformer);
                    break;

                case "capitalize":
                    transformer = new ApplyCapitalizeDecorator(transformer);
                    break;

                case "intoshortcut":
                    transformer = new ApplyIntoShortcutDecorator(transformer);
                    break;

                case "expandshortcut":
                    transformer = new ApplyExpandShortcutDecorator(transformer);
                    break;

                case "latex":
                    transformer = new ApplyLatexFormatDecorator(transformer);
                    break;

                case "numbertotext":
                    transformer = new ApplyNumbersToTextDecorator(transformer);
                    break;

                case "addspaces":
                    transformer = new AddMissingSpacesDecorator(transformer);
                    break;

                default:
                    break;
            }
        }

        return transformer.transform(text);
    }
}

