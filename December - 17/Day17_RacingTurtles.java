import java.util.*;
public class Day17_RacingTurtles {
    static class Car implements Comparable<Car> {
        int pos, speed;
        public Car(int p, int s) { this.pos = p; this.speed = s; }
        public int compareTo(Car other) {
            return other.pos - this.pos; 
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int target = Integer.parseInt(sc.nextLine().split("=")[1].trim());
            int n = Integer.parseInt(sc.nextLine().split("=")[1].trim());
            if (n == 0) {
                System.out.println("No turtle fleets formed.");
                return;
            }
            String pLine = sc.nextLine().split("=")[1].trim().replace("[", "").replace("]", "");
            String sLine = sc.nextLine().split("=")[1].trim().replace("[", "").replace("]", "");
            String[] pStr = pLine.isEmpty() ? new String[0] : pLine.split(",");
            String[] sStr = sLine.isEmpty() ? new String[0] : sLine.split(",");
            Car[] cars = new Car[n];
            for(int i=0; i<n; i++) {
                cars[i] = new Car(Integer.parseInt(pStr[i].trim()), Integer.parseInt(sStr[i].trim()));
            }
            Arrays.sort(cars);
            int fleets = 0;
            double curTime = 0;
            for (Car c : cars) {
                double time = (double)(target - c.pos) / c.speed;
                if (time > curTime) {
                    fleets++;
                    curTime = time;
                }
            }
            System.out.println("The number of turtle fleets is: " + fleets);
        } catch (Exception e) {}
        sc.close();
    }
}