import java.util.Scanner;
import java.util.Arrays;
public class Day28_SweetRewards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] scores = new int[n];
            for(int i=0; i<n; i++) scores[i] = sc.nextInt();
            int[] candies = new int[n];
            Arrays.fill(candies, 1);
            for (int i = 1; i < n; i++) {
                if (scores[i] > scores[i-1]) {
                    candies[i] = candies[i-1] + 1;
                }
            }
            for (int i = n - 2; i >= 0; i--) {
                if (scores[i] > scores[i+1]) {
                    candies[i] = Math.max(candies[i], candies[i+1] + 1);
                }
            }
            int total = 0;
            for (int c : candies) total += c;
            System.out.println(total);
        }
        sc.close();
    }
}
