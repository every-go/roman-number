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
      convert.put(1, "I");
   }

   public static String convert(int number) throws RomanException{
      String result ="";
      if(number != 1){
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