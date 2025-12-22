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
}
