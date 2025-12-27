import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Day16_RemoveNthNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String line = sc.nextLine(); 
            int nIndex = line.lastIndexOf("n =");
            String listPart = line.substring(0, nIndex).replace("head =", "").replace("[", "").replace("]", "").replace(",", " ").trim();
            int n = Integer.parseInt(line.substring(nIndex + 3).trim());
            String[] tokens = listPart.isEmpty() ? new String[0] : listPart.split("\\s+");
            if (tokens.length == 0) {
                System.out.println("[]");
                return;
            }
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            for (String t : tokens) {
                curr.next = new ListNode(Integer.parseInt(t));
                curr = curr.next;
            }
            ListNode head = dummy.next;
            ListNode fast = head;
            ListNode slow = head;
            for (int i = 0; i < n; i++) fast = fast.next;
            if (fast == null) {
                head = head.next;
            } else {
                while (fast.next != null) {
                    fast = fast.next;
                    slow = slow.next;
                }
                slow.next = slow.next.next;
            }
            System.out.print("[");
            curr = head;
            while (curr != null) {
                System.out.print(curr.val);
                if (curr.next != null) System.out.print(",");
                curr = curr.next;
            }
            System.out.println("]");
        }
        sc.close();
    }
}