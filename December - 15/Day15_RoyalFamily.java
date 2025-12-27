import java.util.Scanner;
public class Day15_RoyalFamily {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replace("root =", "").replace("[", "").replace("]", "").trim();
            if (line.isEmpty()) {
                System.out.println("true");
                return;
            }
            String[] parts = line.split(",");
            boolean seenNull = false;
            boolean isComplete = true;
            for (String part : parts) {
                String val = part.trim();
                if (val.equals("null")) {
                    seenNull = true;
                } else {
                    if (seenNull) {
                        isComplete = false;
                        break;
                    }
                }
            }
            System.out.println(isComplete);
        }
        sc.close();
    }
}