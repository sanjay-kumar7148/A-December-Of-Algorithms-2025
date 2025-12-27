import java.util.Scanner;
public class Day18_MirrorNecklace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String l1 = sc.nextLine();
            int n = Integer.parseInt(l1.split("=")[1].trim());
            if (n == 0) {
                System.out.println("The necklace is empty.");
                return;
            }
            String l2 = sc.nextLine();
            String[] parts = l2.split("=")[1].trim().split("\\s+");
            int[] beads = new int[n];
            for(int i=0; i<n; i++) beads[i] = Integer.parseInt(parts[i]);
            boolean mirrored = true;
            for(int i=0; i<n/2; i++) {
                if (beads[i] != beads[n-1-i]) {
                    mirrored = false;
                    break;
                }
            }
            if (mirrored) System.out.println("The necklace is mirrored.");
            else System.out.println("The necklace is not mirrored.");
        }
        sc.close();
    }
}