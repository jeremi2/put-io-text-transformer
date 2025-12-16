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

}
