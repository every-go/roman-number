package it.unipd.mtts;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RomanPrinterTest {
    private final int input;
    private final String expectedOutput;

    public RomanPrinterTest(int input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
            {0, null},
            {1,
            "III \n" +
            " I  \n" +
            " I  \n" +
            " I  \n" +
            "III \n"
            },
            {2, null}
        });
    }

    @Test
    public void testPrint() {
        try {
            String result = RomanPrinter.print(input);
            if (expectedOutput == null) {
                throw new AssertionError("Doveva lanciare RomanException per input: " + input);
            }
            assertEquals(expectedOutput, result);
        } catch (RomanException e) {
            if (expectedOutput != null) {
                throw new AssertionError(
                    "Lancio inaspettato di RomanException per input " + input + ": " + e.getMessage()
                );
            }
        }
    }
}
