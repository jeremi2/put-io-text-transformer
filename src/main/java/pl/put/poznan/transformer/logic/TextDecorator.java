package pl.put.poznan.transformer.logic;

public abstract class TextDecorator implements Transformer{
    protected Transformer transformer;

    public TextDecorator(Transformer transformer) {
        this.transformer = transformer;
    }

    @Override
    public String transform(String text) {
        return transformer.transform(text);
    }

    protected String[] splitToWords(String text) {
        text = text.replace("-", " ").replace("_", " ");
        text = text.replaceAll("([a-z])([A-Z])", "$1 $2");
        return text.toLowerCase().split("\\s+");
    }
}
