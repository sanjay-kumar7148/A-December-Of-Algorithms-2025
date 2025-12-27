import java.util.Scanner;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Day10_ZigZagList {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (second != null) {
            ListNode nxt = second.next;
            second.next = prev;
            prev = second;
            second = nxt;
        }
        second = prev;
        ListNode first = head;
        while (second != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;
            first.next = second;
            second.next = t1;
            first = t1;
            second = t2;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) return;
            System.out.print("Enter node values: ");
            ListNode head = new ListNode(sc.nextInt());
            ListNode curr = head;
            for(int i=1; i<n; i++){
                curr.next = new ListNode(sc.nextInt());
                curr = curr.next;
            }
            reorderList(head);
            curr = head;
            while(curr != null){
                System.out.print(curr.val + (curr.next == null ? "" : " "));
                curr = curr.next;
            }
            System.out.println();
        }
        sc.close();
    }
}