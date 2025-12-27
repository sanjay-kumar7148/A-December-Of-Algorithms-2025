import java.util.*;
public class Day2_NumberSystems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                String decimal = String.valueOf(i);
                String octal = Integer.toOctalString(i);
                String hex = Integer.toHexString(i).toUpperCase();
                String binary = Integer.toBinaryString(i);
                System.out.println(decimal + "\t" + octal + "\t" + hex + "\t" + binary);
            }
        }
        sc.close();
    }
}