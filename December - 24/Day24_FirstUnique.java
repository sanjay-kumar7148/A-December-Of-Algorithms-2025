import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;
public class Day24_FirstUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            String s = sc.next();
            Map<Character, Integer> counts = new LinkedHashMap<>();
            for (char c : s.toCharArray()) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
            for (char c : s.toCharArray()) {
                if (counts.get(c) == 1) {
                    System.out.println("The first non-repeating character is: " + c);
                    return;
                }
            }  
            System.out.println("No non-repeating character found.");
        }
        sc.close();
    }
}