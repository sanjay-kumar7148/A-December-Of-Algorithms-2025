import java.util.*;
public class Day13_MountainPeaks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        List<Integer> peaks = new ArrayList<>();
        for (int i = 2; i < n - 1; i++) {
            if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
                peaks.add(i);
            }
        }
        if (peaks.isEmpty()) {
            System.out.println("-1");
        } else {
            System.out.print(peaks.size() + " ");
            for (int i = 0; i < peaks.size(); i++) {
                System.out.print(peaks.get(i) + (i < peaks.size() - 1 ? " " : ""));
            }
            System.out.println();
        }
        sc.close();
    }
}