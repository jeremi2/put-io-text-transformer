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
}