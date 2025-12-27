import java.util.Scanner;
public class Day8_CafeteriaQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] students = parseArray(sc.nextLine());
        int[] sandwiches = parseArray(sc.nextLine());
        int zeros = 0, ones = 0;
        for (int s : students) {
            if (s == 0) zeros++;
            else ones++;
        }
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (zeros > 0) zeros--;
                else break;
            } else {
                if (ones > 0) ones--;
                else break;
            }
        }
        System.out.println(zeros + ones);
        sc.close();
    }
    private static int[] parseArray(String line) {
        line = line.replace("[", "").replace("]", "").trim();
        if (line.isEmpty()) return new int[0];
        String[] parts = line.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }
}