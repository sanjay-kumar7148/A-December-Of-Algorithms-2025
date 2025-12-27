import java.util.Scanner;
public class Day3_JumpGame {
    public static boolean canReach(int[] stones) {
        int maxReach = 0;
        for (int i = 0; i < stones.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + stones[i]);
            if (maxReach >= stones.length - 1) return true;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String input = sc.nextLine();
            String arrayPart = input.split("=")[1].trim(); 
            String numbers = arrayPart.replace("[", "").replace("]", "").trim();
            if (numbers.isEmpty()) {
                System.out.println("Array is empty.");
                return;
            }
            String[] numStrings = numbers.split(",");
            int[] stones = new int[numStrings.length];
            for (int i = 0; i < numStrings.length; i++) {
                stones[i] = Integer.parseInt(numStrings[i].trim());
            }
            System.out.print("Processed Stones: ");
            for (int stone : stones) System.out.print(stone + " ");
            System.out.println();
            System.out.println("Can reach end: " + canReach(stones));
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input format. Please use 'stones = [2,3,1,1,4]'");
        } finally {
            sc.close();
        }
    }
}