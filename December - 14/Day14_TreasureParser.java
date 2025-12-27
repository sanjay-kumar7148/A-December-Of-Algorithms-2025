import java.util.*;
public class Day14_TreasureParser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String s = sc.nextLine().trim().replace("\"", "");   
            if (s.isEmpty()) return;
            Object result = parse(s);
            System.out.println(formatOutput(result));
        }
        sc.close();
    }
    public static Object parse(String s) {
        s = s.trim(); 
        if (!s.startsWith("[")) {
            return Integer.parseInt(s);
        }
        Stack<List<Object>> stack = new Stack<>();
        List<Object> current = null;
        StringBuilder num = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue; 
            if (c == '[') {
                List<Object> newList = new ArrayList<>();
                if (current != null) stack.push(current);
                current = newList;
            } else if (c == ']') {
                addNum(current, num);
                if (!stack.isEmpty()) {
                    List<Object> parent = stack.pop();
                    parent.add(current);
                    current = parent;
                }
            } else if (c == ',') {
                addNum(current, num);
            } else if (Character.isDigit(c) || c == '-') {
                num.append(c);
            }
        }
        return current;
    }
    private static void addNum(List<Object> list, StringBuilder num) {
        if (num.length() > 0) {
            list.add(Integer.parseInt(num.toString().trim()));
            num.setLength(0);
        }
    }
    public static String formatOutput(Object obj) {
        if (obj instanceof Integer) return obj.toString();
        List<Object> list = (List<Object>) obj;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(formatOutput(list.get(i)));
            if (i < list.size() - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}