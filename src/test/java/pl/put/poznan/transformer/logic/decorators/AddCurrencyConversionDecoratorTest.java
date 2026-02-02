package pl.put.poznan.transformer.logic.decorators;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.Transformer;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AddCurrencyConversionDecoratorTest {
    @Test
    public void transformTest() {
        Transformer mockTransformer = mock(Transformer.class);
        when(mockTransformer.transform("Cena = $10")).thenReturn("Cena = $10");

        AddCurrencyConversionDecorator decorator = new AddCurrencyConversionDecorator(mockTransformer);
        assertEquals("Cena = 40zł", decorator.transform("Cena = $10"));
    }
}
