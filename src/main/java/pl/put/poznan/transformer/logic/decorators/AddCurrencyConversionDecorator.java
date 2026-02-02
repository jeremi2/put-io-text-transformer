package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCurrencyConversionDecorator extends TextDecorator {
    private final double exchangeRate = 4.0;

    public AddCurrencyConversionDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String result = super.transform(text);
        if (result == null || result.isEmpty()) return result;

        String regex = "(\\$)?(\\s*)(\\d+(?:\\.\\d+)?)(\\s*)(\\$|USD)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            String preSymbol = matcher.group(1);
            String spaceBefore = matcher.group(2);
            String valueStr = matcher.group(3);
            String spaceAfter = matcher.group(4);
            String postSymbol = matcher.group(5);

            if (preSymbol != null || postSymbol != null) {
                double value = Double.parseDouble(valueStr);
                int converted = (int) (value * exchangeRate);

                String currencyLabel = "USD".equals(postSymbol) ? "PLN" : "zł";

                if (preSymbol != null) {
                    matcher.appendReplacement(sb, converted + spaceBefore + "zł");
                } else {
                    matcher.appendReplacement(sb, converted + spaceAfter + currencyLabel);
                }
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}