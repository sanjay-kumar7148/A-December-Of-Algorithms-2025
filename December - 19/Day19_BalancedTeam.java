import java.util.Scanner;
public class Day19_BalancedTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] skills = new int[n];
            int sum = 0;
            for(int i=0; i<n; i++) {
                skills[i] = sc.nextInt();
                sum += skills[i];
            }
            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            for (int skill : skills) {
                for (int j = target; j >= skill; j--) {
                    if (dp[j - skill]) {
                        dp[j] = true;
                    }
                }
            }
            int bestSum = 0;
            for (int i = target; i >= 0; i--) {
                if (dp[i]) {
                    bestSum = i;
                    break;
                }
            }
            System.out.println(sum - 2 * bestSum);
        }
        sc.close();
    }
}