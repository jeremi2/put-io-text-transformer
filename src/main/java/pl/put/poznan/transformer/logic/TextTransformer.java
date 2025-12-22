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

                default:
                    break;
            }
        }

        return transformer.transform(text);
    }
}
/*

public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms=transforms;
    }

    public String transform(String text){
        for (String transformation : transforms) {
            if (transformation.equals("upper")) {
                text=text.toUpperCase();
            } else if (transformation.equals("inverse")) {
                text=applyInversion(text);
            } else if (transformation.equals("repetition")) {
                text=removeRepetitions(text);
            } else if (transformation.equals("lower")) {
                text=text.toLowerCase();
            } else if (transformation.equals("capitalize")) {
                text=applyCapitalize(text);
            } else if (transformation.equals("intoshortcut")) {
                text=applyIntoShortcut(text);
            } else if (transformation.equals("expandshortcut")) {
                text=applyExpandShortcut(text);
            } else if (transformation.equals("latex")){
                text=applyLatexFormat(text);
            }
        }
        return text;
    }

    private String applyInversion(String text) {
        char[] characters=text.toCharArray();
        char[] result=new char[characters.length];

        for (int i=0; i<characters.length; i++) {
            char letter=characters[characters.length-1-i];

            if (Character.isUpperCase(characters[i])) {
                result[i]=Character.toUpperCase(letter);
            } else {
                result[i]=Character.toLowerCase(letter);
            }
        }
        return new String(result);
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


    private String applyCapitalize(String text) {
        String[] words=text.split(" ");
        StringBuilder sb=new StringBuilder();
        for (String w : words) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0)));
                if (w.length()>1) {
                    sb.append(w.substring(1));
                }
                sb.append(" ");
            }
        }
        return sb.toString().trim();
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
    private String applyLatexFormat(String text) {
        return text.replace("&", "\\&").replace("$", "\\$");
    }

}
*/
