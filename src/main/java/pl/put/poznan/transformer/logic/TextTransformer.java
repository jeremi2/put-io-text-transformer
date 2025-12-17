package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
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
                    sb.append(w.substring(1).toLowerCase());
                }
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

}
