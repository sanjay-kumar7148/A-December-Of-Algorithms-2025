import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Day9_SumUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            int sum = 0;
            for (int num : nums) {
                if (map.get(num) == 1) {
                    sum += num;
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }
}