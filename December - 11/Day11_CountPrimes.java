import java.util.*;
public class Day11_CountPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        while (sc.hasNext()) {
            String token = sc.next();
            try {
                int n = Integer.parseInt(token);
                System.out.println("The count of prime numbers less than " + n + " is: " + sieve(n));
                break;
            } catch (NumberFormatException e) {
                
            }
        }
        sc.close();
    }
    public static int sieve(int n) {
        if (n <= 2) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean p : isPrime) if (p) count++;
        return count;
    }
}