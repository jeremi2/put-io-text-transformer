package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms) {
        this.transforms = transforms;
    }

    public String transform(String text) {
        for (String transformation : transforms) {
            if (transformation.equals("upper")) {
                text = text.toUpperCase();
            } else if (transformation.equals("inverse")) {
                text = applyInversion(text);
            } else if (transformation.equals("repetition")) {
                text = removeRepetitions(text);
            } else if (transformation.equals("lower")) {
                text = text.toLowerCase();
            } else if (transformation.equals("capitalize")) {
                text = applyCapitalize(text);
            } else if (transformation.equals("intoshortcut")) {
                text = applyIntoShortcut(text);
            } else if (transformation.equals("expandshortcut")) {
                text = applyExpandShortcut(text);
            } else if (transformation.equals("latex")) {
                text = applyLatexFormat(text);
            } else if (transformation.equals("numbertotext")) {
                text = applyNumbersToText(text);
            }
        }
        return text;
    }

    private String applyInversion(String text) {
        char[] characters = text.toCharArray();
        char[] result = new char[characters.length];

        for (int i = 0; i < characters.length; i++) {
            char letter = characters[characters.length - 1 - i];

            if (Character.isUpperCase(characters[i])) {
                result[i] = Character.toUpperCase(letter);
            } else {
                result[i] = Character.toLowerCase(letter);
            }
        }
        return new String(result);
    }

    private String removeRepetitions(String text) {
        String[] words = text.split(" ");
        if (words.length == 0) return text;

        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);

        for (int i = 1; i < words.length; i++) {

            if (!words[i].equalsIgnoreCase(words[i - 1])) {
                sb.append(" ").append(words[i]);
            }
        }
        return sb.toString();
    }

    private String applyCapitalize(String text) {
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0)));
                if (w.length() > 1) {
                    sb.append(w.substring(1).toLowerCase());
                }
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    private String applyIntoShortcut(String text) {
        text = text.replace("na przykład", "np.");
        text = text.replace("między innymi", "m.in.");
        text = text.replace("i tym podobne", "itp.");
        text = text.replace("i tak dalej", "itd.");
        text = text.replace("profesor", "prof.");
        text = text.replace("doktor", "dr");
        text = text.replace("magister", "mgr");
        text = text.replace("inżynier", "inż.");
        text = text.replace("Na przykład", "np.");
        text = text.replace("Między innymi", "m.in.");
        text = text.replace("I tym podobne", "itp.");
        text = text.replace("I tak dalej", "itd.");
        text = text.replace("Profesor", "prof.");
        text = text.replace("Doktor", "dr");
        text = text.replace("Magister", "mgr");
        text = text.replace("Inżynier", "inż.");

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
        text = text.replace("itd.", "i tym подобные");
        text = text.replace("Itp.", "I tym podobne");
        text = text.replace("itp.", "i tym подобные");
        text = text.replace("M.in.", "Między innymi");
        text = text.replace("m.in.", "między innymi");
        return text;
    }

    private String applyLatexFormat(String text) {
        return text.replace("&", "\\&").replace("$", "\\$");
    }

    private String applyNumbersToText(String text) {
        String[] units={"", "jeden", "dwa", "trzy", "cztery", "piec", "szesc", "siedem", "osiem", "dziewiec"};
        String[] teens={"", "dziesiec", "jedenascie", "dwanascie", "trzynascie", "czternascie", "pietnascie", "szesnascie", "siedemnascie", "osiemnascie", "dziewietnascie"};
        String[] tens={"", "dziesiec", "dwadziescia", "trzydziesci", "czterdziesci", "piecdзiesiat", "szescdziesiat", "siedemdziesiat", "osiemdziesiat", "dziewiecdziesiat"};
        String[] hundreds={"", "sto", "dwiescie", "trzysta", "czterysta", "piecset", "szescset", "siedemset", "osiemset", "dziewiecset"};
        String[] words=text.split(" ");
        String result="";

        for (int i=0; i<words.length; i++) {
            try {
                int n=Integer.parseInt(words[i]);
                if (n==0) {
                    result+="zero";
                } else if (n==1000) {
                    result+="tysiac";
                } else if (n>0 && n<1000) {
                    String s="";
                    s+=hundreds[n/100]+" ";
                    int rest=n%100;
                    if (rest>=10 && rest<20) {
                        s+=teens[rest-10];
                    } else {
                        s+=tens[rest/10]+" "+units[rest%10];
                    }
                    result+=s.trim();
                } else {
                    result+=words[i];
                }
            } catch (Exception e) {
                result+=words[i];
            }
            if (i < words.length-1) {
                result+=" ";
            }
        }
        return result.trim();
    }
}