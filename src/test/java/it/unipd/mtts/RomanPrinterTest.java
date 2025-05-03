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
            {3,
            "III III III \n" +
            " I   I   I  \n" +
            " I   I   I  \n" +
            " I   I   I  \n" +
            "III III III \n"
            },
            {9,
            "III X   X \n" +
            " I   X X  \n" +
            " I    X   \n" +
            " I   X X  \n" +
            "III X   X \n"},
            {26,
                "X   X X   X V   V III \n" +
                " X X   X X  V   V  I  \n" +
                "  X     X    V V   I  \n" +
                " X X   X X   V V   I  \n" +
                "X   X X   X   V   III \n"},
            {42,
            "X   X L     III III \n" +
            " X X  L      I   I  \n" +
            "  X   L      I   I  \n" +
            " X X  L      I   I  \n" +
            "X   X LLLLL III III \n"},
            {51, null}
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
