import java.util.*;
public class Day20_TowerVisibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] heights = new int[n];
            for(int i=0; i<n; i++) heights[i] = sc.nextInt();
            int[] res = new int[n];
            for(int i=0; i<n; i++) res[i] = -1;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                    int idx = stack.pop();
                    res[idx] = heights[i];
                }
                stack.push(i);
            }
            for(int i=0; i<n; i++) {
                System.out.print(res[i] + (i < n - 1 ? " " : ""));
            }
            System.out.println();
        }
        sc.close();
    }
}