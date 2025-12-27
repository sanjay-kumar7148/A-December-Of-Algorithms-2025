import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Day7_BaseballScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replace("[", "").replace("]", "").replace("\"", "").replace("'", "");
            String[] ops;
            if (line.trim().isEmpty()) {
                ops = new String[0];
            } else {
                ops = line.split(",");
            }
            List<Integer> record = new ArrayList<>();
            for (String op : ops) {
                op = op.trim();
                if (op.equals("+")) {
                    int last = record.get(record.size() - 1);
                    int secondLast = record.get(record.size() - 2);
                    record.add(last + secondLast);
                } else if (op.equals("D")) {
                    record.add(2 * record.get(record.size() - 1));
                } else if (op.equals("C")) {
                    record.remove(record.size() - 1);
                } else {
                    record.add(Integer.parseInt(op));
                }
            }
            int sum = 0;
            for (int score : record) sum += score;
            System.out.println(sum);
        }
        sc.close();
    }
}