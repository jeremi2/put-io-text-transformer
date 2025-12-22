package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextDecorator;

public class ApplyNumbersToTextDecorator extends TextDecorator {

    public ApplyNumbersToTextDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String processedText = super.transform(text);
        return applyNumbersToText(processedText);
    }

    private String applyNumbersToText(String text) {
        String[] units={"", "jeden", "dwa", "trzy", "cztery", "piec", "szesc", "siedem", "osiem", "dziewiec"};
        String[] teens={"", "dziesiec", "jedenascie", "dwanascie", "trzynascie", "czternascie", "pietnascie", "szesnascie", "siedemnascie", "osiemnascie", "dziewietnascie"};
        String[] tens={"", "dziesiec", "dwadziescia", "trzydziesci", "czterdziesci", "piecdziesiat", "szescdziesiat", "siedemdziesiat", "osiemdziesiat", "dziewiecdziesiat"};
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
        return result.toString().replaceAll("\\s+", " ").trim();
    }
}
