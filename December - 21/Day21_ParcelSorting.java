import java.util.*;
public class Day21_ParcelSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            LinkedList<Integer> queue = new LinkedList<>();
            for(int i=0; i<n; i++) queue.add(sc.nextInt());
            ArrayList<Integer> sortedList = new ArrayList<>();
            for(int i=0; i<n; i++) {
                int minVal = Collections.min(queue);
                while(queue.peek() != minVal) {
                    queue.add(queue.poll());
                }
                sortedList.add(queue.poll());
            }
            for(int i=0; i<n; i++) {
                System.out.print(sortedList.get(i) + (i < n - 1 ? " " : ""));
            }
            System.out.println();
        }
        sc.close();
    }
}
