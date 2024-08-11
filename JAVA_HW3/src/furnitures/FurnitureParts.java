package furnitures;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fileIO.FileIO;

public class FurnitureParts{
   public static final Map<String, Map<String, Integer>> furnitureParts = furnitureParts(FileIO.FURNITURE_PARTS);

   private static Map<String, Map<String, Integer>> furnitureParts(ArrayList<ArrayList<String>> furnitureParts) {
      Map <String, Map<String, Integer>> map = new HashMap<>();
      for (ArrayList<String> lines:  furnitureParts) {
        Map<String, Integer> parts = new HashMap<>();
         for (int i = 1; i < lines.size(); i+=2) {
            parts.put(lines.get(i), Integer.parseInt(lines.get(i+1)));
         }
         map.put(lines.get(0), parts);
      }
      return map;
   } 
   
}