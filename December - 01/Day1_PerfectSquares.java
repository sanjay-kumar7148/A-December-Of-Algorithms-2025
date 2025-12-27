import java.util.*;
public class Day1_PerfectSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            List<Integer> squares = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {
                squares.add(i * i);
            }
            for (int i = 0; i < squares.size(); i++) {
                System.out.print(squares.get(i) + (i < squares.size() - 1 ? " " : ""));
            }
            System.out.println();
            System.out.println(squares.size());
        }
        sc.close();
    }
}