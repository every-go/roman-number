////////////////////////////////////////////////////////////////////
// Matteo Mazzaretto 2111005
// Marco Brunello 2110997
////////////////////////////////////////////////////////////////////

package it.unipd.mtts;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {

   private static final Map<Integer, String> convert = new LinkedHashMap<>();

   static {
      convert.put(100, "C");
      convert.put(90, "XC");
      convert.put(50, "L");
      convert.put(40, "XL");
      convert.put(10, "X");
      convert.put(9, "IX");
      convert.put(5, "V");
      convert.put(4, "IV");
      convert.put(1, "I");
   }

   public static String convert(int number) throws RomanException{
      String result ="";
      if(number < 1 || number > 100){
         throw new RomanException("Numero fuori dal limite");
      }
      for (Map.Entry<Integer, String> entry : convert.entrySet()) {
         while (number >= entry.getKey()) {
            result += entry.getValue();
            number -= entry.getKey();
         }
      }
   
      return result;
   }
}
