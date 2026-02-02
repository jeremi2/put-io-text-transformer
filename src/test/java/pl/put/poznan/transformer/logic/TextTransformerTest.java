package pl.put.poznan.transformer.logic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TextTransformerTest {
    @Test
    public void testUpperTransform(){
        TextTransformer textTransformer = new TextTransformer(new String[]{"upper"});
        assertEquals("TEST", textTransformer.transform("test"));
    }
    @Test
    public void testInverseTransform(){
        TextTransformer textTransformer = new TextTransformer(new String[]{"inverse"});
        assertEquals("GnItset", textTransformer.transform("TeSting"));
    }
    @Test
    public void testRepetitionTransform(){
        TextTransformer textTransformer = new TextTransformer(new String[]{"repetition"});
        assertEquals("Some repetitions here and there", textTransformer.transform("Some repetitions repetitions here and and and there there"));
    }
    @Test
    public void testLowerTransform(){
        TextTransformer textTransformer = new TextTransformer(new String[]{"lower"});
        assertEquals("test", textTransformer.transform("TEST"));
    }
    @Test
    public void testCapitalizeTransform(){
        TextTransformer textTransformer = new TextTransformer(new String[]{"capitalize"});
        assertEquals("Some OF ThiS TeXt NEeDs Capitalization", textTransformer.transform("some OF thiS TeXt nEeDs capitalization"));
    }
    @Test
    public void testLatexTransform(){
        TextTransformer textTransformer = new TextTransformer(new String[]{"latex"});
        assertEquals("test \\&\\$ \\$test\\&\\&test \\$", textTransformer.transform("test &$ $test&&test $"));
    }
    @Test
    public void testNumberToTextTransform() {
        TextTransformer textTransformer = new TextTransformer(new String[]{"numbertotext"});
        assertEquals("sto dwa", textTransformer.transform("102"));
        assertEquals("piecdziesiat", textTransformer.transform("50"));
        assertEquals("zero", textTransformer.transform("0"));
    }

    @Test
    public void testIntoShortcutTransform() {
        TextTransformer textTransformer = new TextTransformer(new String[]{"intoshortcut"});
        assertEquals("np. itd.", textTransformer.transform("na przykład i tak dalej"));
        assertEquals("dr prof.", textTransformer.transform("doktor profesor"));
    }

    @Test
    public void testExpandShortcutTransform() {
        TextTransformer textTransformer = new TextTransformer(new String[]{"expandshortcut"});
        assertEquals("Na przykład i tym podobne", textTransformer.transform("Np. itd."));
        assertEquals("profesor doktor", textTransformer.transform("prof. dr"));
    }

    @Test
    public void testLatexToMarkdownItemize() {
        TextTransformer textTransformer = new TextTransformer(new String[]{"latextomarkdown"});
        String input = "\\begin{itemize} \\item A \\item B \\end{itemize}";
        assertEquals("- A\n- B", textTransformer.transform(input).trim());
    }

    @Test
    public void testLatexToMarkdownEnumerate() {
        TextTransformer textTransformer = new TextTransformer(new String[]{"latextomarkdown"});
        String input = "\\begin{enumerate} \\item A \\item B \\end{enumerate}";
        assertEquals("1. A\n2. B", textTransformer.transform(input).trim());
    }

    @Test
    public void testMarkdownToLatexItemize() {
        TextTransformer textTransformer = new TextTransformer(new String[]{"markdowntolatex"});
        String input = "- A\n- B";
        String result = textTransformer.transform(input);
        assertTrue(result.contains("\\begin{itemize}") && result.contains("\\item A") && result.contains("\\end{itemize}"));
    }

    @Test
    public void testMarkdownToLatexEnumerate() {
        TextTransformer textTransformer = new TextTransformer(new String[]{"markdowntolatex"});
        String input = "1. A\n2. B";
        String result = textTransformer.transform(input);
        assertTrue(result.contains("\\begin{enumerate}") && result.contains("\\item A") && result.contains("\\end{enumerate}"));
    }

    @Test
    public void testHash() {
        TextTransformer textTransformer = new TextTransformer(new String[]{"hash"});
        assertEquals("b49258de227b5ef95d0560fff51dbd1b1b1f777b98e61f1f42d81b7acb3f1379", textTransformer.transform("Dla Temerii zrobię wszystko."));
    }

    @Test
    void testSnakeCaseTransform() {
        TextTransformer transformer = new TextTransformer(new String[]{"snakecase"});
        assertEquals("snake_case_var", transformer.transform("snakeCaseVar"));
        assertEquals("snake_case_var", transformer.transform("SnakeCaseVar"));
        assertEquals("snake_case_var", transformer.transform("snake-case-var"));
    }

    @Test
    void testCamelCaseTransform() {
        TextTransformer transformer = new TextTransformer(new String[]{"camelcase"});
        assertEquals("camelCaseVar", transformer.transform("camel_case_var"));
        assertEquals("camelCaseVar", transformer.transform("camel-case-var"));
        assertEquals("camelCaseVar", transformer.transform("CamelCaseVar"));
    }

    @Test
    void testKebabCaseTransform() {
        TextTransformer transformer = new TextTransformer(new String[]{"kebabcase"});
        assertEquals("kebab-case-var", transformer.transform("kebabCaseVar"));
        assertEquals("kebab-case-var", transformer.transform("KebabCaseVar"));
        assertEquals("kebab-case-var", transformer.transform("kebab_case_var"));
    }

    @Test
    void testPascalCaseTransform() {
        TextTransformer transformer = new TextTransformer(new String[]{"pascalcase"});
        assertEquals("PascalCaseVar", transformer.transform("pascal_case_var"));
        assertEquals("PascalCaseVar", transformer.transform("pascal-case-var"));
        assertEquals("PascalCaseVar", transformer.transform("pascalCaseVar"));
    }
}
