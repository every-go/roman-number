package it.unipd.mtts;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IntegerToRomanTest {
    private final int input;
    private final String expectedOutput;

    public IntegerToRomanTest(int input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
            { 1, "I" },
            {5, null} //DEVE lanciare un'eccezione
        });
    }

    @Test
    public void testConvert() {
        try {
            String result = IntegerToRoman.convert(input);
            if (expectedOutput == null) {  // Caso in cui deve lanciare eccezione
                throw new AssertionError("Doveva lanciare RomanException per input: " + input);
            }
            assertEquals(expectedOutput, result);
        } catch (RomanException e) {
            if (expectedOutput != null) {  // Se NON era un caso che doveva fallire
                throw new AssertionError(
                    "Lancio inaspettato di RomanException per input " + input + ": " + e.getMessage()
                );
            }
        }
    }
}