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
    public void testAddSpacesOne() {
        TextTransformer textTransformer = new TextTransformer(new String[]{"addspaces"});
        assertEquals("Dzień dobry.", textTransformer.transform("Dzieńdobry."));
    }

    @Test
    public void testAddSpacesTwo() {
        TextTransformer textTransformer = new TextTransformer(new String[]{"addspaces"});
        assertEquals("Brrr, zimno dzisiaj jest.", textTransformer.transform("Brrr,zimno dzisiajjest."));
    }

    @Test
    public void testAddSpacesThree() {
        TextTransformer textTransformer = new TextTransformer(new String[]{"addspaces"});
        String input = "Pi równa się 4.00,inikt mnie nie przekona, że tak nie jest.";
        String expected = "Pi równa się 4.00, i nikt mnie nie przekona, że tak nie jest.";
        assertEquals(expected, textTransformer.transform(input));
    }
}
