import java.util.Scanner;
public class Day12_MissingDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i=0; i<n; i++) nums[i] = sc.nextInt();
            int i = 0;
            while (i < n) {
                int correctIdx = nums[i] - 1;
                if (nums[i] != nums[correctIdx]) {
                    int temp = nums[i];
                    nums[i] = nums[correctIdx];
                    nums[correctIdx] = temp;
                } else {
                    i++;
                }
            }
            for (int index = 0; index < n; index++) {
                if (nums[index] != index + 1) {
                    System.out.println("Missing Number: " + (index + 1));
                    System.out.println("Duplicate Number: " + nums[index]);
                    break;
                }
            }
        }
        sc.close();
    }
}