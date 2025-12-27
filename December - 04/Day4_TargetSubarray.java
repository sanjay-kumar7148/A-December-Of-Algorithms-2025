import java.util.*;
public class Day4_TargetSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++) arr[i] = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            int currentSum = 0;
            map.put(0, -1);
            boolean found = false;
            for (int i = 0; i < n; i++) {
                currentSum += arr[i];
                if (map.containsKey(currentSum - k)) {
                    System.out.println((map.get(currentSum - k) + 1) + " " + i);
                    found = true;
                    break;
                }
                if (!map.containsKey(currentSum)) {
                    map.put(currentSum, i);
                }
            }
            if (!found) System.out.println("-1 -1");
        }
    }
}