package linkedlists.revisit;

public class LenghtOfLoop {
    public int findLengthOfLoop(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // No cycle
        if (fast == null || fast.next == null) {
            return 0;
        }
        int loopLength = 1;
        ListNode temp = slow.next;
        while (temp != slow) {
            temp = temp.next;
            loopLength++;
        }
        return loopLength;
    }
}
