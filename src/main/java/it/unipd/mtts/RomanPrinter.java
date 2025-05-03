////////////////////////////////////////////////////////////////////
// Matteo Mazzaretto 2111005
// Marco Brunello 2110997
////////////////////////////////////////////////////////////////////

package it.unipd.mtts;
import java.util.HashMap;
import java.util.Map;

public class RomanPrinter {
   private static final Map<Character, String[]> MAP_ART = new HashMap<>();

   static {
      MAP_ART.put('I', new String[]{
         "III",
         " I ",
         " I ",
         " I ",
         "III"
      });

      MAP_ART.put('V', new String[]{
         "V   V",
         "V   V",
         " V V ",
         " V V ",
         "  V  "
      });

     MAP_ART.put('X', new String[]{
         "X   X",
         " X X ",
         "  X  ",
         " X X ",
         "X   X"
      });
   }

   public static String print(int num) throws RomanException {
      return printAsciiArt(IntegerToRoman.convert(num));
   }

   public static String printAsciiArt(String romanNumber) throws RomanException{
      romanNumber = romanNumber.toUpperCase();
      StringBuilder result = new StringBuilder();
      // Costruzione risultato
      for (int line = 0; line < 5; line++) {
         StringBuilder lineStr = new StringBuilder();
         for (char c : romanNumber.toCharArray()) {
            lineStr.append(MAP_ART.get(c)[line]).append(" ");
         }
         result.append(lineStr).append("\n");
      }
      return result.toString();
   }
}

class RomanException extends Exception {
   public RomanException(String message) {
      super(message);
   }
}
